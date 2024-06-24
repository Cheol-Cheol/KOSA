-- Q1. 
SELECT
    E.JOB,
    E.EMPNO,
    E.ENAME,
    E.SAL,
    E.DEPTNO,
    D.DNAME
FROM
    EMP  E,
    DEPT D
WHERE
        E.DEPTNO = D.DEPTNO
    AND JOB = (
        SELECT
            JOB
        FROM
            EMP
        WHERE
            ENAME = 'ALLEN'
    );
    
-- Q2. 
SELECT
    E.EMPNO,
    E.ENAME,
    D.DNAME,
    TO_CHAR(E.HIREDATE, 'YYYY-MM-DD') AS HIREDATE,
    D.LOC,
    E.SAL,
    GRADE
FROM
    EMP      E,
    DEPT     D,
    SALGRADE G
WHERE
        E.DEPTNO = D.DEPTNO
    AND SAL BETWEEN G.LOSAL AND G.HISAL
    AND SAL > (
        SELECT
            AVG(SAL)
        FROM
            EMP
    )
ORDER BY
    E.SAL DESC,
    E.EMPNO;
    
    
-- Q3. 
SELECT
    E.EMPNO,
    E.ENAME,
    E.JOB,
    D.DEPTNO,
    D.DNAME,
    D.LOC
FROM
    DEPT D,
    EMP  E
WHERE
        D.DEPTNO = E.DEPTNO
    AND D.DEPTNO = 10
    AND E.JOB NOT IN (
        SELECT
            E.JOB
        FROM
            DEPT D, EMP  E
        WHERE
                D.DEPTNO = E.DEPTNO
            AND D.DEPTNO = 30
    );
    
-- Q4.     
SELECT
    EMPNO,
    ENAME,
    SAL,
    GRADE
FROM
    EMP,
    SALGRADE
WHERE
    SAL BETWEEN LOSAL AND HISAL
    AND SAL > (
        SELECT
            MAX(SAL)
        FROM
            EMP
        WHERE
            JOB = 'SALESMAN'
    );
    