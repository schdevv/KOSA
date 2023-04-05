package javaexam1.tv;

public class TvTest {
	
	public static void main(String args[]) {

		Tv tvArray[] = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		int sum = 0;
		for (int inx = 0; inx < tvArray.length; inx++) {
			System.out.println(tvArray[inx].toString());
			sum += tvArray[inx].getPrice();
		}
		System.out.println("가격의 합:" + sum);
	}

}
