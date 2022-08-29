package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.model.TShirt;

public class PriceComparator implements Comparator<TShirt> {
	public int compare(TShirt t1, TShirt t2) {
		// TODO Auto-generated method stub
		if(t1.getPrice()>t2.getPrice())
		{
			return 1;
		}
		else
			return -1;
	}

}
