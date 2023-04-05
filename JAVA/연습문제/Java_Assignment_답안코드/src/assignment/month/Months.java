package assignment.month;

import java.util.HashMap;

public class Months {

	private HashMap<Integer, Integer> map = 
			new HashMap<Integer, Integer>();
			
	public Months() {
		map.put(1, 31);
		map.put(2, 29);
		map.put(3, 31);
		map.put(4, 30);
		map.put(5, 31);
		map.put(6, 30);
		map.put(7, 31);
		map.put(8, 31);
		map.put(9, 30);
		map.put(10, 31);
		map.put(11, 30);
		map.put(12, 31);
	}
	
	public int getDays(int months) {
		return map.get(months);
	}
}
