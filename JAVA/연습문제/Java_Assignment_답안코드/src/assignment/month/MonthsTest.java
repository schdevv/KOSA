package assignment.month;

public class MonthsTest {

	public static void main(String[] args) {
		
		Months months = new Months();
		
		try {
			int month = Integer.parseInt(args[0]);
			if(!(month >= 1 && month <= 12)) {
				System.out.println("입력된 값이 잘못 되었습니다.");
				System.exit(0);
			}
			System.out.println(months.getDays(month) + "일");
		} catch (Exception e) {
			System.out.println("다시 입력해 주세요");
		}
	}
}
