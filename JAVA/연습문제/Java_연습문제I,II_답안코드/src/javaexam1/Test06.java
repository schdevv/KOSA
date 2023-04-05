package javaexam1;

public class Test06 {

	public static void main(String[] args) {
		
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		double sum = 0;
		for (int inx = 0; inx < array.length; inx++) {
			if (array[inx] % 2 == 0) {
				continue;
			}
			System.out.println(array[inx]);
			sum += array[inx];
		}
		System.out.println("합계:" + sum);
	}

}
