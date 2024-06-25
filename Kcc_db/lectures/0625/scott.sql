set serveroutput on;

DECLARE
    DEPT_RECORD DEPT%ROWTYPE;
BEGIN
    SELECT
        *
    INTO DEPT_RECORD
    FROM
        DEPT
    WHERE
        DEPTNO = 40;

    DBMS_OUTPUT.PUT_LINE(DEPT_RECORD.DEPTNO
                         || ' '
                         || DEPT_RECORD.DNAME
                         || ' '
                         || DEPT_RECORD.LOC);

END;


-- ���(���ǹ�)
DECLARE
    V_NO    NUMBER := 7;
    V_SCORE NUMBER := 80;
BEGIN
    /*IF V_NO = 7 THEN
        DBMS_OUTPUT.PUT_LINE('7�̴�.');
    END IF;*/

    /*IF V_NO = 5 THEN
        DBMS_OUTPUT.PUT_LINE('5�̴�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('5�� �ƴϴ�.');
    END IF;*/
    
    IF V_SCORE >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('A����');
    ELSIF V_SCORE >= 80 THEN
        DBMS_OUTPUT.PUT_LINE('B����');
    ELSIF V_SCORE >= 70 THEN
        DBMS_OUTPUT.PUT_LINE('C����');
    ELSE
        DBMS_OUTPUT.PUT_LINE('F����');
    END IF;
END;