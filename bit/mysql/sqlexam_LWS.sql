-- 이원석 sql
-- 1.
select job 직무, TRUNCATE(avg(sal),-2) "급여 평균" from emp where deptno = 30 group by job;

-- 2.
select dname 부서명, count(*) "직원 수" from emp join dept using(deptno) group by dname having count(*)>=4;

-- 3.
select ifnull(job, 'TOTAL') 직무명, format(sum(sal),0) "급여의 합" from emp group by job with rollup;

-- 4.
select ename 직원명, sal 급여, grade "급여 등급" from emp e join salgrade s on e.sal between s.losal and s.hisal where sal >=all (select max(sal) from emp); 

-- 5.
select ename 직원명, concat(format(sal+ifnull(comm, 0), 0), '원') 급여 from emp where year(hiredate) = 1981 order by sal+ifnull(comm, 0) desc;

-- 6.
SELECT ename 직원명, date_format(hiredate, "%Y년 %m월 %d일") 입사년월일, case year(hiredate)
when '1980' then 'A'
when '1981' then 'B'
when '1982' then 'C'
when '1983' then 'D'
end as '그룹' from emp;

-- 7.
select e.empno "사원 사번"
, e.ename "사원 이름"
, e.mgr "관리자 사번"
, m.ename "관리자 이름"
from emp e
left join emp m
on e.mgr = m.empno
where m.ename is not null and e.mgr is not null;

-- 8-1.
select empno, ename, deptno from emp
join dept
using (deptno)
join locations
using (loc_code) where city='CHICAGO';
-- 8-2.
select empno, ename, deptno from emp where deptno = (select deptno from dept where loc_code = (select loc_code from locations where city='CHICAGO'));

-- 9.
select ename, sal from emp where sal >all (select sal from emp where deptno =30); 

