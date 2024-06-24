-- ������������ �μ�(dept)�� �ٸ����� ������ ����(job)�� �����ϴ� ��� ����� ����϶�.
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
                ENAME = '������'
        )
    AND DNO != (
        SELECT
            DNO
        FROM
            EMP
        WHERE
            ENAME = '������'
    );

-- �����졯 ���� �Ϲ�ȭ�а����� ������ ���� �л��� ����� ����϶�.
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
    AND CNAME = '�Ϲ�ȭ��'
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
            AND SNAME = '����'
            AND CNAME = '�Ϲ�ȭ��'
            AND RESULT BETWEEN LOSCORE AND HISCORE
    );

--�μ� �߿� ��ձ޿��� ���� ���� �޴� �μ��� �˻��϶�.
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

--�л� �ο����� ���� ���� �а��� ����϶�.
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

--�л��� �⸻��� ��ռ����� ���� ���� �л��� ������ �˻��϶�.
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

--ȭ�а� 1�г� �л��߿� ������ ��������� �л��� �˻��϶�.
SELECT
    *
FROM
    STUDENT
WHERE
        MAJOR = 'ȭ��'
    AND SYEAR = 1
    AND AVR <= (
        SELECT
            AVG(AVR)
        FROM
            STUDENT
        WHERE
                SYEAR = 1
            AND MAJOR = 'ȭ��'
    );

--10�� �μ����� ���� ���� �޿��� ���� �۰� �޴� �޿��ڸ� ����϶�.
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
    TITLE = 'a100000'; -- 0.015�� 31/535

CREATE INDEX BOARD_TITLE_IDX ON
    BOARD (
        TITLE
    );

SELECT
    TITLE
FROM
    BOARD
WHERE
    TITLE = 'a100000'; -- 0.018�� 31/283