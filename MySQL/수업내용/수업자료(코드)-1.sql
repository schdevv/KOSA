-- SELECT = Serch   * : 아스테리스크 : 모든 데이터를 가져옴
-- 일반적인 DBMS의 SQL은 대소문자를 구분하지 않음
-- 데이터베이스를 선택하는 구문

USE shopdb; 


SELECT *
FROM memberTBL;

-- View 생성
-- View 
-- AS = View의 설명/기능
CREATE VIEW v_memberTBL 
AS
	SELECT memberID, memberName
    FROM memberTBL;

SELECT *
FROM v_memberTBL;


-- 구분자라는 뜻의 명령어 : defult 구분자(;)를 원하는 명령어로 "ex) //" 변경하는 기능

-- 하나의 프로시져(PROCEDURE) 함수(mycall()) 를 생성한 것.
DELIMITER // 
CREATE PROCEDURE mycall()
-- {}의 역할: BEGIN / END
BEGIN
	SELECT memberName
    FROM membertbl
    WHERE memberID='hong';
    
    SELECT memberName
    FROM membertbl
    WHERE memberID='shin';
END //
DELIMITER ;

CALL mycall();

-- -----------------------------------------------------------------

-- 임시 테이블을 하나를 만들어
-- memberTBL에서 회원이 삭제되면 삭제된 회원정보를 다른 table에 저장한다. (1명 삭제, ??)

CREATE TABLE deleteMemberTBL (
	-- 컬럼명  데이터타입  제약사항,(=> Not Null이냐 그런 것) [구문 작성법]
	memberID CHAR(8) PRIMARY KEY,
    memberName CHAR(4) NOT NULL,
    memberAddr VARCHAR(20)
); 

-- 어디에 부착할지
-- 테이블에서 뭔가가 삭제된 이후에 동작한다.'
-- 지워진 행 하나씩에 대해서
-- Values(OLD)를 INSERT INTO에 동작시킴
DELIMITER //
CREATE TRIGGER trg_memberTBL 
	AFTER DELETE 
    ON memberTBL 
    FOR EACH ROW
BEGIN
	INSERT INTO deleteMemberTBL VALUES(
		OLD.memberID, OLD.memberName, OLD.memberAddr
        );
END //
DELIMITER ;

DELETE 
FROM memberTBL
WHERE memberID = 'hong';

SELECT *
FROM memberTBL;

SELECT *
FROM deleteMemberTBL;

    

-- 새로운 테이블을 만들어서
-- 아래에서 가져온 데이터를 입력해보자

-- 테이블 만들기
CREATE TABLE shopdb.indexTBL (
	first_name  VARCHAR(14),
    last_name   VARCHAR(16),
    hire_date   DATE
);

-- 만든 테이블에 데이터 입력
INSERT INTO shopdb.indexTBL
	SELECT first_name, last_name, hire_date
    FROM employees.employees
    LIMIT 500;
    
-- 들어갔는지 확인
SELECT * FROM shopdb.indexTBL;


USE sqldb;

START TRANSACTION;

SELECT *
FROM usertbl;

DELETE
FROM usertbl;

ROLLBACK;

SELECT *
FROM usertbl;

-- commit(작업한 SQL구문을 정말로 적용함), rollback(Transaction으로 설정된 작업을 무시함)


    
    
    



