package carTypes;

import carInsurance.CarInsurance;

public class HATCHBACK implements CarInsurance {

	@Override
	public double calculateCarInsurance(double costPrice, String insuranceType) {
		double ans=0.0;
		ans=(5*costPrice)/100;
		if(insuranceType.equals("PREMIUM")) {
			ans=ans+(20*ans)/100;
		}
		return ans;
	}

}
