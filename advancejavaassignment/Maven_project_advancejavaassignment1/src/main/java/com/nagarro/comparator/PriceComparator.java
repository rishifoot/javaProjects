package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.model.Tshirt;

public class PriceComparator implements Comparator<Tshirt> {

	
	public int compare(Tshirt t1, Tshirt t2) {
		// TODO Auto-generated method stub
		if(t1.getPrice()>t2.getPrice())
		{
			return 1;
		}
		else
			return -1;
	}

}
