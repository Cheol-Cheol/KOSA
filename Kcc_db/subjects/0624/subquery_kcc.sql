-- �μ���ȣ 30�� �ִ�޿��� ���� �޿��� ���� ����� ����϶�. (1)
SELECT
    *
FROM
    EMP
WHERE
    SAL > ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );


-- �μ���ȣ 30�� �ִ�޿��� ���� �޿��� ���� ����� ����϶�. (1)
SELECT
    *
FROM
    EMP
WHERE
    SAL < ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );

-- ���ϴð� ������ ������(mgr)�� ������ �����鼭 ������ ���� ����� �˻��϶�.(1)
SELECT
    *
FROM
    EMP
WHERE
        ENAME != '���ϴ�'
    AND ( MGR,
          DNO ) = (
        SELECT
            MGR,
            DNO
        FROM
            EMP
        WHERE
            ENAME = '���ϴ�'
    );
    
-- ȭ�а� �л��� ������ ������ �л��� �˻��϶�. (63)
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != 'ȭ��'
    AND AVR IN (
        SELECT
            AVR
        FROM
            STUDENT
        WHERE
            MAJOR = 'ȭ��'
    );

-- ȭ�а� �л��� ���� �г⿡�� ������ ������ �л��� �˻��϶�. (18)
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != 'ȭ��'
    AND ( SYEAR, AVR ) IN (
        SELECT
            SYEAR, AVR
        FROM
            STUDENT
        WHERE
            MAJOR = 'ȭ��'
    );
    
-- �⸻��� ��ռ����� '��ȭ��' ���� ��� �������� ����� �����ȣ, �����, ��米���� �˻��϶�. (11)
SELECT
    C.CNO,
    C.CNAME,
    P.PNAME
FROM
    SCORE     SC,
    COURSE    C, 
    PROFESSOR P
WHERE
        SC.CNO = C.CNO
    AND C.PNO = P.PNO
GROUP BY
    C.CNO,
    C.CNAME,
    P.PNAME
HAVING
    AVG(RESULT) > (
        SELECT
            AVG(RESULT)
        FROM
            SCORE  SC,
            COURSE C
        WHERE
            SC.CNO = C.CNO
        GROUP BY
            CNAME
        HAVING
            CNAME = '��ȭ��'
    );