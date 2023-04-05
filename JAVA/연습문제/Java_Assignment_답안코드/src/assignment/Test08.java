package assignment;

public class Test08 {

	public static void main(String[] args) {
		String str = args[0];
		char[] cha = str.toCharArray();

		for (int inx = cha.length - 1; inx >= 0; inx--) {
			System.out.print(cha[inx]);
		}
	}

}
