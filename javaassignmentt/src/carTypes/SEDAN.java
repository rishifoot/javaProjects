package carTypes;

import carInsurance.CarInsurance;

public class SEDAN implements CarInsurance{

	@Override
	public double calculateCarInsurance(double costPrice, String insuranceType) {
		double ans=0.0;
		ans=(8*costPrice)/100;
		if(insuranceType.equals("PREMIUM")) {
			ans=ans+(20*ans)/100;
		}
		return ans;
	}

}
