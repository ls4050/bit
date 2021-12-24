-- ASCII (한글자당 1byte면 충분함)
-- ex) abc 는 3byte
SELECT 'A', ASCII('A'), ASCII(' ') FROM DUAL;
-- concat 문장이어붙히기
SELECT CONCAT('java',' 화이팅') AS 화이팅;
-- 할당한 문자 사이에 구분자를 넣어서 출력
SELECT CONCAT_WS('**','sql',' 화이팅') AS '화이팅 !!';
-- 컬럼명과 함께 사용가능(+가 아닌 ,)
SELECT CONCAT(ename,'의 급여는 ', sal, '입니다.') AS 명세 FROM EMP;
-- '문자열'중 '시작위치'부터 '개수'만큼 출력
-- index개념아님
SELECT '20200331', SUBSTRING('20200331',1,4) AS year, SUBSTRING('20200331',5,2) AS month, SUBSTRING('20200331',7,2) AS day;
SELECT '20200331', MID('20200331', 1, 4) AS year, MID('20200331', 5, 2) AS month, MID('20200331', 7, 2) AS day;
-- 해당 개수까지 출력
SELECT '20200331', LEFT('20200331', 4) AS year, LEFT('20200331', 6) AS month, LEFT('20200331', 8) AS day;
SELECT '20200331', RIGHT('20200331', 8) AS year, RIGHT('20200331', 4) AS month, RIGHT('20200331', 2) AS day;
 -- trim : 양쪽 공백삭제
 -- rtrim : 오른쪽 공백삭제
 -- trim (both '문자' from '문자열') : 문자를 제외한 문자열 출력
SELECT TRIM(' java '), RTRIM(' java '), TRIM(BOTH 'ㅋ' FROM 'ㅋㅋjdbcㅋㅋㅋ');
-- 문자열 중 찾는 문자열의 시작위치값 출력
SELECT INSTR('LEEWONSEOK','WON') FROM DUAL;
-- 문자열 중 기존문자열을 원하는 문자열로 대체
SELECT REPLACE('LEEWONSEOK LEEWONSEOK OH SEOUNG SEOK DAVID OH', 'SEOK', 'DUCK');
-- 대문자 <-> 소문자
SELECT UCASE('cgv');
SELECT LCASE('CGV');
-- 문자열을 반대로 출력
SELECT REVERSE('LEEWONSEOK');
-- 문자열 개수 출력
SELECT CHAR_LENGTH('LEEWONSEOK');