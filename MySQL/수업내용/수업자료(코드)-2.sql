-- 사용할 데이터베이스를 지정하는 구문
-- USE 데이터베이스 이름(정의어)
USE employees;

-- SQL은 대소문자 구분하지 않음. 
-- 하지만 가독성(Readablility)를 위해 
-- 키워드는 대문자, 사용자 정의어는 소문자로 사용

-- 데이터베이스 조회
SHOW DATABASES;

-- 테이블의 상태를 조회
SHOW TABLE STATUS;

-- 테이블 명세를 조회
DESC employees;

-- SELECT 구문---------------------------------------------------------------------------
-- 데이터를 추출하기 위해 사용하는 구문
-- SELECT 컬럼명들
SELECT first_name, last_name, birth_date
FROM employees;
-- 이거 실행하면 결과집합이 리턴된다. (출력된다)
-- ResultSet = 결과레코드집합, Result Grid => 테이블처럼 간주할 수 있음. 

-- 만약 결과집합에서 컬럼명을 바꾸고자 한다면
-- Alias를 이용함 = 별명, 별칭의 의미
SELECT first_name AS '나의 이름', 
	   last_name AS '성', 
       birth_date AS '생년월일'
FROM employees;

-- 항상 모든테이터를 가져오는가
-- 만약 조건절이 없으면 당연히 모든 데이터를 가져옴 => 원하는 조건이 있다면 조건절을 사용해야함.

-- dataset 생성.(중도확인 차원으로 데이터 테스트) 
-- table 생성하고 데이터도 INSERT해 놓았음.

-- 이름이 김경호인 사람의 정보를 출력하세요.
SELECT *
FROM usertbl
WHERE name = '김경호';

-- 1970년 이후 출생, 신장 182 인 사람의 아이디와 이름을 조회하시오


SELECT userID, name
FROM usertbl
WHERE (birthYear >= 1970) AND (height >= 182);

-- 키가 180~183인 사람의 이름과 아이디를 조회하시오
SELECT userID, name
FROM usertbl
WHERE (height >= 180) AND (height <= 183);

SELECT userID, name
FROM usertbl
WHERE height BETWEEN 180 AND 183;

-- 지역 경남, 전남, 경북 이름과 지역

SELECT name, addr
FROM usertbl
WHERE (addr = '경남') or (addr = '전남') or (addr = '경북');

SELECT name, addr
FROM usertbl
WHERE addr IN ('경남', '전남', '경북');

-- 패턴 매칭
-- 김씨 성을 가진 사람들의 이름과 키를 조회하세요.
-- 와일드카드( % , _ ) 2가지
-- % : 0개 이상의 문자열을 의미함 = 자바% => 자바로 시작하는 모든 문자열 (조회 결과물: 자바, 자바1, 자바123, 자바이랏샤이마세)
-- %자바% => 자바란 키워드를 포함한 모든 문자열을 출력
-- _ : 1개 이상의 문자열의 개수를 지정해서 조회함 => 자바_ => 자바킹, 자바왕, 자바용 // 자바__ => 자바자바, 자바킹왕, 자바카카 


SELECT name, height
FROM usertbl
WHERE name LIKE '김%';

-- 김경호보다 키가 크거나 같은 사람의 이름과 키를 출력alter
-- SubQuery
-- MAIN // SUB
SELECT name, height
FROM usertbl
WHERE height >= (SELECT height
				 FROM usertbl
				 WHERE name = '김경호');
                 
-- 지역이 '경남'인 사람들의 키보다 크거나 같은 사람의 이름과 키를 조회 = 연산자: ANY();

SELECT name, height
FROM usertbl
WHERE height >= ANY(SELECT height
				 FROM usertbl
				 WHERE addr = '경남');

-- 먼저 가입한 순서대로 회원의 이름과 가입일을 출력해
-- ORDER BY 는 SQL문의 최하단에 위치(정렬)시키는 문구임

SELECT name, mdate, height
FROM usertbl
ORDER BY height DESC;

-- 회원의 이름과 가입일을 출력하는데
-- 키가 큰 순서로 정렬하시오
-- 만약 키가 같으면 가입일이 빠른 순서로 정렬

SELECT name, mdate, height
FROM usertbl
ORDER BY height DESC, mdate ASC;
	
    
-- 회원들의 거주지역이 어디인지 출력
-- 중복배제 키워드 DISTINCT
SELECT DISTINCT addr 
FROM usertbl;

-- 회원가입일이 오래된 사람 3명 출력 //오래되면 ASC 키워드

SELECT *
FROM usertbl
ORDER BY mdate ASC
LIMIT 5;

-- 테이블 복사하는 간단한 방법
CREATE TABLE usertbl2 (
	SELECT *
    FROM usertbl
);
-- 쉽고 간편하게 복사할 수는 있지만,
-- 제약사항(Primary KEY, Foreign KEY 등등)의 설정들은 복사되지 않음.

-- 기본 SQL SELECT 구문임;----------------------------------------------------------------

-- Grouping이 나온다요 : 집계함수가 같이 따라나옴 = row의 집합체에서 칼럼을 구함
-- 구매테이블에서 사용자가 구매한 물품의 개수를 출력하시오.
-- 각각의 사용자별로 제품은 상관없이 모두 몇개를 구입했는지 ?

SELECT userID, SUM(amount) AS '총 구매 개수'
FROM buytbl
GROUP BY userID;

-- 각 사용자별 구매액의 총합을 구하고 구매액이 큰 순서로 출력

SELECT userID AS GropID, SUM(price*amount) AS total
FROM buytbl
GROUP BY userID
ORDER BY total DESC;
-- 정렬은 데이터베이스에 부하를 많이 주는 편이라, 처리속도가 저하된다. 꼭 필요한 경우에만 정렬문을 작성함

-- 사이트에서 평균적으로 한 사람당 몇개씩 구매했는지

SELECT avg(amount)
FROM buytbl;

-- 사용자 테이블에서 가장 큰 키와 작은키의 회원 이름을 출력해
-- 

SELECT userID, name, height
FROM usertbl;

SELECT name, height
FROM usertbl
WHERE height = (
			SELECT MAX(height)
			FROM usertbl) or
	   height = (
			SELECT MIN(height)
			FROM usertbl);

SELECT name, height -- 이름과 신장
FROM usertbl 
WHERE height = (
   SELECT MAX(height)
   FROM usertbl) -- 키가 가장 큰사람과
OR
height = (
  SELECT MIN(height) 
  FROM usertbl -- 키가 가장 작은사람
)

            
-- usertbl에서 휴대폰이 있는 사용자의 수를 구하시오
-- 사용자의 수를 구하는 함수 : count

SELECT COUNT(mobile1)
FROM usertbl;

-- 사용자별 총 구매금액이 1,000원 이상인 사용자의 ID와 금액을 출력하세요.
-- 그룹에 대한 조건문 1가지 (HAVING) / 일반에 대한 조건문 1가지 (WHERE)
-- 

SELECT userID AS GropID, SUM(price*amount) AS total
FROM buytbl
GROUP BY userID
HAVING total >= 1000;

-- 기본적인 SQL 구문의 순서는
-- SELECT = 필수
-- FROM = 꼭 안나와도 됨 (테이블 대상으로 할 시에는 필수)
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY


