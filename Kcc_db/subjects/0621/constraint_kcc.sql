-- Member 테이블 생성 및 제약조건 설정
CREATE TABLE MEMBER (
    ID      VARCHAR2(20),
    NAME    VARCHAR(20),
    REGNO   VARCHAR(13),
    HP      VARCHAR(13),
    ADDRESS VARCHAR(100)
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_ID_PK PRIMARY KEY ( ID );

ALTER TABLE MEMBER MODIFY (
    NAME
        CONSTRAINT MEMBER_NAME_NN NOT NULL,
    ADDRESS
        CONSTRAINT MEMBER_ADDRESS_NN NOT NULL,
    REGNO
        CONSTRAINT MEMBER_REGNO_UNIQUE UNIQUE
);
-- 


-- Book 테이블 생성 및 제약 조건 설정
CREATE TABLE BOOK (
    CODE    NUMBER(4),
    TITLE   VARCHAR2(50),
    COUNT   NUMBER(6),
    PRICE   NUMBER(10),
    PUBLISH VARCHAR2(50)
);

ALTER TABLE BOOK ADD CONSTRAINT BOOK_CODE_PK PRIMARY KEY ( CODE );

ALTER TABLE BOOK MODIFY
    TITLE
        CONSTRAINT BOOK_TITLE_NN NOT NULL;
--      


-- Order2 테이블 생성 및 제약 조건 설정
CREATE TABLE ORDER2 (
    NO      VARCHAR2(10),
    ID      VARCHAR2(20),
    CODE    NUMBER(4),
    COUNT   NUMBER(6),
    DR_DATE DATE
);

ALTER TABLE ORDER2 ADD (
    CONSTRAINT ORDER2_NO_PK PRIMARY KEY ( NO ),
    CONSTRAINT ORDER2_ID_FK FOREIGN KEY ( ID )
        REFERENCES MEMBER ( ID ),
    CONSTRAINT ORDER2_CODE_FK FOREIGN KEY ( CODE )
        REFERENCES BOOK ( CODE )
);

ALTER TABLE ORDER2 MODIFY (
    ID
        CONSTRAINT ORDER2_ID_NN NOT NULL,
    CODE
        CONSTRAINT ORDER2_CODE_NN NOT NULL
);
--


-- DEPT_CONST 테이블 생성 및 제약조건 설정
CREATE TABLE DEPT_CONST (
    DEPTNO NUMBER(2),
    DNAME  VARCHAR2(14),
    LOC    VARCHAR2(13)
);

ALTER TABLE DEPT_CONST ADD CONSTRAINT DEPTCONST_DEPTNO_PK PRIMARY KEY ( DEPTNO );

ALTER TABLE DEPT_CONST MODIFY (
    DNAME
        CONSTRAINT DEPTCONST_DNAME_UNQ UNIQUE,
    LOC
        CONSTRAINT DEPTCONST_LOC_NN NOT NULL
);
--


-- EMP_CONST 테이블 생성 및 제약 조건 설정
CREATE TABLE EMP_CONST (
    EMPNO    NUMBER(4),
    ENAME    VARCHAR2(10),
    JOB      VARCHAR2(9),
    TEL      VARCHAR2(20),
    HIREDATE DATE,
    SAL      NUMBER(7),
    COMM     NUMBER(7),
    DEPTNO   NUMBER(2)
);

ALTER TABLE EMP_CONST ADD (
    CONSTRAINT EMPCONST_EMPNO_PK PRIMARY KEY ( DEPTNO ),
    CONSTRAINT EMPCONST_DEPTNO_FK FOREIGN KEY ( DEPTNO )
        REFERENCES DEPT_CONST ( DEPTNO ),
    CONSTRAINT EMPCONST_SAL_CHK CHECK ( SAL BETWEEN 1000 AND 9999 )
);

ALTER TABLE EMP_CONST MODIFY (
    ENAME
        CONSTRAINT EMPCONST_ENAME_NN NOT NULL,
    TEL
        CONSTRAINT EMPCONST_TEL_UNQ UNIQUE
);
--