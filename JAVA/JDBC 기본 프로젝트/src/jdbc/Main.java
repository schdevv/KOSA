package jdbc;

import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
		

		
		try {
			// 1. JDBC Driver Loading 단계
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading 성공");
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
					//"jdbc : Protocol" // IP주소: 포트번호/          // ?부터는 속성임
			String id = "root";  
			// root는 데이터베이스를 관리하는 계정명이지만, 예제 직관성을 위해 root 계정으로 표기.
			String pw = "test1234";
			
			//2. Database 접속
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			//해당 클래스가 갖고있는 메서드를 바로 사용함.
			System.out.println("Database 접속 성공");
			
			/* 일반 statment
			 * // 3. Statement 생성 
			 * Statement stmt = con.createStatement();
			 * 
			 * // 4. Query를 작성해서 실행함 ( select 구문을 실행시켰어여) 
			 * String keyword = "자바"; 
			 * String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like '%" +
			 * keyword +"%'"; ResultSet rs = stmt.executeQuery(sql);
			 */
			
			// PreparedStstement로 사용해야 해요
			// PreparedStstement는 SQL을 가지고 생성해욤
			// PreparedStstement는 IN Parameter를 이용할 수 있어요 -> ?로 표현함 (앞으로 채워넣을 명령문을 작성할 수 있게함)
			// 주의해야할 점, keyword 부분(하단 문구에서는 bisbn 등)에는? (IN Parameter)를 쓸 수 없어요.
			String keyword = "자바";
			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ? 내용을 채워 SQL문장을 완성시켜야함.
			pstmt.setString(1, "%" + keyword + "%");  // 1, 첫번쨰 물음표에는 ,값 을 지정
			
			ResultSet rs = pstmt.executeQuery();
			
			// 5. 결과처리
			while (rs.next()){
				String title = rs.getString("btitle");
				System.out.println("책 제목은 : " + title);
			}
			
			// 6. 사용한 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			System.out.println("Database 접속 종료");
			
		/*	// rs.next();
			String Price = rs.getString(3);
			//int price = rs.getInt("bprice");
			  //cousor 컬럼명을 가르킴
	
			System.out.println("책 가격은 : " + Price + "원");
			
			rs.next();
			title = rs.getString("btitle");  //cousor 컬럼명을 가르킴
			System.out.println("책 제목은 : " + title); //
*/		
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// 클래스 명시할 때 네임
		
	}

}
