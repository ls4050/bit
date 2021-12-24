-- union unionall
-- select 의 개수가 같아야한다
-- 타입이 달라도 맞춰주긴하지만 sw에 따라 타입이 맞아야하는 프로그램도 있음

-- 중복된 행은 지우겠다
select ename, hiredate, job from emp where year(hiredate) = 1981
union
select ename, hiredate, job from emp where deptno = 30;

-- 중복된 행도 출력
select ename, hiredate, job from emp where year(hiredate) = 1981
union all
select ename, hiredate, job from emp where deptno = 30;
