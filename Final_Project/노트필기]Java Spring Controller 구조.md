### 1. Java Spring Controller 구조
#### 1) 게시판
```java

@RestController
@RequestMapping(value = "/board")
@CrossOrigin(origins = "${auth.allowOrigin}", allowCredentials = "true")
publlic class BoardController {

   priate Logger log = LogManager.getLogger("base");

   @Autowired
   private BoardService service;

   // 커뮤니티 전체 게시글 가져오기
   @GetMapping("/article")
   public ResponseEntity<BasicResponseEntity<Object>> getCommunityList(@RequestParam("page") int page,
                        @Request("size") int size,
                        Authentication authentication) {
                  pagingEntity criteria = new PagingEntity();
                  criteria.setpageNum(page);
                  criteria.setAmount(size);

                  List<BoardList> Result = service.getListPaging(criteria);
                  int total = service.getArticlsesCount();

                  BasicResponseEntity<Object> respBody = null;
                  int respCode = 0;

                  if (result != null) {
                     log.debug("전체게시글 조회 성공");

                     Map<String, object> payload = new HashMap<String, object>();
                     payload.put("total", total);
                     payload.put("list", result);

                     respBody = new BasicResponseEntity<Object>(true, "전체 커뮤니티 게시글 조회 성공", payload);
                     respCode = HttpServletResponse.SC_OK;

                  } else {
                     log.debug("전체 게시글 조회 실패");
                     respBody = new BasicResponseEntity<Object>(false, "전체 커뮤니티 게시글 조회 실패", null);
                     respCode = HttpServletResponse.SC_BAD_REQUEST;
                  }

                  HttpHeaders headers = new HttpHeaders();
                  headers.setContentType(new MediaType("application", "json", Charest.forName("UTF-8")));

                  return new ResponseEntity<BasicResponseEntity<Object>>(respBody, headers, respCode);
               }
 

}

```
```
게시글 구조

ResponseEntity  = (HttpBody, HttpHeader, HttpStatus) 정보를 갖는 클래스.
ResponseEntity<BasicResponseEntoty<Object>> = 편하게 사용하기위해 만든 패키지 = 상태확인 boolean / msg / 데이터의 집합인 T payload 로 구성됨.


1. 생성 = post 매핑 
 1) 생성자 Responseentity 클래스에 미리 만들어놓은 Basic...클래스를 object 타입으로 주입 (object는 모든 타입을 다룸)
 2) 생성자로 handler 메서드를 만들고 메서드에는 클라이언트의 request 내용을 갖게끔 @RequestBody로 Reply 클래스 타입을 갖는 replyContent 객체를 주입) 
 3) 해당 핸들러 메서드가 호출되면 아래의 기능을 함
 4) 생성 메서드에 리턴 타입을 주입한 서비스를 boolean 타입의 result 인스턴스 생성 = 결과 데이터 호출
 5) 서버 상태를 출력할 int 타입의 respCode 객체를 생성 
 6) response body 객체를 Basic.. Object 타입의 null 값의 객체를 생성 (= 리스폰 타입을 지정)

 7) 조건식 : 
  - if (result == true) {
     결과값이 1일 때, 만들어놓은 인스턴스들의 변화
respBody = new Basic...Object 객체를 생성 ( true, "msg" , result 
respCode = 서버의 상태를 나타내는 HttpServletResponse.SC_OK 등 코드를 작성.

 8) HttpHeaders 클래스의 headers 객체를 생성하고 headers에 setContentType 메서드를 사용해 MediaType을 "application", "json", charset"UTF-8"로 설정해줌.

 9) 결과값을 return new Resp..<object>(respBody, headers, respCode)를 리턴함.

```
