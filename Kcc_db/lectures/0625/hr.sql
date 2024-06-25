-- ������ ���� ���� -> ���ο� VIEW ���� -> ���� ����(VIEW)
CREATE VIEW EMP_AVG_SAL_VW AS
    SELECT
        E.EMPLOYEE_ID,
        E.LAST_NAME,
        D.DEPARTMENT_NAME,
        E.HIRE_DATE,
        L.CITY,
        E.SALARY
    FROM
        EMPLOYEES   E,
        DEPARTMENTS D,
        LOCATIONS   L
    WHERE
            E.DEPARTMENT_ID = D.DEPARTMENT_ID
        AND D.LOCATION_ID = L.LOCATION_ID
        AND SALARY > (
            SELECT
                AVG(SALARY)
            FROM
                EMPLOYEES
        );


-- employees ���̺����� salary�� ������ VIEW ���� -> ���� ����(VIEW)
CREATE VIEW EMP_EXCLUDE_SAL_VW AS
    SELECT
        EMPLOYEE_ID,
        FIRST_NAME,
        LAST_NAME,
        JOB_ID,
        MANAGER_ID,
        PHONE_NUMBER,
        COMMISSION_PCT,
        EMAIL,
        DEPARTMENT_ID
    FROM
        EMPLOYEES;

SELECT
    *
FROM
    EMP_EXCLUDE_SAL_VW;
    
-- PL/SQL �ʱ⼳��
set serveroutput on;

DECLARE
-- ���� ����
    V_NO       NUMBER := 10;
    V_HIREDATE VARCHAR2(30) := TO_CHAR(SYSDATE, 'YYYY/MM/DD');
-- ��� ����
    C_MESSAGE  CONSTANT VARCHAR2(50) := 'Hello PL/SQL';
BEGIN
    DBMS_OUTPUT.PUT_LINE('ddddsd');
    DBMS_OUTPUT.PUT_LINE(C_MESSAGE);
    DBMS_OUTPUT.PUT_LINE(V_HIREDATE);
END;    

-- hr> employees ���̺��� �ο츦 �˻��Ͽ� ������ �Ҵ��غ���.
DECLARE
    V_NAME     VARCHAR2(20);
    V_SALARY   NUMBER;
    V_HIREDATE VARCHAR2(30);
BEGIN
    SELECT
        FIRST_NAME,
        SALARY,
        TO_CHAR(SYSDATE, 'YYYY-MM-DD')
    INTO
        V_NAME,
        V_SALARY,
        V_HIREDATE
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = 'Ellen';

    DBMS_OUTPUT.PUT_LINE('�˻��� ����� ����');
    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_SALARY
                         || ' '
                         || V_HIREDATE);

END;


--�����ȣ 100���� �ش��ϴ� ����� �̸��� �μ����� ����Ͻÿ�.
DECLARE
    V_ENAME    VARCHAR(10);
    V_DEPTNAME VARCHAR(20);
BEGIN
    SELECT
        E.LAST_NAME,
        D.DEPARTMENT_NAME
    INTO
        V_ENAME,
        V_DEPTNAME
    FROM
        EMPLOYEES   E,
        DEPARTMENTS D
    WHERE
            E.DEPARTMENT_ID = D.DEPARTMENT_ID
        AND E.EMPLOYEE_ID = 100;

    DBMS_OUTPUT.PUT_LINE('�˻��� ����');
    DBMS_OUTPUT.PUT_LINE(V_ENAME);
    DBMS_OUTPUT.PUT_LINE(V_DEPTNAME);
END;


-- ������ Ÿ��
DECLARE
    V_SEARCH VARCHAR2(30) := 'Lisa';
    V_NAME   EMPLOYEES.LAST_NAME%TYPE;
    V_SALARY EMPLOYEES.SALARY%TYPE;
BEGIN
    SELECT
        LAST_NAME,
        SALARY
    INTO
        V_NAME,
        V_SALARY
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = V_SEARCH;

    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_SALARY);
END;

-- ��� ���̺����� 201�� ����� �̸��� �̸����� ����϶�. (������)
DECLARE
    V_ENAME EMPLOYEES.LAST_NAME%TYPE;
    V_EMAIL EMPLOYEES.EMAIL%TYPE;
BEGIN
    SELECT
        LAST_NAME,
        EMAIL
    INTO
        V_ENAME,
        V_EMAIL
    FROM
        EMPLOYEES
    WHERE
        EMPLOYEE_ID = 201;

    DBMS_OUTPUT.PUT_LINE(V_ENAME);
    DBMS_OUTPUT.PUT_LINE(V_EMAIL);
END;

-- EMPLOYEES -> EMPLOYEES2 ����, ��� ���̺����� �����ȣ�� ���� ū ����� ã�� �� �����ȣ +1������ �Ʒ��� ����� �߰��϶�.
CREATE TABLE EMPLOYEES2
    AS
        SELECT
            *
        FROM
            EMPLOYEES;

DECLARE
    V_EMPID EMPLOYEES.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT
        MAX(EMPLOYEE_ID)
    INTO V_EMPID
    FROM
        EMPLOYEES2;

    INSERT INTO EMPLOYEES2 (
        EMPLOYEE_ID,
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        HIRE_DATE,
        JOB_ID
    ) VALUES (
        V_EMPID + 1,
        'HONG',
        'GIL DONG',
        'AA@AA.COM',
        SYSDATE,
        'AD_VP'
    );

    COMMIT;
END;

SELECT
    *
FROM
    EMPLOYEES2
WHERE
    FIRST_NAME = 'HONG'
ORDER BY
    EMPLOYEE_ID DESC;

-- ROWTYPE
DECLARE
    EMPLOYEE_RECORD EMPLOYEES%ROWTYPE;
BEGIN
    SELECT
        *
    INTO EMPLOYEE_RECORD
    FROM
        EMPLOYEES
    WHERE
        FIRST_NAME = 'Lisa';

    DBMS_OUTPUT.PUT_LINE(EMPLOYEE_RECORD.EMPLOYEE_ID
                         || ' '
                         || EMPLOYEE_RECORD.FIRST_NAME
                         || ' '
                         || EMPLOYEE_RECORD.SALARY);

END;

SELECT
    FIRST_NAME
FROM
    EMPLOYEES
WHERE
    FIRST_NAME = 'Lisa';

-- �������ϱ� -> ROUND(DMBS_RANDOM.VALUE(10,120), -1) 
-- 10 ~ 120 ���̿� ������ �μ���ȣ�� �޾Ƽ� �ش� �μ��� ��� �޿��� ���� ����� ��µǵ��� ����.
-- 1~3000 = ���� | 3000~6000 = ���� | 6000�̻� = ����
DECLARE
    V_RANDOM  NUMBER := ROUND(DBMS_RANDOM.VALUE(10, 120), -1);
    V_AVG_SAL NUMBER;
BEGIN
    SELECT
        AVG(SALARY)
    INTO V_AVG_SAL
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = V_RANDOM;

    IF V_AVG_SAL >= 6000 THEN
        DBMS_OUTPUT.PUT_LINE('����');
    ELSIF V_AVG_SAL >= 3000 THEN
        DBMS_OUTPUT.PUT_LINE('����');
    ELSE
        DBMS_OUTPUT.PUT_LINE('����');
    END IF;

    CASE
        WHEN V_AVG_SAL >= 6000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        WHEN V_AVG_SAL >= 3000 THEN
            DBMS_OUTPUT.PUT_LINE('����');
        ELSE
            DBMS_OUTPUT.PUT_LINE('����');
    END CASE;

END;


-- �ݺ���(LOOP, WHILE, FOR)
DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    LOOP
        I := I + 1;
        TOTAL := TOTAL + I;
        EXIT WHEN I >= 10;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;

DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    WHILE I <= 10 LOOP
        TOTAL := TOTAL + I;
        I := I + 1;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;

DECLARE
    I     NUMBER := 0;
    TOTAL NUMBER := 0;
BEGIN
    FOR I IN 1..10 LOOP
        TOTAL := TOTAL + I;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(TOTAL);
END;

-- LOOP -> ������ 3�� ���
DECLARE
    I NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(3
                             || ' X '
                             || I
                             || ' = '
                             || 3 * I);

        I := I + 1;
        EXIT WHEN I > 9;
    END LOOP;
END;

-- FOR -> ������ ��ü
DECLARE
    I NUMBER := 0;
    J NUMBER := 0;
BEGIN
    FOR I IN 1..9 LOOP
        FOR J IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(I
                                 || ' X '
                                 || J
                                 || ' = '
                                 || I * J);
        END LOOP;
    END LOOP;
END;


-- ����
DECLARE
    EMPLOYEE_RECORD EMPLOYEES%ROWTYPE;
BEGIN
    SELECT
        EMPLOYEE_ID,
        LAST_NAME,
        DEPARTMENT_ID
    INTO
        EMPLOYEE_RECORD.EMPLOYEE_ID,
        EMPLOYEE_RECORD.LAST_NAME,
        EMPLOYEE_RECORD.DEPARTMENT_ID
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = 50;

EXCEPTION
    -- UNIQUE ���������� ���� �÷��� �ߺ��� ������ INSERT
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
    -- SELECT�� ��� 2�� �̻��� �ο츦 ��ȯ
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� �ο찡 �����ϴ�.');
    -- �����Ͱ� ���� ��
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�˻��� ����� �����ϴ�.');
    -- �� �ۿ� ����
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ����');
END;

DECLARE
    E_USER_EXCEPTION EXCEPTION; -- ����� ���� ����
    CNT NUMBER := 0;
BEGIN
    SELECT
        COUNT(*)
    INTO CNT
    FROM
        EMPLOYEES
    WHERE
        DEPARTMENT_ID = 40;

    IF CNT < 5 THEN
        RAISE E_USER_EXCEPTION;
    END IF;
EXCEPTION
    WHEN E_USER_EXCEPTION THEN
        DBMS_OUTPUT.PUT_LINE('5�� ���� �μ� ����');
END;

--hr> ���Ի���� �Է½� �߸��� �μ���ȣ�� ���ؼ� ����� ����ó�� �ϼ���. 
--EMPLOYEES2 ���̺� Ȱ��
--�μ���ȣ 50000�� �Է� �� ����� ���� ���� �߻�
--EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE(SYSDATE), JOB_ID(��AD_VP��), DEPARTMENT_ID
DECLARE
    E_DEPT_EXCEPTION EXCEPTION;
    V_LAST_EMP_NO EMPLOYEES2.EMPLOYEE_ID%TYPE;
    V_DEPTNO      NUMBER := 50000;
BEGIN
    SELECT
        MAX(EMPLOYEE_ID)
    INTO V_LAST_EMP_NO
    FROM
        EMPLOYEES2;

    BEGIN
        SELECT
            DEPARTMENT_ID
        INTO V_DEPTNO
        FROM
            EMPLOYEES2
        WHERE
            DEPARTMENT_ID = V_DEPTNO;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE E_DEPT_EXCEPTION;
    END;

    INSERT INTO EMPLOYEES2 (
        EMPLOYEE_ID,
        LAST_NAME,
        EMAIL,
        HIRE_DATE,
        JOB_ID,
        DEPARTMENT_ID
    ) VALUES (
        V_LAST_EMP_NO + 1,
        'CHEOLWON',
        'DD@DD.COM',
        SYSDATE,
        'AD_VP',
        V_DEPTNO
    );

EXCEPTION
    WHEN E_DEPT_EXCEPTION THEN
        DBMS_OUTPUT.PUT_LINE('50000�� �μ� ����');
END;

DECLARE
    P_DEPARTMENT_ID NUMBER := 50000;
    EX_INVALID_DEPTID EXCEPTION;
    V_CNT           NUMBER := 0;
    V_EMPLOYEE_ID   EMPLOYEES2.EMPLOYEE_ID%TYPE;
BEGIN
    SELECT
        COUNT(*)
    INTO V_CNT
    FROM
        EMPLOYEES2
    WHERE
        DEPARTMENT_ID = P_DEPARTMENT_ID;

    IF V_CNT = 0 THEN
        RAISE EX_INVALID_DEPTID;
    END IF;
    SELECT
        MAX(EMPLOYEE_ID) + 1
    INTO V_EMPLOYEE_ID
    FROM
        EMPLOYEES2;

    INSERT INTO EMPLOYEES2 (
        EMPLOYEE_ID,
        LAST_NAME,
        EMAIL,
        HIRE_DATE,
        JOB_ID,
        DEPARTMENT_ID
    ) VALUES (
        V_EMPLOYEE_ID,
        'CHEOLWON',
        'DD@DD.COM',
        SYSDATE,
        'AD_VP',
        P_DEPARTMENT_ID
    );

EXCEPTION
    WHEN EX_INVALID_DEPTID THEN
        DBMS_OUTPUT.PUT_LINE('50000�� �μ� ����');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('��Ÿ ����');
END;