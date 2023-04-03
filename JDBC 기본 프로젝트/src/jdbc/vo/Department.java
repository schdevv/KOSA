package jdbc.vo;

public class Department {

	private String department_name;
	private String category;
	private int capacity;
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}


	public Department(String department_name, String category, int capacity) {
		super();
		this.department_name = department_name;
		this.category = category;
		this.capacity = capacity;
	}


	/**
	 * @return the department_name
	 */
	public String getDepartment_name() {
		return department_name;
	}


	/**
	 * @param department_name the department_name to set
	 */
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}


	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Department [department_name=" + department_name + ", category=" + category + ", capacity=" + capacity
				+ "]";
	}
	
	
	
	
}
