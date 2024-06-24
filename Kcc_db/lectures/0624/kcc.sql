-- ‘정의찬’과 부서(dept)가 다르지만 동일한 업무(job)을 수행하는 사원 목록을 출력하라.
SELECT
    ENAME,
    DNO,
    JOB
FROM
    EMP
WHERE
        JOB = (
            SELECT
                JOB
            FROM
                EMP
            WHERE
                ENAME = '정의찬'
        )
    AND DNO != (
        SELECT
            DNO
        FROM
            EMP
        WHERE
            ENAME = '정의찬'
    );

-- ‘관우’ 보다 일반화학과목의 학점이 낮은 학생의 명단을 출력하라.
SELECT
    S.SNO,
    S.SNAME,
    GRADE
FROM
    STUDENT S,
    COURSE  C,
    SCORE   SC,
    SCGRADE G
WHERE
        S.SNO = SC.SNO
    AND C.CNO = SC.CNO
    AND CNAME = '일반화학'
    AND RESULT BETWEEN LOSCORE AND HISCORE
    AND GRADE > (
        SELECT
            GRADE
        FROM
            STUDENT S,
            COURSE  C,
            SCORE   SC,
            SCGRADE G
        WHERE
                S.SNO = SC.SNO
            AND C.CNO = SC.CNO
            AND SNAME = '관우'
            AND CNAME = '일반화학'
            AND RESULT BETWEEN LOSCORE AND HISCORE
    );

--부서 중에 평균급여를 가장 많이 받는 부서를 검색하라.
SELECT
    DNO
FROM
    EMP
GROUP BY
    DNO
HAVING
    AVG(SAL) = (
        SELECT
            MAX(AVG(SAL))
        FROM
            EMP
        GROUP BY
            DNO
    );

--학생 인원수가 가장 많은 학과를 출력하라.
SELECT
    MAJOR
FROM
    STUDENT
GROUP BY
    MAJOR
HAVING
    COUNT(*) = (
        SELECT
            MAX(COUNT(*))
        FROM
            STUDENT
        GROUP BY
            MAJOR
    );

--학생중 기말고사 평균성적이 가장 낮은 학생의 정보를 검색하라.
SELECT
    S.SNO,
    S.SNAME
FROM
    SCORE   SC,
    STUDENT S
WHERE
    S.SNO = SC.SNO
GROUP BY
    S.SNO,
    S.SNAME
HAVING
    AVG(RESULT) = (
        SELECT
            MIN(AVG(RESULT))
        FROM
            SCORE
        GROUP BY
            SNO
    );

--화학과 1학년 학생중에 평점이 평균이하인 학생을 검색하라.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR = '화학'
    AND SYEAR = 1
    AND AVR <= (
        SELECT
            AVG(AVR)
        FROM
            STUDENT
        WHERE
                SYEAR = 1
            AND MAJOR = '화학'
    );

--10번 부서에서 가장 작은 급여자 보다 작게 받는 급여자를 출력하라.
SELECT
    ENO,
    ENAME,
    SAL,
    DNO
FROM
    EMP
WHERE
    SAL < ALL (
        SELECT
            SAL
        FROM
            EMP
        WHERE
            DNO = 10
    );

CREATE TABLE BOARD (
    SEQ      NUMBER,
    TITLE    VARCHAR2(50),
    WRITER   VARCHAR2(50),
    CONTENTS VARCHAR2(200),
    REGDATE  DATE,
    HITCOUNT NUMBER
);

INSERT INTO BOARD VALUES (
    1,
    'a1',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    2,
    'a2',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    3,
    'a3',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    4,
    'a4',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    5,
    'a5',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    6,
    'a6',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    7,
    'a7',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    8,
    'a8',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    9,
    'a9',
    'a',
    'a',
    SYSDATE,
    0
);

INSERT INTO BOARD VALUES (
    10,
    'a10',
    'a',
    'a',
    SYSDATE,
    0
);

SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            BOARD
        WHERE
            ROWNUM <= 5
        ORDER BY
            SEQ DESC
    );

SELECT
    ROWNUM AS ROW_NUM,
    TEMP.*
FROM
    (
        SELECT
            *
        FROM
            BOARD
        ORDER BY
            SEQ DESC
    ) TEMP;

SELECT
    *
FROM
    (
        SELECT
            ROWNUM AS ROW_NUM,
            TEMP.*
        FROM
            (
                SELECT
                    *
                FROM
                    BOARD
                ORDER BY
                    SEQ DESC
            ) TEMP
    )
WHERE
    ROW_NUM BETWEEN 6 AND 10;

CREATE SEQUENCE BOARD_SEQ;

INSERT INTO BOARD VALUES (
    BOARD_SEQ.NEXTVAL,
    'a1',
    'a',
    'a',
    SYSDATE,
    0
);

SELECT
    *
FROM
    BOARD
WHERE
    SEQ = 9999;

ALTER TABLE BOARD ADD CONSTRAINT BOARD_SEQ_PK PRIMARY KEY ( SEQ );

UPDATE BOARD
SET
    TITLE = 'a100000'
WHERE
    SEQ = 100000;

SELECT
    TITLE
FROM
    BOARD
WHERE
    TITLE = 'a100000'; -- 0.015초 31/535

CREATE INDEX BOARD_TITLE_IDX ON
    BOARD (
        TITLE
    );

SELECT
    TITLE
FROM
    BOARD
WHERE
    TITLE = 'a100000'; -- 0.018초 31/283