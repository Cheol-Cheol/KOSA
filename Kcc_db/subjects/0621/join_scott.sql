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
--select d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, d.deptno, losal, hisal, grade, e.mgr, e.ename
--from dept d, emp e1, emp e2, salgrade
--where d.deptno = e.deptno

SELECT d.deptno,d.dname,e1.empno,e1.ename,e1.mgr,e1.sal,d2.deptno,sa.losal,sa.hisal,sa.grade,e2.empno MRG_EMPNO, e2.ename MGR_ENAME
FROM emp e1, dept d,emp e2,salgrade sa,dept d2
WHERE d.deptno = e1.deptno(+)
AND e1.mgr = e2.empno(+)
AND e1.sal BETWEEN sa.losal(+) AND sa.hisal(+)
AND e2.deptno = d2.deptno(+)
ORDER BY d.deptno, e1.empno;


