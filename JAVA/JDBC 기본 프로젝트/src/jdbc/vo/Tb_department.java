package jdbc.vo;

public class Tb_department {

	private String department_no;
	private String department_name;
	private String category;
	private String open_yn;
	private int capacity;
	
	public void Tb_department() {
		
		
	}

	public Tb_department(String department_no, String department_name, String category, String open_yn, int capacity) {
		super();
		this.department_no = department_no;
		this.department_name = department_name;
		this.category = category;
		this.open_yn = open_yn;
		this.capacity = capacity;
	}

	public String getDepartment_no() {
		return department_no;
	}

	public void setDepartment_no(String department_no) {
		this.department_no = department_no;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOpen_yn() {
		return open_yn;
	}

	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return department_no + "," + department_name + ","
				+ category + "," + open_yn + "," + capacity;
	}
	
	
	
}