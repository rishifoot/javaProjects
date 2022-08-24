package com.nagarro.watcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.model.Tshirt;
import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvException;

public class Watcher implements Runnable {
	Map<String, String> productCode = new HashMap<String, String>();

	public static Map<String,List<Tshirt>> tshirtData=new HashMap<String,List<Tshirt>>();
	public Thread watcherThread;
	public Watcher() {
		watcherThread = new Thread(this);
	}
	public List<String> filesName(){
		File filePath=new File("src\\main\\resources");
		List<String> nameOfFiles=new ArrayList<String>();
		if(filePath.isDirectory()) {
			String[] files=filePath.list();
			Pattern p = Pattern.compile("^(.*?)\\.csv$");
			for (String file : files) {
				Matcher m = p.matcher(file);
				if (m.matches()) {
					nameOfFiles.add(m.group(1));

				}

			}
		}
		return nameOfFiles;
	}
	public void tshirtInput() throws IOException {
		tshirtData.clear();
		List<String> nameOfFiles=filesName();

		
		for (int i = 0; i < nameOfFiles.size(); i++) {
			
			List<String[]> myRecord;
			FileReader file = new FileReader("src\\main\\resources\\" + nameOfFiles.get(i) + ".csv");
			
			CSVReader reader = new CSVReader(file, '|');	
			myRecord = reader.readAll();
			

			
			List<Tshirt> t = new ArrayList<Tshirt>();
			String identity = myRecord.get(1)[0].substring(0, 2);
			productCode.put(nameOfFiles.get(i) + ".csv", identity);
			
			
			int line=0;
			
			for(String[] csvFileData:myRecord)
			{
				if(line!=0)
				{
					Tshirt temp = new Tshirt();
					temp.setId(csvFileData[0]);
					temp.setName(csvFileData[1]);
					temp.setColor(csvFileData[2]);
					temp.setGender(csvFileData[3]);
					temp.setSize(csvFileData[4]);
					temp.setPrice(Float.parseFloat(csvFileData[5]));
					temp.setRating(Float.parseFloat(csvFileData[6]));
					temp.setAvailability(csvFileData[7]);
					t.add(temp);
				}
				line++;
			}
			
			
			tshirtData.put(identity, t);
			reader.close();
			file.close();
		}
	}
	public void tshirtInput(String newFile) throws IOException {
		List<String[]> myRecord;
		FileReader file = new FileReader("src\\main\\resources\\" + newFile);
		
		CSVReader reader = new CSVReader(file, '|');
		
		myRecord = reader.readAll();
		
		List<Tshirt> t = new ArrayList<Tshirt>();
		String identity = myRecord.get(1)[0].substring(0, 2);
		productCode.put(newFile, identity);
		
		
		int line=0;
		
		for(String[] csvFileData:myRecord)
		{
			if(line!=0)
			{
				Tshirt temp = new Tshirt();
				temp.setId(csvFileData[0]);
				temp.setName(csvFileData[1]);
				temp.setColor(csvFileData[2]);
				temp.setGender(csvFileData[3]);
				temp.setSize(csvFileData[4]);
				temp.setPrice(Float.parseFloat(csvFileData[5]));
				temp.setRating(Float.parseFloat(csvFileData[6]));
				temp.setAvailability(csvFileData[7]);
				t.add(temp);
			}
			line++;
		}
		
		tshirtData.put(identity, t);
		reader.close();
		file.close();
	
	
	
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			tshirtInput();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try (WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> keyMap = new HashMap<>();
			Path path = Paths.get("src\\main\\resources");

			keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY), path);
			WatchKey watchKey;
			do {
				watchKey = service.take();
				
				Path eventDir = keyMap.get(watchKey);
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
						String fileName = eventPath.toString();
						String key = productCode.get(fileName);
						tshirtData.remove(key);
						productCode.remove(fileName);
					} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {

						Path child = eventDir.resolve(eventPath);
						String newFileName = child.getFileName().toString();
						if (eventPath.toString().endsWith(".csv")) {
							String fileName = eventPath.toString();
							String key = productCode.get(fileName);
							tshirtData.remove(key);
							tshirtInput(newFileName);
						}
					}
				}

			} while (watchKey.reset());
		} catch (IOException | InterruptedException ex) {
			System.out.println(ex.getMessage());
		} 
		
	}
	

}
