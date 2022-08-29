package com.nagarro.exception;

import java.util.HashMap;

public class InputValidation {

	public boolean isInputValid(String size, String gender, int ouputPrefer) {

		try {
			return isSizeValid(size) && isGenderValid(gender) && isOuputPreferValid(ouputPrefer);
		} catch (InvalidInputException e) {
			System.err.print(e);
			return false;
		}
	}

	public boolean isSizeValid(String size) throws InvalidInputException {
		if(size.equalsIgnoreCase("s") || size.equalsIgnoreCase("m") ||size.equalsIgnoreCase("l") ||size.equalsIgnoreCase("xl") || size.equalsIgnoreCase("xxl")) {
			return true;
		} else {
			throw new InvalidInputException("Invalid Size Type!!");
		}
	}

	public boolean isGenderValid(String gender) throws InvalidInputException {
		if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("u")) {
			return true;
		} else
			throw new InvalidInputException("Invalid Gender Type!!");
	}

	public boolean isOuputPreferValid(int ouputPrefer) throws InvalidInputException {

		if (ouputPrefer == 1 || ouputPrefer==2) {
			return true;
		} else
			throw new InvalidInputException("Invalid Sorting Preference Type!!");
	}

}
