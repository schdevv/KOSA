package javaexam2;

import java.util.StringTokenizer;

public class Test03 {
	
	public static void main(String args[]) {
		String str = "1.22,4.12,5.93,8.71,9.34";
		double data[] = new double[5];
		double sum = 0;
		StringTokenizer st = new StringTokenizer(str, ",");

		for (int i = 0; st.hasMoreElements(); i++) {
			data[i] = Double.parseDouble(st.nextToken());
		}
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		System.out.printf("합계:%.3f", sum);
		System.out.println(" ");
		System.out.printf("평균:%.3f", sum / 5);
	}

}
