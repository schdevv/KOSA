package assignment;

public class Test01 {
	
	public static void main(String[] args) {
		double data1 = Double.parseDouble(args[0]);
		double data2 = Double.parseDouble(args[1]);
		double result = data1 % data2;
		if (result > 1) {
			System.out.println("나머지가 1보다 크다");
		} else if (result <= 1) {
			System.out.println("나머지가 1보다 작거나 같다");
		}
	}

}
