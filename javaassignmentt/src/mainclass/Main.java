package mainclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import carInsurance.CarInsurance;
import factory.CarFactory;

public class Main {

	public static void main(String[] args) throws IOException {
		 InputStreamReader ir = new InputStreamReader(System. in );
		Scanner scan=new Scanner(System.in);
		BufferedReader br = new BufferedReader(ir);
		String ans="";
		do {
			System.out.println("Enter the details");
			
			String carModel=br.readLine();
			String carType=br.readLine();
			String insuranceType=br.readLine();
			double costPrice=scan.nextDouble();
			
			System.out.println(" carModel "+carModel+ " carType "+carType+ " insuranceType "+insuranceType+" costPrice "+costPrice);
			CarFactory car=new CarFactory();
			CarInsurance carInsu=car.getCarInsurance(carType);
			double cost=carInsu.calculateCarInsurance(costPrice, insuranceType);
			String format="0.00";
			NumberFormat formatter = new DecimalFormat(format);
		
			
			 String newDVal = formatter.format(cost);
			System.out.println(" cost of carInsurance is "+newDVal);
			System.out.println(" Do you want to continue y/n ");
			String si=scan.next();
			ans=si;
		}while(ans.equals("y"));
		

	}

}
 