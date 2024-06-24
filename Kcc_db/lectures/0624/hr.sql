-- ‘Chen’ 사원 보다 salary를 많이 받는 사원 목록을 출력하라.
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
    
-- 직무(job_id)별 최대 급여자의 사원내용을 출력하라. (다중 컬럼)
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

-- FROM절 서브쿼리
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
    
-- 급여를 많이 받는 사원 3명을 출력하여라.
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