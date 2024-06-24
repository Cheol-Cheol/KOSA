-- 부서번호 30번 최대급여자 보다 급여가 높은 사원을 출력하라. (1)
SELECT
    *
FROM
    EMP
WHERE
    SAL > ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );


-- 부서번호 30번 최대급여자 보다 급여가 작은 사원을 출력하라. (1)
SELECT
    *
FROM
    EMP
WHERE
    SAL < ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 30
    );

-- 손하늘과 동일한 관리자(mgr)의 관리를 받으면서 업무도 같은 사원을 검색하라.(1)
SELECT
    *
FROM
    EMP
WHERE
        ENAME != '손하늘'
    AND ( MGR,
          DNO ) = (
        SELECT
            MGR,
            DNO
        FROM
            EMP
        WHERE
            ENAME = '손하늘'
    );
    
-- 화학과 학생과 평점이 동일한 학생을 검색하라. (63)
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != '화학'
    AND AVR IN (
        SELECT
            AVR
        FROM
            STUDENT
        WHERE
            MAJOR = '화학'
    );

-- 화학과 학생과 같은 학년에서 평점이 동일한 학생을 검색하라. (18)
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR != '화학'
    AND ( SYEAR, AVR ) IN (
        SELECT
            SYEAR, AVR
        FROM
            STUDENT
        WHERE
            MAJOR = '화학'
    );
    
-- 기말고사 평균성적이 '핵화학' 과목 평균 성적보다 우수한 과목번호, 과목명, 담당교수를 검색하라. (11)
SELECT
    C.CNO,
    C.CNAME,
    P.PNAME
FROM
    SCORE     SC,
    COURSE    C, 
    PROFESSOR P
WHERE
        SC.CNO = C.CNO
    AND C.PNO = P.PNO
GROUP BY
    C.CNO,
    C.CNAME,
    P.PNAME
HAVING
    AVG(RESULT) > (
        SELECT
            AVG(RESULT)
        FROM
            SCORE  SC,
            COURSE C
        WHERE
            SC.CNO = C.CNO
        GROUP BY
            CNAME
        HAVING
            CNAME = '핵화학'
    );