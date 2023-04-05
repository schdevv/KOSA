package javaexam1;

public class Test04 {

	public static void main(String[] args) {
		
		int inx = 1;
		double sum = 0;

		while (inx <= 100) {
			sum += inx;
			inx++;
		}
		System.out.println(sum);
		System.out.println((sum / (inx - 1)));

	}

}
