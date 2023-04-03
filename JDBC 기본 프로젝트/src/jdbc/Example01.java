package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Department;

public class Example01 {
	
	public static void main(String[] args) {
		
		try {
			
			// step 1. Driver Loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// step 2. Database Connecting
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/mysql_workshop_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "test1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			// step 3. SQL문으로 Statement 생성.
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT category, department_name, capacity ");
			sql.append("FROM tb_department ");
			sql.append("WHERE category = '공학' and capacity BETWEEN 20 AND 30 ");
			sql.append("ORDER BY department_name ASC ");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			
			// step 4. Start
			ResultSet rs = pstmt.executeQuery();
			
			// step 5. Result
			ArrayList<Department> List = new ArrayList<Department>();
			
			while(rs.next()){
			// Create VO
				Department dept = new Department(rs.getString("department_name"), 
						rs.getString("category"),
						rs.getInt("capacity"));
				
				List.add(dept);
				
			}
			
			for(Department dept: List) {
				System.out.println(dept);
			}
			
	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
