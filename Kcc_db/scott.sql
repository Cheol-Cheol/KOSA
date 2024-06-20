-- emp테이블을 사용하여 20번, 30번 부서에 근무하고 있는 사원 중 급여(sal가 2000 초과인 사원을
-- 다음 두 가지 방식의 select문을 사용하여 사원번호, 급여, 부서번호를 출력하라.
-- 1. 집합연산자를 사용하지 않은 방식
SELECT
    EMPNO,
    SAL,
    DEPTNO
FROM
    EMP
WHERE
    DEPTNO IN ( 20, 30 )
    AND SAL >= 2000;
-- 2. 집합연산자를 사용한 방식
SELECT
    EMPNO,
    SAL,
    DEPTNO
FROM
    EMP
WHERE
        DEPTNO = 20
    AND SAL > 2000
UNION
SELECT
    EMPNO,
    SAL,
    DEPTNO
FROM
    EMP
WHERE
        DEPTNO = 30
    AND SAL > 2000;

SELECT
    *
FROM
    EMP;
--1. 문제) 부서번호가 10번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라
SELECT
    EMPNO AS 사원번호,
    ENAME AS 이름,
    SAL   AS 월급
FROM
    EMP
WHERE
    DEPTNO = 10;
--2. 문제) 사원번호가 7369인 사람 중 이름, 입사일, 부서번호를 출력하라.
SELECT
    ENAME    AS 이름,
    HIREDATE AS 입사일,
    DEPTNO   AS 부서번호
FROM
    EMP
WHERE
    EMPNO = '7369';
--3. 문제) 이름이 ALLEN인 사람의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    ENAME = 'ALLEN';
--5. 문제) 직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    JOB != 'MANAGER';
--6. 문제) 입사일이 81/04/02 이후에 입사한 사원의 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE >= '81/04/02'
ORDER BY
    HIREDATE;
--7. 문제) 급여가 $800 이상인 사람의 이름, 급여, 부서번호를 출력하라.
SELECT
    ENAME  AS 이름,
    SAL    AS 급여,
    DEPTNO AS 부서번호
FROM
    EMP
WHERE
    SAL >= 800;
--8. 문제) 부서번호가 20번 이상인 사원의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    DEPTNO >= 20;
--10. 문제) 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE <= '81/12/09'
ORDER BY
    HIREDATE DESC;
--11. 문제) 입사번호가 7698보다 작거나 같은 사람들의 입사번호와 이름을 출력하라.
SELECT
    MGR   AS 입사번호,
    ENAME AS 이름
FROM
    EMP
WHERE
    MGR <= 7698;
--12. 문제) 입사일이 81/04/02 보다 늦고 82/12/09 보다 빠른 사원의 이름, 월급, 부서번호를 출력하라.
SELECT
    ENAME  AS 이름,
    SAL    AS 월급,
    DEPTNO AS 부서번호
FROM
    EMP
WHERE
    HIREDATE BETWEEN '81/04/02' AND '82/12/09';
--13. 문제) 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하라.
SELECT
    ENAME AS 이름,
    JOB   AS 직업,
    SAL   AS 급여
FROM
    EMP
WHERE
        SAL >= 1600
    AND SAL < 3000;
--14. 문제) 사원번호가 7654와 7782 사이 이외의 사원의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    EMPNO BETWEEN 7654 AND 7782;
--15. 문제) 이름이 B와 J 사이의 모든 사원의 정보를 출력하라.
SELECT
    *
FROM
    EMP;
--16. 문제) 입사일이 81년 이외에 입사한 사람의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE NOT BETWEEN '81/01/01' AND '81/12/31';
--17. 문제) 직업이 MANAGER와 SALESMAN인 사람의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    JOB IN ( 'MANAGER', 'SALESMAN' );
--18. 문제) 부서번호와 20, 30번을 제외한 모든 사람의 이름, 사원번호, 부서번호를 출력하라.
SELECT
    ENAME,
    EMPNO,
    DEPTNO
FROM
    EMP
WHERE
    DEPTNO NOT IN ( 20, 30 );
--19. 문제) 이름이 S로 시작하는 사원의 사원번호, 이름, 입사일, 부서번호를 출력하라.
SELECT
    EMPNO,
    ENAME,
    HIREDATE,
    DEPTNO
FROM
    EMP
WHERE
    ENAME LIKE 'S%';
--20. 문제) 입사일이 81년도인 사람의 모든 정보를 출력하라
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE BETWEEN '81/01/01' AND '81/12/31';
--21. 문제) 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라
SELECT
    *
FROM
    EMP
WHERE
    ENAME LIKE '%S%';
--23. 문제) 첫 번째 문자는 관계없고, 두 번째 문자가 A인 사람의 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    ENAME LIKE '_A%';
--24. 문제) 커미션이 NULL인 사람의 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    COMM IS NULL;
--25. 문제) 커미션이 NULL이 아닌 사람의 모든 정보를 출력하라.
SELECT
    *
FROM
    EMP
WHERE
    COMM IS NOT NULL;
--26. 문제) 부서가 30번 부서이고 급여가 $1,500 이상인 사람의 이름, 부서 ,월급을 출력하라.
SELECT
    ENAME,
    DEPTNO,
    SAL
FROM
    EMP
WHERE
        DEPTNO = 30
    AND SAL >= 1500;
--27. 문제) 이름의 첫 글자가 K로 시작하거나 부서번호가 30인 사람의 사원번호, 이름, 부서번호를 출력하라.
SELECT
    EMPNO,
    ENAME,
    DEPTNO
FROM
    EMP
WHERE
    ENAME LIKE 'K%'
    OR DEPTNO = 30;
--28. 문제) 급여가 $1,500 이상이고 부서번호가 30번인 사원 중 직업이 MANAGER인 사람의 정보를 출력하라
SELECT
    *
FROM
    EMP
WHERE
        SAL >= 1500
    AND EMPNO = 30
UNION
SELECT
    *
FROM
    EMP
WHERE
    JOB = 'MANAGER';
--29. 문제) 부서번호가 30인 사람 중 사원번호 SORT하라.
SELECT
    *
FROM
    EMP
WHERE
    DEPTNO = 30
ORDER BY
    EMPNO;
--30. 문제) 급여가 많은 순으로 SORT하라.
SELECT
    *
FROM
    EMP
ORDER BY
    SAL DESC;



--  240620

--scott>emp테이블 job컬럼 문자열 중 1)첫 번째부터 시작해서 두 번째 문자까지, 2)5번째 문자 이후 문자 출력
SELECT
    JOB,
    SUBSTR(JOB, 1, 2),
    SUBSTR(JOB, 5),
    SUBSTR(JOB, - 3)
FROM
    EMP;

-- Q1_1.
SELECT
    EMPNO,
    RPAD(SUBSTR(EMPNO, 1, 2), LENGTH(EMPNO), '*') AS "masking_empno",
    ENAME,
    RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') AS "masking_ename"
FROM
    EMP
WHERE
        LENGTH(ENAME) >= 5
    AND LENGTH(ENAME) < 6;

-- Q1_2.
SELECT
    EMPNO,
    ENAME,
    SAL,
    TRUNC(SAL / 21.5, 2)     AS "DAY_PAY",
    ROUND(SAL / 21.5 / 8, 1) AS "TIME_PAY"
FROM
    EMP;

-- Q1_3.
SELECT
    EMPNO,
    ENAME,
    HIREDATE,
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '월요일'), 'YYYY-MM-DD') AS "r_job",
    NVL(TO_CHAR(COMM), 'N/A')                                       AS "COMM"
FROM
    EMP;
    
-- Q1_4.
SELECT
    EMPNO,
    ENAME,
    MGR,
    CASE
        WHEN MGR IS NULL THEN
            '0000'
        WHEN SUBSTR(MGR, 1, 2) = '75' THEN
            '5555'
        WHEN SUBSTR(MGR, 1, 2) = '76' THEN
            '6666'
        WHEN SUBSTR(MGR, 1, 2) = '77' THEN
            '7777'
        WHEN SUBSTR(MGR, 1, 2) = '78' THEN
            '8888'
        ELSE
            TO_CHAR(MGR)
    END AS "CHG_MGR"
FROM
    EMP;


-- Q2_1.
SELECT
    DEPTNO,
    ROUND(AVG(SAL)) AS AVG_SAL,
    MAX(SAL)        AS MAX_SAL,
    MIN(SAL)        AS MIN_SAL,
    COUNT(*)        AS CNT
FROM
    EMP
GROUP BY
    DEPTNO;

-- Q2_2. 
SELECT
    JOB,
    COUNT(*)
FROM
    EMP
GROUP BY
    JOB
HAVING
    COUNT(*) >= 3;

-- Q2_3.
SELECT
    TO_CHAR(HIREDATE, 'YYYY') AS "hire_year",
    DEPTNO,
    COUNT(*)                  AS "cnt"
FROM
    EMP
GROUP BY
    HIREDATE,
    DEPTNO;

-- Q2_4.
SELECT
    NVL2(COMM, 'O', 'X') AS "exist_comm",
    COUNT(*)             AS "cnt"
FROM
    EMP
GROUP BY
    NVL2(COMM, 'O', 'X');    


-- Q2_5.
SELECT
    DEPTNO,
    TO_CHAR(HIREDATE, 'YYYY') AS "hire_year",
    COUNT(*)                  AS "cnt",
    MAX(SAL)                  AS "MAX_SAL",
    SUM(SAL)                  AS "SUM_SAL",
    AVG(SAL)                  AS "AVG_SAL"
FROM
    EMP
GROUP BY
    ROLLUP(DEPTNO,
           TO_CHAR(HIREDATE, 'YYYY'));