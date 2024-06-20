-- emp���̺��� ����Ͽ� 20��, 30�� �μ��� �ٹ��ϰ� �ִ� ��� �� �޿�(sal�� 2000 �ʰ��� �����
-- ���� �� ���� ����� select���� ����Ͽ� �����ȣ, �޿�, �μ���ȣ�� ����϶�.
-- 1. ���տ����ڸ� ������� ���� ���
SELECT
    EMPNO,
    SAL,
    DEPTNO
FROM
    EMP
WHERE
    DEPTNO IN ( 20, 30 )
    AND SAL >= 2000;
-- 2. ���տ����ڸ� ����� ���
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
--1. ����) �μ���ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�
SELECT
    EMPNO AS �����ȣ,
    ENAME AS �̸�,
    SAL   AS ����
FROM
    EMP
WHERE
    DEPTNO = 10;
--2. ����) �����ȣ�� 7369�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶�.
SELECT
    ENAME    AS �̸�,
    HIREDATE AS �Ի���,
    DEPTNO   AS �μ���ȣ
FROM
    EMP
WHERE
    EMPNO = '7369';
--3. ����) �̸��� ALLEN�� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    ENAME = 'ALLEN';
--5. ����) ������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    JOB != 'MANAGER';
--6. ����) �Ի����� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE >= '81/04/02'
ORDER BY
    HIREDATE;
--7. ����) �޿��� $800 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����϶�.
SELECT
    ENAME  AS �̸�,
    SAL    AS �޿�,
    DEPTNO AS �μ���ȣ
FROM
    EMP
WHERE
    SAL >= 800;
--8. ����) �μ���ȣ�� 20�� �̻��� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    DEPTNO >= 20;
--10. ����) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE <= '81/12/09'
ORDER BY
    HIREDATE DESC;
--11. ����) �Ի��ȣ�� 7698���� �۰ų� ���� ������� �Ի��ȣ�� �̸��� ����϶�.
SELECT
    MGR   AS �Ի��ȣ,
    ENAME AS �̸�
FROM
    EMP
WHERE
    MGR <= 7698;
--12. ����) �Ի����� 81/04/02 ���� �ʰ� 82/12/09 ���� ���� ����� �̸�, ����, �μ���ȣ�� ����϶�.
SELECT
    ENAME  AS �̸�,
    SAL    AS ����,
    DEPTNO AS �μ���ȣ
FROM
    EMP
WHERE
    HIREDATE BETWEEN '81/04/02' AND '82/12/09';
--13. ����) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����϶�.
SELECT
    ENAME AS �̸�,
    JOB   AS ����,
    SAL   AS �޿�
FROM
    EMP
WHERE
        SAL >= 1600
    AND SAL < 3000;
--14. ����) �����ȣ�� 7654�� 7782 ���� �̿��� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    EMPNO BETWEEN 7654 AND 7782;
--15. ����) �̸��� B�� J ������ ��� ����� ������ ����϶�.
SELECT
    *
FROM
    EMP;
--16. ����) �Ի����� 81�� �̿ܿ� �Ի��� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE NOT BETWEEN '81/01/01' AND '81/12/31';
--17. ����) ������ MANAGER�� SALESMAN�� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    JOB IN ( 'MANAGER', 'SALESMAN' );
--18. ����) �μ���ȣ�� 20, 30���� ������ ��� ����� �̸�, �����ȣ, �μ���ȣ�� ����϶�.
SELECT
    ENAME,
    EMPNO,
    DEPTNO
FROM
    EMP
WHERE
    DEPTNO NOT IN ( 20, 30 );
--19. ����) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �μ���ȣ�� ����϶�.
SELECT
    EMPNO,
    ENAME,
    HIREDATE,
    DEPTNO
FROM
    EMP
WHERE
    ENAME LIKE 'S%';
--20. ����) �Ի����� 81�⵵�� ����� ��� ������ ����϶�
SELECT
    *
FROM
    EMP
WHERE
    HIREDATE BETWEEN '81/01/01' AND '81/12/31';
--21. ����) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�
SELECT
    *
FROM
    EMP
WHERE
    ENAME LIKE '%S%';
--23. ����) ù ��° ���ڴ� �������, �� ��° ���ڰ� A�� ����� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    ENAME LIKE '_A%';
--24. ����) Ŀ�̼��� NULL�� ����� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    COMM IS NULL;
--25. ����) Ŀ�̼��� NULL�� �ƴ� ����� ��� ������ ����϶�.
SELECT
    *
FROM
    EMP
WHERE
    COMM IS NOT NULL;
--26. ����) �μ��� 30�� �μ��̰� �޿��� $1,500 �̻��� ����� �̸�, �μ� ,������ ����϶�.
SELECT
    ENAME,
    DEPTNO,
    SAL
FROM
    EMP
WHERE
        DEPTNO = 30
    AND SAL >= 1500;
--27. ����) �̸��� ù ���ڰ� K�� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ, �̸�, �μ���ȣ�� ����϶�.
SELECT
    EMPNO,
    ENAME,
    DEPTNO
FROM
    EMP
WHERE
    ENAME LIKE 'K%'
    OR DEPTNO = 30;
--28. ����) �޿��� $1,500 �̻��̰� �μ���ȣ�� 30���� ��� �� ������ MANAGER�� ����� ������ ����϶�
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
--29. ����) �μ���ȣ�� 30�� ��� �� �����ȣ SORT�϶�.
SELECT
    *
FROM
    EMP
WHERE
    DEPTNO = 30
ORDER BY
    EMPNO;
--30. ����) �޿��� ���� ������ SORT�϶�.
SELECT
    *
FROM
    EMP
ORDER BY
    SAL DESC;



--  240620

--scott>emp���̺� job�÷� ���ڿ� �� 1)ù ��°���� �����ؼ� �� ��° ���ڱ���, 2)5��° ���� ���� ���� ���
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
    TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 3), '������'), 'YYYY-MM-DD') AS "r_job",
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