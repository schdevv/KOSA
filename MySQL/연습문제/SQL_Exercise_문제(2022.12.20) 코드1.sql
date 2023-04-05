USE EMP;

-- 1번문제 30번 부서의 직무별 평균 급여 파악
-- 출력 컬럼명 : 직무, 급여평균
-- 연봉의 평균은 백단위까지 출력
-- 직무 / 급여평균
-- 셀리리맨 1400
-- 매니져 2800
-- 클리크 900

SELECT *
FROM emp;

SELECT job AS '직무', TRUNCATE(CAST(AVG(sal) AS UNSIGNED INT), -2) AS '급여 평균'
FROM EMP 
WHERE deptno = 30
GROUP BY job;


-- 2번 문제
-- 근무 중인 직원 4명이 이상인 부서의 정보를 출력
-- 부서명, 직원수
SELECT D.dname AS '부서명', COUNT(D.dname)  AS '직원 수'  
FROM DEPT D
	INNER JOIN emp E
    ON D.deptno = E.deptno
GROUP BY dname
HAVING COUNT(D.dname) >= 4;

-- 3번 문제 직무별 급여의 합 // 최하단 토탈값 // 천단위 콤마 

(SELECT JOB AS '직무명', FORMAT(SUM(SAL), 0) AS '급여의 합'  
FROM EMP
GROUP BY job
ORDER BY job ASC)

UNION 

(SELECT 'TOTAL', FORMAT(SUM(SAL), 0)
FROM EMP
);

-- 4번 문제 월급을 제일 많이 받는 사람의 이름과 월급 / 급여등급을 출력
SELECT *
FROM SALGRADE

SELECT *
FROM emp;



SELECT ename AS '직원명', MAX(sal) AS '급여', MAX(S.grade) AS '급여등급' 
FROM emp E
	INNER JOIN SALGRADE S 
	ON E.sal BETWEEN losal AND hisal;
    
SELECT ENAME AS "직원명", MAX(SAL) AS "급여", MAX(S.GRADE) AS "급여 등급"
FROM emp E
	 INNER JOIN SALGRADE S
     ON E.SAL BETWEEN losal AND hisal;


-- 5번 문제 // 1981년 입사한 직원들의 이름을 급여 많은 순서로 출력
-- 급여는 sal + com으로 계산, com이 null이면 0으로 계산
-- 천단위마다 , // 뒤에는 '원' 을 분여 출력

UPDATE emp
SET COMM = 0
WHERE COMM IS NULL;

SELECT ename AS '직원명', CONCAT(FORMAT((sal+comm), 0), "원") AS '급여' 
FROM emp
WHERE YEAR(hiredate) = 1981
ORDER BY sal+comm DESC;


-- 6번 문제 
-- 그룹 'A' = 입사년도 1980 
-- 그룹 'B' = 입사년도 1981
-- 그룹 'C' = 입사년도 1982
-- 그룹 'D' = 입사년도 1983
-- 출력 컬럼명 : "직원명", "입사년월일", "그룹"
-- 입사년월일: xxxx년 xx월 xx일로 표현

SELECT ename AS '직원명', CONCAT(YEAR(hiredate), "년 ", 
						DATE_FORMAT(hiredate, '%m'), "월 ", 
						DATE_FORMAT(hiredate, '%d'), "일 ") AS "입사년월일",
CASE WHEN YEAR(hiredate) = 1980 THEN 'A' 
	 WHEN YEAR(hiredate) = 1981 THEN 'B'
     WHEN YEAR(hiredate) = 1982 THEN 'C'
     WHEN YEAR(hiredate) = 1983 THEN 'D' END AS "그룹"
FROM emp;

-- 문제7. 사원번호 / 사원이름 / 관리자 번호 / 사원이름 / 관리자가 없는 직원은 제외

SELECT E1.empno AS '사원 번호', E1.ename AS '사원 이름', E2.empno AS '관리자 사번', E2.ename AS '관리자 이름'
FROM emp E1
	INNER JOIN emp E2
	ON E1.mgr = E2.empno;

SELECT *
FROM dept

SELECT E.empno, E.ename, E.deptno 
FROM emp E
	INNER JOIN dept D
	ON E.deptno = D.deptno
	INNER JOIN locations L
	ON D.loc_code = L.loc_code
WHERE city = 'CHICAGO'



-- CHICAHO 라는 도시에서 근무중인 직원의 사번, 성명, 부서번호 출력 (JOIN 구문)

SELECT E.empno, E.ename, E.deptno
FROM emp E
 	INNER JOIN dept D
    ON E.deptno = D.deptno
	INNER JOIN locations L
    ON D.loc_code = L.loc_code
WHERE city = 'CHICAGO';

-- 9번 문제
-- 30번 부서의 직원들의 급여보다 많은 급여를 받는 직원들의 이름을 출력

SELECT ename, sal
FROM emp
WHERE sal > (
	SELECT MAX(SAL) 
	FROM emp 
	WHERE DEPTNO = 30) AND DEPTNO != 30;
    
    SELECT enam, sal, deptno
    FROM emp 
    GROUP BY deptno 
    HAVING deptno >= 30


-- 

SELECT * FROM emp
SELECT * FROM hiredate
SELECT * FROM LOCATIONS
SELECT * FROM dept