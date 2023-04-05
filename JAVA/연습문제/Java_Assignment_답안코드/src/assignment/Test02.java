package assignment;

public class Test02 {

	public static void main(String[] args) {

		int numberValue = Integer.parseInt(args[0]);

		int resultValue = 1;

		for (int inx = 1; inx <= numberValue; inx++) {
			resultValue *= inx;
		}

		System.out.print(resultValue);

	}
}
