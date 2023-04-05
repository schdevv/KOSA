
-- INSERT 구문
-- TABLE안에 데이터를 삽입하는 SQL구문 (DML)

USE sqldb;

-- DDL을 이용해서 TABLE를 하나 생성함
-- DDL은 테이블의 구조를 변경하거나 없애는 처리는 기본적으로 Transaction을 적용할 수 없음.
-- 제약사항(NOT NULL)

CREATE TABLE testtbl1 (
	id 		 INT NOT NULL, 
    username CHAR(3) NOT NULL,
    age 	 INT
);

-- 가장 일반적인 데이터 삽입 방법 : INSERT 

INSERT INTO testtbl1
VALUES (1, '홍길동', 20);

INSERT INTO testtbl1(username, id, age)
VALUES ('최길동', 5, 22);

-- TABLE을 색다르게 만들기 칼럼(column id		int		AUTO_INCREMENT(자동 증가하는 속성) 키실정(PRIMARY KEY 또는 UNIQUE KEY)
CREATE TABLE testtbl2 (
	id		 INT		AUTO_INCREMENT	PRIMARY KEY,
    username CHAR(3),
    age		 INT
);

INSERT INTO testtbl2
VALUES (NULL, '홍길동', 20);

INSERT INTO testtbl2
VALUES (NULL, '링길동', 30);

-- AUTO INCREMENT는 기본적으로 1부터 시작해서 1씩 증가하도록 함a
-- 시작 값과 증가되는 값을 변경할 수 있으나 굳이 변경하지는 않음.
-- 빈자리 생성하는건? 범위값을 지정, 범위값 중 NULL값을 확인, 과거 사용한 번호는 DB에 저장해놓고 중복처리가 안되게끔 지정함, 서버의 NULL값에 새로 생성되는 번호로 저장

SELECT * FROM testtbl2;

SELECT * FROM testtbl1;

-- INSERT -----------------------------------------------------------------------------------

-- 수정 UPDATE 구문

UPDATE testtbl2
SET username = '늙었대'
WHERE age = 30;


-- 삭제하려면 DELETE 구문을 이용함 (NOT DROP = DROP은 구간을 날리는 것)
START TRANSACTION;

DELETE 
FROM testtbl2
WHERE age = 30;

ROLLBACK;

-- 삭제에 관련해서 크게 3가지 명령어(구문) 있음.
-- DELETE (테이블에서 row를 삭제) - TRANSACTION Log를 기록하기 떄문에 처리시간이 오래걸림.
-- DROP (테이블 자체를 삭제)
-- TRUNCATE (테이블에서 row를 삭제) - TRANSACTION Log를 기록하지 않기 때문에 처리시간이 빠르다. 


-- SQL 기본 ------------------------------------------------------------------------

-- SQL 형변환
-- buytbl에서 사용자가 몇개 얼마 샀어요 구문.
-- 도출된 결과값인 실수를 정수로 변환

SELECT AVG(amount) AS '평균 구매 개수'
FROM buytbl;

-- 도출된 결과값인 실수를 정수로 변환 CAST (() AS UNSIGNED INTEGER) = 함수이고 자동으로 반올림 반영
SELECT CAST(AVG(amount) AS UNSIGNED INTEGER) AS '평균 구매 개수'
FROM buytbl;

-- 다양한 구분자로 되어 있는 날짜를 날짜형식으로 바꾸기 = 컴퓨터 연산 적용이 가능함.
SELECT CAST('2022/12/25' AS DATE);

--
SELECT num, 
	   CONCAT(CAST(price AS CHAR(5)), ' * ', CAST(amount AS CHAR(4))) AS '단가 * 수량',
	   price*amount AS '구매액'
FROM buytbl;

-- MYSQL은 묵시형 형 변환이 특이함
-- 외우기 어렵,

SELECT '100' + '200'; -- 300;
SELECT 'HELLO' + 'WORLD78';

SELECT CONCAT('Hello', 'World');
SELECT CONCAT(100, '200');

-- 자바와 다르게 true, false 값이 없음. true = 1 / false = 0
SELECT 3 > '2hoho';

SELECT 0 = 'Hello';

-- ---------------------------------------------

-- MySQL에서 제공되는 함수에 대해서 알아보자
-- 기본함수
-- 칼럼의 글자수를 알고 싶음 (LENGTH : 해당 문자열을 저장하는 Byte(공간)을 나타냄, 영어: 1byte / 한글: 3 byte)
SELECT LENGTH('넓히다') AS '저장소의 Byte용량'; 
SELECT LENGTH('vkdlfhbdkkgd') AS '저장소의 Byte용량'; 

-- 실제 사용하는 함수: CHAR_LENGTH (문자열의 길이)
SELECT CHAR_LENGTH('vkdlfhbdkkgd') AS '문자열의 길이'; 

-- 문자열 합체 : CONCAT / CONCAT_WS('??','','',''); = '??' = 문자 사이에 끼워넣을 문자를 작성함=연결자
SELECT CONCAT('Hello', 'World');
SELECT CONCAT_WS('??', 'Hello', 'World', 'hahaha');

-- 기존 문자열에서 찾고자하는 문자열을 찾아서 그 시작위치를 알려준다. (DMBS 표준은 1부터 시작 / Langaue는 0부터 시작)
SELECT INSTR('이것은 소리없는 아우성!!', '소리') AS '"소리"를 포함한 문장';

-- 숫자의 소수점 아래 자리수까지 표현하는 방법, 3자리마다 콤마도 찍어주기 alter
-- 소수점 3자리까지만 출력문 (당초 123456789.123456789)
SELECT FORMAT(123456789.123456789, 3);


-- ROUND : 실수 날리면서 반올림해서 값을 올림
SELECT ROUND(3.141592);

-- 현재 날짜를 출력함
SELECT CURDATE();

-- 현재 날짜, 시간, 분, 초까지 출력함
SELECT NOW();

SELECT YEAR(CURDATE());
SELECT TIME(NOW());
SELECT MONTH(NOW());
SELECT DAY(NOW());

SELECT ADDDATE('2022-12-22', INTERVAL 956156 DAY);

-- -----------JOIN-------------------------------------------

SELECT *
FROM usertbl;

SELECT *
FROM buytbl;

SELECT *
FROM usertbl 
	  INNER JOIN buytbl
      ON usertbl.userID = buytbl.userID;
      
SELECT usertbl.userID, name
FROM usertbl 
	  INNER JOIN buytbl
      ON usertbl.userID = buytbl.userID;
      
      -- 비표준 축약문, 사용하지 말자.
SELECT usertbl.userID, name
FROM usertbl, buytbl
WHERE usertbl.userID = buytbl.userID;

SELECT U.userID, name
FROM usertbl U
	  INNER JOIN buytbl B
      ON U.userID = B.userID;

-- 문제풀이
-- 물품을 한번이라도 구매한 기록이 있는 회원들에게 감사의 안내문을 발송할거야 
-- 물품을 한번이라도 구매한 사람의 이름과 주소를 출력해라 // 중복제거: DISTINCT

SELECT DISTINCT name, addr
FROM usertbl U
	  INNER JOIN buytbl B
      ON U.userID = B.userID;
      
  -- EXISTS : 존재하면 이란 뜻으로, ()안의 Query 조건이 // 중복이 제거된 이유는?
SELECT U.userID, U.name, U.addr
FROM usertbl U
WHERE EXISTS(
	SELECT *
    FROM buytbl B
    WHERE U.userID = B.userID
);

-- Script ?.?
-- 1. 학생을 기준으로 학생이름, 지역, 동아리, 동아리방 출력alter
-- stdName, addr, clubName, roomNo

SELECT *
FROM stdclubtbl;

SELECT S.stdName, S.addr, SC.clubName, C.roomNo
FROM stdtbl S
	  INNER JOIN stdclubtbl SC
      ON S.stdname = SC.stdname
	  INNER JOIN clubtbl C
      ON SC.clubName = C.clubName;

-- 전체 회원의 구매기록을 조회하시오, 단, 구매기록이 없는 회원도 출력하시오.
-- OUTER JOIN을 이용함.

SELECT *
FROM usertbl U
	LEFT OUTER JOIN buytbl B 
	ON U.userID = B.userID;


-- 한번도 구매이력이 없는 회원의 이름과 주소를 출력하시오.
SELECT *
FROM usertbl U
	LEFT OUTER JOIN buytbl B 
	ON U.userID = B.userID
WHERE B.prodName IS NULL;

SELECT *
FROM buytbl U;
-- Union--------------------------------------------
-- 테이블의 구성은 전체 결과 집합 구조는 위에 결과 집합의 구조를 따라감. // 주의: 위 아래의 컬럼의 개수가 동일해야한다.
-- 위 테이블의 결과집합 데이터 타입과 아래 테이블의 결과집합 타입과 형태가 동일해야함.
-- Union(중복배제), UNION ALL(중복 상관없이 이어붙임)
(SELECT name, height
FROM usertbl
WHERE height > 180)

UNION

(SELECT userid, price
From buytbl
WHERE price > 500);

-- 모든 사용자를 조회하는데 전화가 없는 사람을 제외하고 출력하시오.

SELECT name, CONCAT_WS('-', mobile1, mobile2)
FROM usertbl
WHERE mobile1 IS NOT NULL;
