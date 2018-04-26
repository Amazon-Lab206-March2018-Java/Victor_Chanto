package com.umanav.calculator;

public class Calculator implements Operators, java.io.Serializable{
	private double OperandOne;
	private char Operation;
	private double OperandTwo;
	private double Result;
	
	public Calculator() {
	}
	
	
	public double getOperandOne() {
		return OperandOne;
	}


	public void setOperandOne(double operandOne) {
		this.OperandOne = operandOne;
	}


	public char getOperation() {
		return Operation;
	}


	public void setOperation(char operation) {
		this.Operation = operation;
	}


	public double getOperandTwo() {
		return OperandTwo;
	}


	public void setOperandTwo(double operandTwo) {
		this.OperandTwo = operandTwo;
	}


	public double getResult() {
		return Result;
	}


	public void setResult(double result) {
		this.Result = result;
	}


	@Override
	public void performOperation() {
		switch(Operation) {
			case '+':{
				setResult(OperandOne + OperandTwo);}break;
			case '-':{
				setResult(OperandOne - OperandTwo);}break;
			case '*':{
				setResult(OperandOne * OperandTwo);}break;
			case '/':{
				setResult(OperandOne / OperandTwo);}break;
			}
		
	}
	@Override
	public void getResults() {
		System.out.println(Result);
	}
}
