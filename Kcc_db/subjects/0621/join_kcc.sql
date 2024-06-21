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
    