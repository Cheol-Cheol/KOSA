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
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '¿ù¿äÀÏ'), 'YYYY-MM-DD') AS "r_job",
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