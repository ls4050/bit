-- 일치하는 행이 없으면 빼는 것 => inner join


select * from emp join dept on emp.DEPTNO= dept.DEPTNO;

-- 일치하지않아도 포함시킨다 => outer join
-- 두 테이블에 대한 조인 조건 1
-- 세 테이블에 대한 조인 조건 2
-- 항상 조인하려는 테이블 수 - 1만큼의 조건 필요
-- 가장 많이사용되는 조인 = inner
-- 조인을 할때 앞에이테이블을 기준테이블
-- 뒤에테이블이 jon테이블

-- emp deptno를 먼저 정렬함 > 그룹별로 dept테이블의 10번행 20번행 30번행을 갖다붙힘

-- emp 테이블이 갖고있는 deptno, dept테이블의 dept 이라는 값입니다

-- on아니면 using 써야함
-- on 쓰면 deptno컬럼 두번들어감
-- using 쓰면 deptno컬럼 한번들어감 = 두테이블의 조인하려는 컬럼명이 똑같을때만 사용해야함
-- on 쓰면 각자 컬럼 들어감, 통일되서 안들어감 ( 어느테이블에 있는 deptno 인지를 명시애햐ㅏㄴ다)
select * from emp join dept on emp.deptno = dept.deptno;
select * FROM emp JOIN dept using(deptno);

select ename, sal, grade
from emp e
join salgrade s
on e.sal between s.losal and s.hisal;

select ename
, sal
, concat(grade, "등급") 등급
from emp e
join salgrade s
on e.sal >= s.losal and e.sal<=s.hisal;

select * from emp
join dept
using deptno;

-- left join 일치하는 dept의 행이 없더래도 
select ename
, dept.deptno
, dname
from emp
left join dept
on emp.deptno = dept.deptno;


select ename
, dept.deptno
, dname
from emp
right join dept
on emp.deptno = dept.deptno;

