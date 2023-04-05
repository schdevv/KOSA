package example.main;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {

	public static void main(String[] args) {
		
		// 간단하게 책을 조회하고 삭제처리하는 데이터베이스 처리를
		// MyBatis를 이용해서 해보아요!
		
		// DAO만 만들어서 처리해 보아요!(Controller와 Service는 배제)
		
		// 1. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요!
		// DAO부터 생성해서 처리하면 될 거 같아요!
		// 기존에는 DAO한테 connection을 넘겨줬어요!
		// 이번에는 DAO에게 SqlSessionFactory를 넘겨줄꺼예요!
		
		SqlSessionFactory factory = 
				MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory);
		
//		HashMap<String, Object> map = dao.selectByISBNHashMap("89-7914-206-4");
//		
//		for(String key: map.keySet()) {
//			System.out.println(key + ", " + map.get(key));
//		}
		
		// 2. 조건 없이 모든 책의 데이터를 가져와서 출력하세요!
		// DAO부터 생성해서 처리하면 될 거 같아요!
		// 이번에는 DAO에게 SqlSessionFactory를 넘겨줄꺼예요!
//		List<HashMap<String, Object>> list = dao.selectAllHashMap();
//		
//		for(HashMap<String, Object> map: list) {
//			for(String key: map.keySet()) {
//				System.out.println(key + ", " + map.get(key));
//			}
//		}
		
		// 3. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요!
		//    이번에는.. HashMap이 아니라 VO를 이용할꺼예요!
//		BookVO book = dao.selectByISBNBookVO("89-7914-206-4");
//		System.out.println(book.getBtitle() + ", " + book.getBauthor());

		// 4. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하세요!
		//    이번에는.. HashMap이 아니라 VO를 이용할꺼예요!
//		BookVO book = dao.selectByISBNResultMap("89-7914-206-4");
//		System.out.println(book.getBtitle() + ", " + book.getBauthor());

		// 5. 책의 ISBN을 이용해서 책 1권의 데이터를 업데이트할꺼예요!
		//    update하면..결과가 int로 나와요!
		BookVO book = new BookVO();
		book.setBisbn("89-7914-206-4");
		book.setBtitle("자바30일완성!!");
		book.setBauthor("신사임당");
		book.setBprice(3000);
		
		int result = dao.updateByISBN(book);
		System.out.println("영향을 받은 행의 수 : " + result);
		
	}
}





