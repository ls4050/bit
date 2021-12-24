select deptno from emp where ename = 'SMITH';
select ename from emp where deptno = '20';

-- => 결과에 스미스를 포함하지않고 서브쿼리 실행(스미스와 같이 일하는 직원만 추출)
select ename from emp where deptno = (select deptno from emp where ename = 'SMITH') AND ename != 'SMITH';

-- 직원의 평균월급보다 더 많이받는 직원 추출
select * from emp where sal > (select avg(sal) from emp);

-- 오류, 서브쿼리가두개의 행을 반환하기 때문에
select * from emp where sal > (select sal from emp where month(hiredate) = '2');
select sal from emp where month(hiredate)='2';

-- =>
select * from emp where sal >all (select sal from emp where month(hiredate) = '2');
select * from emp where sal >any (select sal from emp where month(hiredate) = '2');
select * from emp where sal >some (select sal from emp where month(hiredate) = '2');

-- 오류, 서브쿼리가 두개의 행을 반환하기 때문
select * from emp where deptno = (select deptno from dept where loc_code IN ('B1', 'C1'));

select * from dept;
select deptno from dept where loc_code IN ('B1', 'C1');


-- => 20 이나 30 이면
select * from emp where deptno IN (select deptno from dept where loc_code IN('B1', 'C1'));

select concat(deptno, '부서에서 최고 월급은 ', sal, '이며', ename, '입니다') result
from emp
where (sal, deptno) in (select max(sal), deptno from emp group by deptno);