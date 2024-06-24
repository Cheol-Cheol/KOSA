-- ��Chen�� ��� ���� salary�� ���� �޴� ��� ����� ����϶�.
SELECT
    LAST_NAME,
    SALARY
FROM
    EMPLOYEES
WHERE
    SALARY > (
        SELECT
            SALARY
        FROM
            EMPLOYEES
        WHERE
            LAST_NAME = 'Chen'
    );
    
-- ����(job_id)�� �ִ� �޿����� ��������� ����϶�. (���� �÷�)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    SALARY,
    JOB_ID
FROM
    EMPLOYEES
WHERE
    ( SALARY, JOB_ID ) IN (
        SELECT
            MAX(SALARY), JOB_ID
        FROM
            EMPLOYEES
        GROUP BY
            JOB_ID
    );

-- FROM�� ��������
SELECT
    ROWNUM,
    ALIAS.*
FROM
    (
        SELECT
            EMPLOYEE_ID,
            LAST_NAME,
            HIRE_DATE
        FROM
            EMPLOYEES
        ORDER BY
            HIRE_DATE
    ) ALIAS
WHERE
    ROWNUM <= 5;
    
-- �޿��� ���� �޴� ��� 3���� ����Ͽ���.
SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            EMPLOYEES
        ORDER BY
            SALARY DESC
    ) 
WHERE
    ROWNUM <= 3;