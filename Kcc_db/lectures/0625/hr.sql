-- 과도한 조인 예제 -> 새로운 VIEW 생성 -> 쿼리 질의(VIEW)
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


-- employees 테이블에서 salary를 제외한 VIEW 생성 -> 쿼리 질의(VIEW)
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
    
-- PL/SQL 초기설정
set serveroutput on;

DECLARE
-- 변수 선언
    V_NO       NUMBER := 10;
    V_HIREDATE VARCHAR2(30) := TO_CHAR(SYSDATE, 'YYYY/MM/DD');
-- 상수 선언
    C_MESSAGE  CONSTANT VARCHAR2(50) := 'Hello PL/SQL';
BEGIN
    DBMS_OUTPUT.PUT_LINE('ddddsd');
    DBMS_OUTPUT.PUT_LINE(C_MESSAGE);
    DBMS_OUTPUT.PUT_LINE(V_HIREDATE);
END;    

-- hr> employees 테이블의 로우를 검색하여 변수에 할당해보자.
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

    DBMS_OUTPUT.PUT_LINE('검색된 사원의 정보');
    DBMS_OUTPUT.PUT_LINE(V_NAME
                         || ' '
                         || V_SALARY
                         || ' '
                         || V_HIREDATE);

END;


--사원번호 100번에 해당하는 사원의 이름과 부서명을 출력하시오.
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

    DBMS_OUTPUT.PUT_LINE('검색된 정보');
    DBMS_OUTPUT.PUT_LINE(V_ENAME);
    DBMS_OUTPUT.PUT_LINE(V_DEPTNAME);
END;


-- 데이터 타입
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

-- 사원 테이블에서 201번 사원의 이름과 이메일을 출력하라. (참조형)
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

-- EMPLOYEES -> EMPLOYEES2 복사, 사원 테이블에서 사원번호가 가장 큰 사원을 찾은 후 사원번호 +1번으로 아래의 사원을 추가하라.
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

-- 난수구하기 -> ROUND(DMBS_RANDOM.VALUE(10,120), -1) 
-- 10 ~ 120 사이에 임의의 부서번호를 받아서 해당 부서의 평균 급여에 따라서 등급이 출력되도록 하자.
-- 1~3000 = 낮음 | 3000~6000 = 보통 | 6000이상 = 높음
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
        DBMS_OUTPUT.PUT_LINE('높음');
    ELSIF V_AVG_SAL >= 3000 THEN
        DBMS_OUTPUT.PUT_LINE('보통');
    ELSE
        DBMS_OUTPUT.PUT_LINE('낮음');
    END IF;

    CASE
        WHEN V_AVG_SAL >= 6000 THEN
            DBMS_OUTPUT.PUT_LINE('높음');
        WHEN V_AVG_SAL >= 3000 THEN
            DBMS_OUTPUT.PUT_LINE('보통');
        ELSE
            DBMS_OUTPUT.PUT_LINE('낮음');
    END CASE;

END;


-- 반복문(LOOP, WHILE, FOR)
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

-- LOOP -> 구구단 3단 출력
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

-- FOR -> 구구단 전체
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


-- 예외
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
    -- UNIQUE 제약조건을 갖는 컬럼에 중복된 데이터 INSERT
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다.');
    -- SELECT문 결과 2개 이상의 로우를 반환
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('검색된 로우가 많습니다.');
    -- 데이터가 없을 때
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색된 사원이 없습니다.');
    -- 그 밖에 예외
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 예외');
END;

DECLARE
    E_USER_EXCEPTION EXCEPTION; -- 사용자 예외 정의
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
        DBMS_OUTPUT.PUT_LINE('5명 이하 부서 금지');
END;

--hr> 신입사원을 입력시 잘못된 부서번호에 대해서 사용자 예외처리 하세요. 
--EMPLOYEES2 테이블 활용
--부서번호 50000번 입력 → 사용자 정의 예외 발생
--EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE(SYSDATE), JOB_ID(’AD_VP’), DEPARTMENT_ID
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
        DBMS_OUTPUT.PUT_LINE('50000번 부서 금지');
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
        DBMS_OUTPUT.PUT_LINE('50000번 부서 금지');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 에외');
END;


-- CURSOR
DECLARE
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;

    DEPARTMENT_RECORD DEPARTMENT_CURSORS%ROWTYPE;
BEGIN
    OPEN DEPARTMENT_CURSORS;
    LOOP
        FETCH DEPARTMENT_CURSORS INTO
            DEPARTMENT_RECORD.DEPARTMENT_ID,
            DEPARTMENT_RECORD.DEPARTMENT_NAME,
            DEPARTMENT_RECORD.LOCATION_ID;
        EXIT WHEN DEPARTMENT_CURSORS%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(DEPARTMENT_RECORD.DEPARTMENT_ID
                             || ' '
                             || DEPARTMENT_RECORD.DEPARTMENT_NAME
                             || ' '
                             || DEPARTMENT_RECORD.LOCATION_ID);

    END LOOP;

    CLOSE DEPARTMENT_CURSORS;
END;

DECLARE
    CURSOR DEPARTMENT_CURSORS IS
    SELECT
        DEPARTMENT_ID,
        DEPARTMENT_NAME,
        LOCATION_ID
    FROM
        DEPARTMENTS;

    DEPARTMENT_RECORD DEPARTMENT_CURSORS%ROWTYPE;
BEGIN
    FOR DEPARTMENT_RECORD IN DEPARTMENT_CURSORS LOOP
        DBMS_OUTPUT.PUT_LINE(DEPARTMENT_RECORD.DEPARTMENT_ID
                             || ' '
                             || DEPARTMENT_RECORD.DEPARTMENT_NAME
                             || ' '
                             || DEPARTMENT_RECORD.LOCATION_ID);
    END LOOP;
END;


-- 커서를 이용하여 사원의 정보를 출력하라. (사원번호, 사원이름(FIRST_NAME), 급여, 급여누계)
DECLARE
    CURSOR EMP_CURSORS IS
    SELECT
        EMPLOYEE_ID,
        LAST_NAME,
        SALARY
    FROM
        EMPLOYEES2;

    EMP_RECORD  EMP_CURSORS%ROWTYPE;
    V_SAL_TOTAL NUMBER := 0;
BEGIN
DBMS_OUTPUT.PUT_LINE('사원번호     사원이름     급여     급여누계');
    FOR EMP_RECORD IN EMP_CURSORS LOOP
        V_SAL_TOTAL := V_SAL_TOTAL + EMP_RECORD.SALARY;
        DBMS_OUTPUT.PUT_LINE(EMP_RECORD.EMPLOYEE_ID
                             || '          '
                             || EMP_RECORD.LAST_NAME
                             || '     '
                             || EMP_RECORD.SALARY
                             || '     '
                             || V_SAL_TOTAL);

    END LOOP;
END;