-- Q1. (45)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    HIRE_DATE,
    SALARY
FROM
    EMPLOYEES
WHERE
    DEPARTMENT_ID = (
        SELECT
            DEPARTMENT_ID
        FROM
            EMPLOYEES
        WHERE
            LAST_NAME = 'Patel'
    );
    
-- Q2. (5)
SELECT
    E.LAST_NAME,
    D.DEPARTMENT_NAME,
    E.SALARY
FROM
    EMPLOYEES   E,
    DEPARTMENTS D
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND E.JOB_ID = (
        SELECT
            JOB_ID
        FROM
            EMPLOYEES
        WHERE
            LAST_NAME = 'Austin'
    );

-- Q3. (2)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    SALARY
FROM
    EMPLOYEES
WHERE
    SALARY = (
        SELECT
            SALARY
        FROM
            EMPLOYEES
        WHERE
            LAST_NAME = 'Seo'
    );
    
-- Q4. (10)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    SALARY
FROM
    EMPLOYEES
WHERE
    SALARY > (
        SELECT
            MAX(SALARY)
        FROM
            EMPLOYEES
        WHERE
            DEPARTMENT_ID = 30
    );
    
-- Q5. (96)
SELECT
    EMPLOYEE_ID,
    LAST_NAME,
    SALARY
FROM
    EMPLOYEES
WHERE
    SALARY > (
        SELECT
            MIN(SALARY)
        FROM
            EMPLOYEES
        WHERE
            DEPARTMENT_ID = 30
    );
    
-- Q6. (50)
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
    
-- Q7. (6)
SELECT
    E.EMPLOYEE_ID,
    E.LAST_NAME,
    D.DEPARTMENT_NAME,
    E.HIRE_DATE,
    D.LOCATION_ID
FROM
    DEPARTMENTS D,
    EMPLOYEES   E,
    JOBS        J
WHERE
        D.DEPARTMENT_ID = E.DEPARTMENT_ID
    AND E.JOB_ID = J.JOB_ID
    AND D.DEPARTMENT_ID = 100
    AND J.JOB_ID NOT IN (
        SELECT
            J.JOB_ID
        FROM
            DEPARTMENTS D, EMPLOYEES   E, JOBS        J
        WHERE
                D.DEPARTMENT_ID = E.DEPARTMENT_ID
            AND E.JOB_ID = J.JOB_ID
            AND D.DEPARTMENT_ID = 30
    );