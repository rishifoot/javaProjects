package com.nagarro.comparator;

import java.util.Comparator;

import com.nagarro.model.Tshirt;

public class RatingComparator implements Comparator<Tshirt> {
	public int compare(Tshirt t1, Tshirt t2) {
		if(t1.getRating()>t2.getRating())
			return 1;
		else 
			return -1;
		
	}
}
