package javaexam1;

public class Test03 {
	
	public static void main(String[] args) {
		int result = 0;
		for (int inx = 2; inx <= 5; inx++) {
			for (int jnx = 1; jnx <= 9; jnx++) {
				result = inx * jnx;
				if (result % 2 == 1) {
					System.out.println(inx + "*" + jnx + "=" + result);
				}
			}
		}
	}
}
