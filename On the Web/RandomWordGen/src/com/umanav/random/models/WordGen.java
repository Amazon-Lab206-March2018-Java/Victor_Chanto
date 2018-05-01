package com.umanav.random.models;

public class WordGen {
	private String word;

	public WordGen() {
	}

	public String getWord() {
		return word;
	}

	public String setWord() {
		for(int i = 0; i < 7; i++) {
		    word += (char)(Math.random() * 26 + 97);
		}
		return word;
	}
	
}


