package com.umanav.calculator;

public class Main {

	public static void main(String[] args) {
		Calculator op1 = new Calculator();
		op1.setOperandOne(10.5);
		op1.setOperation('+');
		op1.setOperandTwo(5.2);
		op1.performOperation();
		op1.getResults();
	}

}
