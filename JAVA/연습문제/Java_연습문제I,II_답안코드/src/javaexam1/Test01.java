package javaexam1;

public class Test01 {
	
	public static void main(String[] args) {
		
		int data1 = Integer.parseInt(args[0]);
		int result = data1 % 2;
		
		if (result == 0) {
			System.out.println("2의 배수 입니다.");
		} else {
			System.out.println("2의 배수가 아닙니다.");
		}
	}

}
