-- ���� kcc> �۰� ������ �����ϴ� ������ �˻��϶�.
SELECT
    P.PNO,
    P.PNAME,
    C.CNAME
FROM
         PROFESSOR P
    JOIN COURSE C ON P.PNO = C.PNO
WHERE
    P.PNAME = '�۰�';
    
-- ���� kcc> ������ 2������ ����� �̸� �����ϴ� ������ �˻��϶�.
SELECT
    C.CNAME,
    P.PNAME
FROM
    COURSE    C,
    PROFESSOR P
WHERE
        C.PNO = P.PNO
    AND C.ST_NUM = 2;

-- ���� kcc> ȭ�а� 1�г� �л��� �⸻��� ������ �˻��϶�.
SELECT
    S.SNAME,
    SC.RESULT
FROM
    STUDENT S,
    SCORE   SC
WHERE
        S.SNO = SC.SNO
    AND SYEAR = 1
    AND MAJOR = 'ȭ��';
        
        
-- ���� kcc> ȭ�а� 1�г� �л��� �����ϴ� ������ �˻��϶�. (3�� ���̺� ����)
SELECT DISTINCT
    ( C.CNAME )
FROM
    STUDENT S,
    SCORE   SC,
    COURSE  C
WHERE
        S.SNO = SC.SNO
    AND SC.CNO = C.CNO
    AND MAJOR = 'ȭ��'
    AND SYEAR = 1;

-- kcc> �л� �߿� ���������� �˻��϶�.
SELECT DISTINCT
    ( S1.SNAME )
FROM
    STUDENT S1,
    STUDENT S2
WHERE
        S1.SNAME = S2.SNAME
    AND S1.SNO != S2.SNO;
    
    
-- kcc> ��ϵ� ���� ���� ��� ������ �˻��϶�(������� ���� ������ ����϶�)
SELECT
    P.PNAME,
    C.*
FROM
    COURSE    C,
    PROFESSOR P
WHERE
    P.PNO = C.PNO (+);

-- ANSI
SELECT
    P.PNAME,
    C.*
FROM
    PROFESSOR P
    LEFT JOIN COURSE    C ON P.PNO = C.PNO;

SELECT
    C.CNO,
    C.CNAME,
    P.PNO,
    P.PNAME
FROM
    COURSE    C
    FULL JOIN PROFESSOR P ON C.PNO = P.PNO;


-- �� ����
SELECT
    S.SNAME,
    SC.RESULT,
    GRADE
FROM
    STUDENT S,
    SCORE   SC,
    SCGRADE
WHERE
        S.SNO = SC.SNO
    AND SC.RESULT BETWEEN LOSCORE AND HISCORE;