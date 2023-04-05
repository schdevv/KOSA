package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {
	
	public static void main(String[] args) {
		// 특정 책을 지울거에요
		try {
			
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
			String id = "root";
			String pw = "test1234";
			
			// 2단계. 데이터베이스 연결
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			con.setAutoCommit(false); // Transaction 시작.
			
			
			// 3.Preparedstatement 생성
			String sql = "DELETE FROM book WHERE btitle like ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%여행%");
			
			// 4. 실행
			int count = pstmt.executeUpdate();
			// 리턴(결과)값은 정수로 들어옴
			// 영향을 받는 row의 수
			
			// 5. 결과처리
			System.out.println("삭제한 Row의 수는 : " + count);
			// con.commit(); // transaction을 종료하고 지금까지 실행한 SQL문을 실제로 DB에 적용함.
			con.rollback(); // transaction을 종료하고 지금까지 실행한 SQL문을 무효화함.
			// 만약 transaction을 종료하지 않고 connection을 close 하게되면, 
			// Auto Commit Mode로 인해 자동으로 commit 함.
			System.out.println("힝 속았지");
			
			
			// 6. 사용한 자원 반납
			pstmt.close();
			con.close();
			System.out.println("연결 종료");
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
