package javaexam2.student;

public class Human {
	
	protected String name;
	protected int age;
	protected int height;
	protected int weight;

	public Human() {
	}

	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String printInformation() {
		return name + "  " 
	            + age + "  " 
				+ height + "  "
	            + weight;
	}

}
