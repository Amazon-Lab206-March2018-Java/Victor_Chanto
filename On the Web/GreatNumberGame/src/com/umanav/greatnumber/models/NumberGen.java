package com.umanav.greatnumber.models;

import java.util.Random;

public class NumberGen {
	private int number;

	public NumberGen() {
	}

	public int getNumber() {
		return number;
	}

	public int setNumber() {
		Random rand = new Random();
		int number = rand.nextInt(100) + 1;
		return number;
	}	
}
