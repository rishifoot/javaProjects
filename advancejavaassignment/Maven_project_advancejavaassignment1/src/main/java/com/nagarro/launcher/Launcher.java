package com.nagarro.launcher;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.nagarro.inputoutput.Inputoutput;
import com.nagarro.watcher.*;

public class Launcher {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		String s="y";
		Inputoutput inputoutput=new Inputoutput();
		Scanner scan=new Scanner(System.in);
		Watcher watch = new Watcher();
		watch.watcherThread.start();
		Thread.sleep(200);
		do {
			inputoutput.Tshirtsearchinput();;
			inputoutput.Tshirtsearchoutput();
			System.out.println("Do you want to continue (y/n): ");
			s=scan.next();
		}while(s.equals("y"));
		scan.close();
		

	}

}
