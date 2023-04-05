package javaexam1;

public class Test02 {
	
	public static void main(String[] args) {
		
		int data1 = Integer.parseInt(args[0]);
		int data2 = Integer.parseInt(args[1]);
		int result = data1 * data2;
		
		if (1 <= result && result < 10) {
			System.out.println("한자리 수 입니다.");			
		} else if (10 <= result && result < 100) {
			System.out.println("두자리 수 입니다.");
		}
	}

}
