-- mission
ALTER TABLE EMPLOYEES2 ADD (
    RETIRE_DATE DATE
);

CREATE OR REPLACE PACKAGE HR_PKG IS
    --신규 사원 입력
    --신규사원 사번 => 마지막(최대)사번 + 1
    --신규사원 등록
    PROCEDURE NEW_EMP_PROC (
        PS_EMP_NAME  IN VARCHAR2,
        PE_EMAIL     IN VARCHAR2,
        PJ_JOB_ID    IN VARCHAR2,
        PD_HIRE_DATE IN VARCHAR2
    );
    -- TO_DATE(pdhire_date, 'YYYY-MM-DD');

   -- 퇴사 사원 처리
   --퇴사한 사원은 사원테이블에서 삭제하지 않고 퇴사일자(retire_date)를 NULL에서 갱신
    PROCEDURE RETIRE_EMP_PROC (
        PN_EMPLOYEE_ID IN NUMBER
    );

END HR_PKG;

-- 패키지 구현부
CREATE OR REPLACE PACKAGE BODY hr_pkg IS
 -- 신규 사원 입력
  PROCEDURE new_emp_proc(ps_emp_name IN VARCHAR2,
	pe_email IN VARCHAR2,
	pj_job_id IN VARCHAR2,
	pd_hire_date IN VARCHAR2)
  IS
    vn_emp_id employees2.employee_id%TYPE; 
    vd_hire_date DATE := TO_DATE(pd_hire_date, 'YYYY-MM-DD');

  BEGIN
        --신규사원 사번 => 마지막(최대)사번 + 1
        SELECT  NVL(MAX(employee_id), 0) + 1
	INTO vn_emp_id
	FROM employees2;

      --신규사원 등록
       INSERT INTO employees2(employee_id, last_name, hire_date, email, job_id)
	VALUES(vn_emp_id, ps_emp_name, vd_hire_date, pe_email, pj_job_id);

       COMMIT;

       EXCEPTION WHEN OTHERS THEN
	dbms_output.put_line('insert error');
	ROLLBACK;

  END new_emp_proc;

  --퇴사처리
  --퇴사한 사원은 사원테이블에서 삭제하지 않고 퇴사일자(retire_date)를 NULL에서 갱신
  PROCEDURE retire_emp_proc(pn_employee_id IN NUMBER)
  IS
    vn_cnt NUMBER := 0;
    e_no_data EXCEPTION;
  BEGIN
      UPDATE employees2
	SET retire_date = SYSDATE
	WHERE employee_id = pn_employee_id
	AND retire_date IS NULL;

      --UPDATE된 건수를 가져오기
      vn_cnt := SQL%ROWCOUNT;

     --갱신된 건수가 0이면 사용자 예외처리
     IF vn_cnt = 0 THEN
        RAISE e_no_data; --인위적으로 사용자 예외 발생
     END IF;

     COMMIT;

     EXCEPTION WHEN e_no_data THEN
	dbms_output.put_line(pn_employee_id ||'는 퇴사대상이 아닙니다.');
	ROLLBACK;

   END retire_emp_proc;

END hr_pkg;