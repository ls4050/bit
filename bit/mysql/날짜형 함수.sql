-- 날짜 관련 함수

-- 현재 날짜 시간 출력
SELECT NOW(), SYSDATE() FROM DUAL;

-- NOW() - HIREDATE : NOW 빼기 고용날짜
SELECT ename, hiredate, NOW(), NOW()-hiredate, DATEDIFF(NOW(), hiredate)
, YEAR(hiredate), MONTH(hiredate), DAY(hiredate) FROM emp;
SELECT ename, WEEKDAY(hiredate) FROM EMP;
-- 입사 요일 출력, else 필요없으면 생략가능
SELECT ename, case WEEKDAY(hiredate)
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
when '5' then '토요일'
when '6' then '일요일'
end as '입사 요일'
from emp;
-- case 뒤에 when  올때는 value를 직접 다 써줘야한다
-- case 뒤에 value 올때는 일일이 다 안써도 된다
select case 
when weekday(now())='0' then '월요일'
when weekday(now())='1' then '화요일'
when weekday(now())='2' then '수요일'
when weekday(now())='3' then '목요일'
when weekday(now())='4' then '금요일'
when weekday(now())='5' then '토요일'
when weekday(now())='6' then '일요일'
end as 요일
from dual;

select case weekday(now())
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
when '5' then '토요일'
when '6' then '일요일'
end as '오늘 요일'
from dual;

-- 오늘의 요일 출력
SELECT case WEEKDAY(NOW())
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
when '5' then '토요일'
when '6' then '일요일'
end as '오늘의 요일' ;

-- Y와 y의 차이점
SELECT DATE_FORMAT(NOW(), "%Y년 %y년");
-- 캐스팅 안해도 알아서 캐스팅해서 사용함 대신, 규격에 맞게끔 데이터를 입력해야함
-- 0이붙느냐 안붙느냐 차이 m 과 c
SELECT DATE_FORMAT('2021-01-03', "%m월 %c월");
SELECT DATE_FORMAT('2021-01-03', "%d월 %e월");

-- H:24시간 h:0이붙은 12시간 l:0이없는 12시간 
SELECT DATE_FORMAT(NOW(), "%H시 %h시 %l시");
-- r은 ap pm까지 표시
SELECT DATE_FORMAT(NOW(), "%T %r");

-- 현재시간으로 부터 1분을 더해라(interval 1 minute)
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 MINUTE);
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR);
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 DAY);
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 MONTH);
SELECT NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR);

-- 2번째 args와 3번째 args 차를 구하는데 year를 기준으로 해라
SELECT timestampdiff(year, hiredate, now()) from emp;
SELECT timestampdiff(week, hiredate, now()) from emp;
SELECT timestampdiff(month, hiredate, now()) from emp;

-- 문자열을 날짜함수로 형변환 해줌
select timestampdiff(month, cast('2021-01-01' as date), now());
SELECT timestampdiff(day, cast('2021-01-01' as date),now());