package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.model.TShirt;

public class RatingComparator implements Comparator<TShirt>{
	public int compare(TShirt t1, TShirt t2) {
		if(t1.getRating()>t2.getRating())
			return 1;
		else 
			return -1;
		
	}

}
