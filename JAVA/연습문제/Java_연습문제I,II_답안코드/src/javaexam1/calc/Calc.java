package javaexam1.calc;

public class Calc {
	
	public Calc() {

	}

	public int sum(int a, int b) {
		int result = 0;
		result = a + b;
		return result;
	}

	public int subtract(int a, int b) {
		int result = 0;
		result = a - b;
		return result;
	}

	public int multiply(int a, int b) {
		int result = 0;
		result = a * b;
		return result;
	}

	public int divide(int a, int b) {
		int result = 0;
		if (b <= 0) {
			result = 0;
		} else {
			result = a / b;
		}
		return result;
	}

}
