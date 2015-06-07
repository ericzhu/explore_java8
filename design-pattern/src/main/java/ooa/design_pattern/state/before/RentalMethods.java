package ooa.design_pattern.state.before;

import java.util.Random;

public class RentalMethods {
	
	final static int FULLY_RENTED = 0;
	final static int WAITING = 1;
	final static int GOT_APPLICATION = 2;
	final static int APPARTMENT_RENTED = 3;
	
	Random random;
	int numberOfAppartments;
	
	int state = WAITING;
	
	public RentalMethods(int n) {
		this.numberOfAppartments = n;
		random = new Random(System.currentTimeMillis());
	}
	
	
}
