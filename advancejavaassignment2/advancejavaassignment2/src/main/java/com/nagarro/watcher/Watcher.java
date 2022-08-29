package com.nagarro.watcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.nagarro.dao.TshirtDaoImp;
import com.nagarro.model.TShirt;
import com.nagarro.model.TShirtCode;
import com.opencsv.CSVReader;

public class Watcher implements Runnable {


	private TshirtDaoImp dao = new TshirtDaoImp();

	Map<String, String> code = new HashMap<String, String>();

	public Thread watcherThread;

	public static Map<String, List<TShirt>> tShirtCollection = new HashMap<String, List<TShirt>>();

	public Watcher() {
		watcherThread = new Thread(this);
	}

	public static List<String> nameOfFiles() {
//			File dir = new File("./src/main/java/resources");
		File dir = new File("src\\main\\resources");
		List<String> namesOfFile = new ArrayList<String>();
		if (dir.isDirectory()) {
			String[] files = dir.list();
			Pattern p = Pattern.compile("^(.*?)\\.csv$");

			for (String file : files) {
				Matcher m = p.matcher(file);
				if (m.matches()) {
					namesOfFile.add(m.group(1));

				}

			}
		}

		return namesOfFile;
	}

	public void dataEntry() throws IOException {

		tShirtCollection.clear();

		List<String> namesOfFile = nameOfFiles();
		
		//Getting Session For Adding data in DataBase
		
		dao.getSessionWithTransaction();
		dao.beginTransaction();

		for (int i = 0; i < namesOfFile.size(); i++) {

			List<String[]> myEntries;
			FileReader file = new FileReader("src\\main\\resources\\" + namesOfFile.get(i) + ".csv");

			CSVReader reader = new CSVReader(file, ',');

			myEntries = reader.readAll();

			List<TShirt> f = new ArrayList<TShirt>();
			String identity = myEntries.get(1)[0].substring(0, 2);
			
			TShirtCode tshirtCode = new TShirtCode();
			tshirtCode.setBrandCode(identity);
			tshirtCode.setBrandName(namesOfFile.get(i));
			
			
			code.put(namesOfFile.get(i) + ".csv", identity);

			int lineCount = 0;

			for (String[] csvFileData : myEntries) {
				if (lineCount != 0) {
					TShirt temp = new TShirt();
					temp.setId(csvFileData[0]);
					temp.setName(csvFileData[1]);
					temp.setColor(csvFileData[2]);
					temp.setGender(csvFileData[3]);
					temp.setSize(csvFileData[4]);
					temp.setPrice(Float.parseFloat(csvFileData[5]));
					temp.setRating(Float.parseFloat(csvFileData[6]));
					temp.setAvailability(csvFileData[7]);
					temp.setTShirtbrandCode(tshirtCode);
					f.add(temp);
					dao.saveData(temp);
				}
				lineCount++;
			}
			tshirtCode.setTshirt(f);
			tShirtCollection.put(identity, f);
			reader.close();
			file.close();
		}
		dao.commitSession();

	}

	public void dataEntry(String newFile) throws IOException {
		// TODO Auto-generated method stub

		List<String[]> myEntries;
//			FileReader file = new FileReader("./src/main/java/resources/" + namesOfFile.get(i) + ".csv");
		FileReader file = new FileReader("src\\main\\resources\\" + newFile);
		CSVReader reader = new CSVReader(file, ',');
		myEntries = reader.readAll();
		List<TShirt> f = new ArrayList<TShirt>();
		String identity = myEntries.get(0)[0].substring(0, 2);
		code.put(newFile, identity);
		
//		if(!dao.getCurrentSession().isOpen())
//		{
//			dao.getSessionWithTransaction();
//		}
		
		TShirtCode tshirtCode = new TShirtCode();
		tshirtCode.setBrandCode(identity);
		tshirtCode.setBrandName(newFile.substring(0, newFile.length()-4));

		int lineCount = 0;

		for (String[] csvFileData : myEntries) {
			if (lineCount != 0) {
				TShirt temp = new TShirt();
				temp.setId(csvFileData[0]);
				temp.setName(csvFileData[1]);
				temp.setColor(csvFileData[2]);
				temp.setGender(csvFileData[3]);
				temp.setSize(csvFileData[4]);
				temp.setPrice(Float.parseFloat(csvFileData[5]));
				temp.setRating(Float.parseFloat(csvFileData[6]));
				temp.setAvailability(csvFileData[7]);
				temp.setTShirtbrandCode(tshirtCode);
				f.add(temp);
				dao.saveData(temp);
			}
			lineCount++;
		}
		tShirtCollection.put(identity, f);
		tshirtCode.setTshirt(f);
		reader.close();
		file.close();
		dao.beginTransaction();
		dao.commitSession();
	}
	

	public void run() {
		// TODO Auto-generated method stub
		try {
			dataEntry();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			Map<WatchKey, Path> keyMap = new HashMap<>();
//			Path path = Paths.get("./src/main/java/resources");
			Path path = Paths.get("src\\main\\resources");

			keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);
			WatchKey watchKey;
			do {
				watchKey = service.take();
				// @SuppressWarnings("unused")
				Path eventDir = keyMap.get(watchKey);
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
						String fileName = eventPath.toString();
						String key = code.get(fileName);
						tShirtCollection.remove(key);
						code.remove(fileName);
						String fileToDelete = fileName.substring(0, fileName.length()-4);
						
						TShirtCode tshirtCode = dao.getCurrentSession().get(TShirtCode.class, fileToDelete);
						dao.getCurrentSession().delete(tshirtCode);
						tshirtCode.tshirt.clear();
						dao.beginTransaction();
						dao.commitSession();
						
					} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

						Path child = eventDir.resolve(eventPath);
						String newFileName = child.getFileName().toString();
						if (eventPath.toString().endsWith(".csv")) {
							String fileName = eventPath.toString();
							String key = code.get(fileName);
							tShirtCollection.remove(key);
							
							String fileToDelete = fileName.substring(0, fileName.length()-4);
							
							TShirtCode tshirtCode = dao.getCurrentSession().get(TShirtCode.class, fileToDelete);
							if(tshirtCode!=null)
							{
								dao.getCurrentSession().delete(tshirtCode);
								tshirtCode.tshirt.clear();
								dao.beginTransaction();
								dao.commitSession();
							}
							
							dataEntry(newFileName);
						}
					}
				}

			} while (watchKey.reset());
		} catch (IOException | InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
