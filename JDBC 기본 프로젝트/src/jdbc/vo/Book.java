package jdbc.vo;

// VO는 데이터를 표현하는 객체이다.
// 필드값을 저장하고 표현하는 역할이므로 Business Logic이 나오면 안됨.
// Database의 Table을 참조해서 만들어진다.
public class Book {

	//필드값은 예외없이 private를 사용
	private String bisbn;
	private String btitle;
	private String bauthor;
	private int bprice;
	
		public void book() {
			
		}

		public Book(String bisbn, String btitle, String bauthor, int bprice) {
			super();
			this.bisbn = bisbn;
			this.btitle = btitle;
			this.bauthor = bauthor;
			this.bprice = bprice;
		}

		public String getBisbn() {
			return bisbn;
		}

		public void setBisbn(String bisbn) {
			this.bisbn = bisbn;
		}

		public String getBtitle() {
			return btitle;
		}

		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}

		public String getBauthor() {
			return bauthor;
		}

		public void setBauthor(String bauthor) {
			this.bauthor = bauthor;
		}

		public int getBprice() {
			return bprice;
		}

		public void setBprice(int bprice) {
			this.bprice = bprice;
		}

		@Override
		public String toString() {
			return bisbn + "," + btitle + "," + bauthor + "," + bprice;
		}

		
		
	}
