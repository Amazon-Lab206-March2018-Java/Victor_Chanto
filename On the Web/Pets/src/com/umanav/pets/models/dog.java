package com.umanav.pets.models;

public class dog extends animal implements pet {

	public dog(String name, String breed, int weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showAffection() {
		if (super.getWeight()>30) {
			return "The dog "+super.getName()+ " is hopping in your legs";
		}
		else {
			return "The dog "+super.getName()+ " is curling up next to you";
		}
		// TODO Auto-generated method stub
	}
	

}
