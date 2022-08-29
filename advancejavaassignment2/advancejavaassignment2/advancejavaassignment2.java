package com.nagarro.launcher;

import com.nagarro.exception.InvalidInputException;
import com.nagarro.inputOutput.*;
import com.nagarro.watcher.Watcher;

import java.io.IOException;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) throws IOException, InvalidInputException, InterruptedException {
		// TODO Auto-generated method stub

		// used to create the object the Watcher Class
		Watcher watch = new Watcher();
		Scanner scan=new Scanner(System.in);
		// Starting the watcher thread
		watch.watcherThread.start();
		Thread.sleep(200);

		String choice = "yes";
		InputOutput IO = new InputOutput();
		do {
			IO.input();
			IO.output();
			System.out.println("Do you want to search More (Yes/No) :");
			choice =scan.next();
		} while (choice.equals("yes"));
		
	}

}
