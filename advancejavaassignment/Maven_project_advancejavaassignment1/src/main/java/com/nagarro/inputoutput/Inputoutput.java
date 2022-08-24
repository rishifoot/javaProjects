package com.nagarro.inputoutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.nagarro.comparator.PriceComparator;
import com.nagarro.comparator.RatingComparator;
import com.nagarro.exception.TshirtinputValidation;
import com.nagarro.model.Tshirt;
import com.nagarro.watcher.Watcher;

public class Inputoutput {
	private String color;
	private String gender;
	private String size;
	private String outputpreference;

	Scanner scanner=new Scanner(System.in);
	public void Tshirtsearchinput() {
		System.out.println("Enter color: ");
		color=scanner.next().toLowerCase();
		System.out.println("Enter size ( S,M,L,XL,XXL): ");
		size=scanner.next().toLowerCase();
		System.out.println("Enter gender (M,F,U): ");
		gender=scanner.next().toLowerCase();
		System.out.println("Enter output prefernce(price-sort by price| rating-sort by rating): ");
		outputpreference=scanner.next();
		TshirtinputValidation exception=new TshirtinputValidation();
		exception.isInputValid(size, gender, outputpreference);
		
		
		
	}
	public void Tshirtsearchoutput() {
		List<Tshirt> tshirtoutput=new ArrayList<Tshirt>();
		for(String key:Watcher.tshirtData.keySet()) {
			List<Tshirt> data=Watcher.tshirtData.get(key);
			for(int i=0;i<data.size();i++) {


				if(color.equalsIgnoreCase(data.get(i).getColor())&&size.equalsIgnoreCase(data.get(i).getSize())&&gender.equalsIgnoreCase(data.get(i).getGender())&&data.get(i).getAvailability().equalsIgnoreCase("y")) {
					tshirtoutput.add(data.get(i));
					

				}
			}
		}
		if(tshirtoutput.size()==0) {
			System.out.println(" Tshirt of your preference is not available");
		}
		else {
			if(outputpreference.equals("price")) {
				Collections.sort(tshirtoutput,new PriceComparator());
			}
			else if(outputpreference.equals("rating")) {
				Collections.sort(tshirtoutput,new RatingComparator());
			}
			for(Tshirt t:tshirtoutput) {
				System.out.println("Name "+ t.getName()+ "price "+ t.getPrice()+ "Rating " + t.getRating());
			}
			System.out.println();
			
		}
	}
}
