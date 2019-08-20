package com.codingdojo.calculator;

public class Calculator implements java.io.Serializable {
	private double operand1;
	private double operand2;
	private String operation;
	private double result;
	
	public Calculator() {
	}
	
	public Calculator(double operand1, double operand2, String operation) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operation = operation;
	}

	public void setOperand1(double operand1) {
		this.operand1 = operand1;
	}


	public void setOperand2(double operand2) {
		this.operand2 = operand2;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public double getResult() {
		System.out.println(this.result);
		return this.result;
	}
	
	public void performOperation() {
		if (operation.equals("+")) {
			this.result = operand1 + operand2;
		}
		if (operation.equals("-")) {
			this.result = operand1 - operand2;
		}
	}
}
