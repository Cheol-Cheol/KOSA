-- 퀴즈 kcc> 송강 교수가 강의하는 과목을 검색하라.
SELECT
    P.PNO,
    P.PNAME,
    C.CNAME
FROM
         PROFESSOR P
    JOIN COURSE C ON P.PNO = C.PNO
WHERE
    P.PNAME = '송강';
    
-- 퀴즈 kcc> 학점이 2학점인 과목과 이를 강의하는 교수를 검색하라.
SELECT
    C.CNAME,
    P.PNAME
FROM
    COURSE    C,
    PROFESSOR P
WHERE
        C.PNO = P.PNO
    AND C.ST_NUM = 2;

-- 퀴즈 kcc> 화학과 1학년 학생의 기말고사 성적을 검색하라.
SELECT
    S.SNAME,
    SC.RESULT
FROM
    STUDENT S,
    SCORE   SC
WHERE
        S.SNO = SC.SNO
    AND SYEAR = 1
    AND MAJOR = '화학';
        
        
-- 퀴즈 kcc> 화학과 1학년 학생이 수강하는 과목을 검색하라. (3개 테이블 조인)
SELECT DISTINCT
    ( C.CNAME )
FROM
    STUDENT S,
    SCORE   SC,
    COURSE  C
WHERE
        S.SNO = SC.SNO
    AND SC.CNO = C.CNO
    AND MAJOR = '화학'
    AND SYEAR = 1;

-- kcc> 학생 중에 동명이인을 검색하라.
SELECT DISTINCT
    ( S1.SNAME )
FROM
    STUDENT S1,
    STUDENT S2
WHERE
        S1.SNAME = S2.SNAME
    AND S1.SNO != S2.SNO;
    
    
-- kcc> 등록된 과목에 대한 모든 교수를 검색하라(등록하지 않은 교수도 출력하라)
SELECT
    P.PNAME,
    C.*
FROM
    COURSE    C,
    PROFESSOR P
WHERE
    P.PNO = C.PNO (+);

-- ANSI
SELECT
    P.PNAME,
    C.*
FROM
    PROFESSOR P
    LEFT JOIN COURSE    C ON P.PNO = C.PNO;

SELECT
    C.CNO,
    C.CNAME,
    P.PNO,
    P.PNAME
FROM
    COURSE    C
    FULL JOIN PROFESSOR P ON C.PNO = P.PNO;


-- 비등가 조인
SELECT
    S.SNAME,
    SC.RESULT,
    GRADE
FROM
    STUDENT S,
    SCORE   SC,
    SCGRADE
WHERE
        S.SNO = SC.SNO
    AND SC.RESULT BETWEEN LOSCORE AND HISCORE;