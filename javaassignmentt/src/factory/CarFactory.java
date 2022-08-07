package factory;

import carInsurance.CarInsurance;
import carTypes.HATCHBACK;
import carTypes.SEDAN;
import carTypes.SUV;

public class CarFactory {
	public CarInsurance getCarInsurance(String carTypes) {
		if(carTypes==null)
			return null;
		switch(carTypes) {
		case "SUV":
			return new SUV();
		case "SEDAN":
			return new SEDAN();
		case "HATCHBACK":
			return new HATCHBACK();
		default:
		     throw new IllegalArgumentException("Unknown carTypes "+carTypes);
		
		
		}
	}

}
