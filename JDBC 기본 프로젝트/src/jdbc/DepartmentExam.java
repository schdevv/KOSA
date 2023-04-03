package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Book;
import jdbc.vo.Tb_department;

public class DepartmentExam {

	public static void main(String[] args) {
		try {
			
			// 1. JDBC Driver Loading 단계
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/mysql_workshop_db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
			String id = "root";
			String pw = "test1234";
			
			// 2. Database 접속
			Connection con = DriverManager.getConnection(jdbc_url, id, pw); 
						
			System.out.println("Database 접속 성공");
			
			
			String sql = "SELECT category AS '계열', department_name AS '학과이름', capacity AS '정원' from tb_department WHERE category = '공학' and (capacity BETWEEN 20 AND 30) ORDER BY department_name ASC;";
		
			PreparedStatement pstmt = con.prepareStatement(sql);

			
			ResultSet rs = pstmt.executeQuery();
			
			
			// 5. 결과처리
			
			ArrayList<Tb_department> list = new ArrayList<Tb_department>();
			
			// 5. 결과처리!
			while(rs.next()) {
				Tb_department tb_department = new Tb_department
					(rs.getInt("capacity"),
						rs.getString("category"),
						rs.getString("department_name"),
						rs.getString("department_no"),
						rs.getString("open_yn"));
				list.add(tb_department);
			}
			
			for(Tb_department tb_department: list) {
				System.out.println(tb_department);
			}
			// 6. 사용한 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			System.out.println("Database 접속 종료");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}