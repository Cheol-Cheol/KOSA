-- 퀴즈 hr> 3개 이상 테이블을 조인하여 사원이름, 이메일, 부서번호, 부서이름, 직종번호(job_id), 직종이름(job_title)을 출력하라.
SELECT
    E.FIRST_NAME
    || ' '
    || E.LAST_NAME AS "name",
    E.EMAIL,
    D.DEPARTMENT_ID,
    D.DEPARTMENT_NAME,
    J.JOB_ID,
    J.JOB_TITLE
FROM
    EMPLOYEES   E,
    DEPARTMENTS D,
    JOBS        J
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND E.JOB_ID = J.JOB_ID;

-- ANSI
SELECT
    E.FIRST_NAME
    || ' '
    || E.LAST_NAME AS "name",
    E.EMAIL,
    D.DEPARTMENT_ID,
    D.DEPARTMENT_NAME,
    J.JOB_ID,
    J.JOB_TITLE
FROM
         EMPLOYEES E
    JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    JOIN JOBS        J ON E.JOB_ID = J.JOB_ID;
    
    
-- 퀴즈 hr> Seattle(city)에 근무하는 사원이름, 부서번호, 직종번호, 직종이름, 도시이름 출력하기
SELECT
    E.FIRST_NAME
    || ' '
    || E.LAST_NAME,
    D.DEPARTMENT_ID,
    J.JOB_ID,
    J.JOB_TITLE,
    L.CITY
FROM
    EMPLOYEES   E,
    DEPARTMENTS D,
    LOCATIONS   L,
    JOBS        J
WHERE
        E.DEPARTMENT_ID = D.DEPARTMENT_ID
    AND D.LOCATION_ID = L.LOCATION_ID
    AND J.JOB_ID = E.JOB_ID
    AND L.CITY = 'Seattle';
    
    
-- ANSI
SELECT
    E.FIRST_NAME
    || ' '
    || E.LAST_NAME,
    D.DEPARTMENT_ID,
    J.JOB_ID,
    J.JOB_TITLE,
    L.CITY
FROM
         EMPLOYEES E
    JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    JOIN LOCATIONS   L ON D.LOCATION_ID = L.LOCATION_ID
    JOIN JOBS        J ON J.JOB_ID = E.JOB_ID
WHERE
    L.CITY = 'Seattle';
    
        
    