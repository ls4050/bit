-- 논리관련함수

-- 첫번째 args 조건식, 두번째가 참일때 실행, 세번째가 거짓일때 실행
SELECT IF(3>5, 'true','false') FROM DUAL;
SELECT IF(3<5, 'true','false') FROM DUAL;

-- comm 값이 null이 아니면 commm을 출력, null이면 0으로 대치
SELECT ename, IFNULL(comm, 0) FROM emp;
SELECT ename, IFNULL(comm, '미정') FROM emp;
-- comm이 정해지지 않은 직원도 100을 받을 수 있음
SELECT ename, IFNULL(comm, 0) + 100 FROM emp;
-- 4000보다 컸을 때, 3000보다 컸을 때, 2000보다 컸을 때, 1000보다 컸을 때 비교
SELECT ename, sal, IF(sal> 4000, 'T1', IF(sal> 3000, 'T2', IF(sal> 2000, 'T3', IF(sal> 1000, 'T4','T5'))))
FROM emp;

-- CASE문을 사용하면 편하다
-- 800이면 T5 출력
-- case부터 end까지가 함수
SELECT ename, sal, CASE
 WHEN sal> 4000 THEN 'T1'
 WHEN sal> 3000 THEN 'T2'
 WHEN sal> 2000 THEN 'T3'
 WHEN sal> 1000 THEN 'T4'
 ELSE 'T5' END grade
FROM emp;