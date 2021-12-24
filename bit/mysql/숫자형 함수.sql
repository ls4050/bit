-- 숫자형 함수

-- 3을 갖고있는 개수만큼 출력
select 3 from emp;
select now() from emp;
-- 3을 갖고있는 한개만 출력
-- dual은 함수나 계산식을 테이블생성없이 실행시키기위한 dummy 테이블
select 3 from dual;

-- 절대값
SELECT 3, ABS(3), ABS(-3) FROM DUAL;

-- 반올림과 버림
SELECT ROUND(7777.56789) FROM DUAL;
-- 1의 자리숫자까지
SELECT ROUND(7777.56789 ,1) FROM DUAL;
-- 4의 자리숫자까지
SELECT ROUND(7777.56789 ,4) FROM DUAL;
-- 1의 자리에서 반올림
SELECT ROUND(7777.56789 ,-1) FROM DUAL;
-- 10의 자리에서 반올림
SELECT ROUND(7777.56789 ,-2) FROM DUAL;
-- 1의 자리숫자까지 내림
SELECT TRUNCATE(7777.56789 ,1) FROM DUAL;
-- 4의 자리숫자까지 내림
SELECT TRUNCATE(7777.56789 ,4) FROM DUAL;
-- 1의 자리에서 내림
SELECT TRUNCATE(7777.56789 ,-1) FROM DUAL;
-- 10의 자리에서 내림
SELECT TRUNCATE(7777.56789 ,-2) FROM DUAL;

-- 나머지.
SELECT '5%3', MOD(5,3) FROM DUAL;
-- 가변변수를 보낼 수 있음 ( 여러개 숫자 중에 ~~ 기능 가능 )
SELECT CEILING(3.14), FLOOR(3.14), GREATEST(1,2,3,4,5), LEAST(1,2,3,4,5) FROM DUAL;
-- 1000단위마다 , 가 들어가는 기능 + 소수점 이하 ~째 자리까지 나타냄(디폴트 올림)
-- ,가 들어가므로 숫자형이 아닌 문자형으로 분류
SELECT FORMAT(123456789.123456, 3) as "소수점 쉼표구분",
 FORMAT(123456789, 4) as "정수 쉼표구분", FORMAT(123456789, 0) as "소수점이하 없이 정수 쉼표구분";