-- Q1
SELECT
    D.DEPTNO,
    D.DNAME,
    E.EMPNO,
    E.ENAME,
    E.SAL
FROM
    EMP  E,
    DEPT D
WHERE
        E.DEPTNO = D.DEPTNO
    AND E.SAL > 2000;
    
-- Q2
SELECT
    D.DEPTNO,
    D.DNAME,
    ROUND(AVG(E.SAL)),
    MAX(E.SAL),
    MIN(E.SAL),
    COUNT(*)
FROM
    EMP  E,
    DEPT D
WHERE
    E.DEPTNO = D.DEPTNO
GROUP BY
    D.DEPTNO, D.DNAME;
    
    
-- Q3
select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
from emp e, dept d
where e.deptno(+) = d.deptno
order by d.deptno, e.ename;

-- Q4
select d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, d.deptno, losal, hisal, grade, e.mgr, e.ename
from dept d, emp e1, emp e2, salgrade
where d.deptno = e.deptno
