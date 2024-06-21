-- ���� hr> 3�� �̻� ���̺��� �����Ͽ� ����̸�, �̸���, �μ���ȣ, �μ��̸�, ������ȣ(job_id), �����̸�(job_title)�� ����϶�.
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
    
    
-- ���� hr> Seattle(city)�� �ٹ��ϴ� ����̸�, �μ���ȣ, ������ȣ, �����̸�, �����̸� ����ϱ�
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
    
        
    