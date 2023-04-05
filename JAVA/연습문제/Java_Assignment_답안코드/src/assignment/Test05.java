package assignment;

public class Test05 {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c = 0;
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		c = Integer.parseInt(args[2]);

		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		System.out.println("최대값은 " + max + "입니다.");

		int min = a;
		if (b < min)
			min = b;
		if (c < min)
			min = c;
		System.out.println("최소값은 " + min + "입니다.");
	}

}
