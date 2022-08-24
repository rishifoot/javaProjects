package com.nagarro.exception;

public class TshirtinputValidation {
	
	public boolean isInputValid(String size,String gender,String outputpreference) {
		try {
			return isTshirtSizeValid(size)&&isGenderValid(gender)&&isOutputpreferenceValid(outputpreference);
		}catch(Exception e) {
			System.out.println("invalid tshirt data");
			return false;
		}
	}
	public boolean isTshirtSizeValid(String size)throws Exception{
		if(size.equalsIgnoreCase("s")|| size.equalsIgnoreCase("m")||size.equalsIgnoreCase("l")||size.equalsIgnoreCase("xl")||size.equalsIgnoreCase("xxl"))
				return true;
		else {
			throw new Exception("Invalid size Type ");
		}
	}
	public boolean isGenderValid(String gender) throws Exception {
		if(gender.equalsIgnoreCase("m")||gender.equalsIgnoreCase("f")||gender.equalsIgnoreCase("u"))
			return true;
		else
			throw new Exception("invalid gender type");
	}
	public boolean isOutputpreferenceValid(String outputpreference)throws Exception {
		if(outputpreference.equalsIgnoreCase("price")||outputpreference.equalsIgnoreCase("rating"))
			return true;
		else
			throw new Exception("invalid preference type");
	}

}

