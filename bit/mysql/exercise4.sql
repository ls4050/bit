-- 제출파일명 : exercise4.sql
-- 메일제목 : SQL 실습 4 - XXX
-- QUESTION

-- union = union (distinct)
-- [ course1 테이블과 course2 테이블을 가지고 문제 해결 ]
-- 1. course1 을 수강하는 학생들과 course2 를 수강하는 학생들의 이름, 전화 번호 그리고 
--    나이를 출력하는데 나이가 많은 순으로 출력하시오.
--    단, 두 코스를 모두 수강하는 학생들의 정보는 한 번만 출력한다.

-- name   phone        age  
-- --------------------------
-- 둘리   010-111-1111   10
-- 또치   010-222-2222   11 
-- 도우너 010-333-3333   12 
-- 희동이 010-444-4444    6 
-- 토토로 010-555-5555   13 
-- 짱구   010-666-6666    7
-- 듀크   010-777-7777   11 

select name
, phone
, age
from course2
union
select name
,phone
,age
from course1 order by age desc;



-- 3. course1 을 수강하는 학생들과 course2 를 수강하는 학생들의 이름, 전화 번호 그리고 
--    나이를 출력하는데 나이가 많은 순으로 출력하시오.
--    단, 두 코스를 모두 수강하는 학생들의 정보를 중복해서 출력한다. 또한 나이가 많은 순으로 정렬한다.

-- name   phone        age 
-- --------------------------
-- 토토로 010-555-5555   13 
-- 도우너 010-333-3333   12 
-- 또치   010-222-2222   11 
-- 듀크   010-777-7777   11
-- 또치   010-222-2222   11 
-- 둘리   010-111-1111   10 
-- 둘리   010-111-1111   10 
-- 짱구   010-666-6666    7 
-- 희동이 010-444-4444    6 
select name
, phone
, age
from course2
union all
select name
,phone
,age
from course1 order by age desc;



-- [ emp 테이블(dept, locations, salgrade 테이블)을 가지고 문제 해결 ]
-- 4. RESEARCH 부서에서 근무하는 직원의 이름, 업무, 부서이름을 출력하시오.
-- 이름         업무         	부서이름          
-- -------- --------- ------------------
-- SMITH CLERK   RESEARCH 
-- JONES MANAGER RESEARCH 
-- SCOTT ANALYST RESEARCH 
-- FORD  ANALYST RESEARCH 

select ename 이름
, job 업무
, dname 부서이름
from emp
join dept
using (deptno)
where dname = 'RESEARCH';




-- 5. 이름에 'A'가 들어가는 직원들의 이름과 부서이름을 출력하시오.
-- 이름        부서이름          
-- ------    --------------
-- ALLEN  SALES      
-- WARD   SALES      
-- MARTIN SALES     
-- BLAKE  SALES      
-- CLARK  ACCOUNTING 
-- JAMES  SALES
select ename 이름
, dname 부서이름
from emp
join dept
using (deptno)
where ename like '%A%';



-- 6. 직원이름과 그 직원이 속한 부서의 부서명, 그리고 월급을 
-- 출력하는데 월급이 3000이상인 직원을 출력하시오. 
-- 직원이름   부서명               월급
-- -------- -------------- ----------
-- SCOTT	   RESEARCH	3,000원
-- KING	   ACCOUNTING	5,000원
-- FORD	   RESEARCH	3,000원

-- 행에 대한 조건은 where로 해야한다

select ename 이름
, dname 부서명
, concat(format(sal, 0), '원') 월급
from emp
join dept
using (deptno)
where sal >= 3000;



-- 7. 커미션이 책정된 직원들의 직원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '직원번호', '직원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하시오. (6행)
-- 또한 실급여가 적은 순으로 출력하시오.
--  직원번호 직원이름      연봉           실급여       급여등급
-- -------- ---------- ---------- ---------- ----------
--  7521 WARD             15000         15200          2
--  7654 MARTIN          15000         15300          2
--  7844 TURNER          18000         18000          3
--  7499	ALLEN	       19200         19500	   3
--                                          :
select empno 직원번호
, ename 직원이름
, sal*12 연봉
, (sal+ifnull(comm,0))*12 실급여
, grade 급여등급
from emp e
join salgrade s
on e.sal >= s.losal and e.sal<=s.hisal
limit 6;


-- 8. 부서번호가 10번인 직원들의 부서번호, 부서이름, 직원이름,
-- 월급, 급여등급을 출력하시오. 
--   부서번호 부서이름           직원이름      월급           급여등급
-- -------- -------------- ---------- ---------- ----------
--      10 ACCOUNTING     CLARK            2450          4
--      10 ACCOUNTING     KING              5000          5
--      10 ACCOUNTING     MILLER           1300           2 
select deptno 부서번호
, dname 부서이름
, ename 직원이름
, sal 월급
, grade 급여등급
from emp e
join dept d
using(deptno)
join salgrade s
on e.sal >= s.losal and e.sal<=s.hisal
where deptno = 10;




-- 9. 업무가 'SALESMAN'인 직원들의 업무와 그 직원이름, 그리고
-- 그 직원이 속한 부서 이름을 출력하시오. 
-- 업무          직원이름       부서이름          
-- ------- ---------- --------------
-- SALESMAN  TURNER     SALES         
-- SALESMAN  MARTIN     SALES         
-- SALESMAN  WARD       SALES         
-- SALESMAN  ALLEN      SALES 

select job 업무
, ename 직원이름
, dname 부서이름
from emp e
join dept d
on e.deptno = d.deptno
where job = 'SALESMAN';



-- 10. 부서번호가 10번, 20번인 직원들의 부서번호, 부서이름, 
-- 직원이름, 월급, 급여등급을 출력하시오. 그리고 그 출력된 
-- 결과물을 부서번호가 낮은 순으로, 월급이 많은 순으로 정렬하시오. (7개 행)
--   부서번호 부서이름              직원이름               월급       급여등급
-- -------- -------------- ---------- ---------- ----------
--    10 ACCOUNTING              KING                   5000          5
--    10 ACCOUNTING              CLARK                 2450          4
--    10 ACCOUNTING              MILLER                 1300          2
--    20 RESEARCH                 SCOTT    	             3000        4
--                                                  :
select deptno 부서번호
, dname 부서이름
, ename 직원이름
, sal 월급
, grade 급여등급
from emp e
join salgrade s
on e.sal >= s.losal and e.sal<=s.hisal
join dept d
using(deptno)
order by d.deptno, sal desc 
limit 7;




-- 11. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 이름을 '없음'이라고 출력한다. (15행)       
-- 부서번호별로 정렬한다.
-- 이름               부서번호 부서이름          
-- -------- ---------- --------------
-- CLARK        10 ACCOUNTING 
-- KING         10 ACCOUNTING 
-- MILLER       10 ACCOUNTING 
-- SMITH        20 RESEARCH       
--                         :
-- JAMES        30 SALES     
--  없음         40 OPERATIONS 
-- 없음         50 INSA
-- right join 오른쪽에 있는 행은 다 내보내라
select ifnull(ename, '없음') 이름
, deptno 부서번호
, dname 부서이름
from emp e
right join dept d
using (deptno);
select * from emp;

select * from dept;




-- 12. 직원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 아직 부서 배치를 못받은 직원도  출력하며 이경우 부서번호와 부서명은  null 로
-- 출력한다.  또한 직원들의 이름순으로 정렬한다. (14행)
-- 이름               부서번호     부서이름          
-- -------- ---------- --------------
-- ADAMS       NULL          NULL       
-- ALLEN        30             SALES      
-- BLAKE         30            SALES  
--                          :   
select ename 이름
, deptno 부서번호
, dname 부서이름
from emp e
left join dept d
using (deptno)
order by ename;



-- 13. 커미션이 정해진 모든 직원의 이름, 커미션, 부서이름, 도시명을 조회하는 sql을 작성하시오.

-- 직원명 		커미션 	부서명     		도시명  
-- -------------------------------------------
-- KING     	3500 	ACCOUNTING 	SEOUL   
-- JONES      	30 	RESEARCH   	DALLAS  
-- ALLEN     	300 	SALES      	CHICAGO 
-- WARD     	 200 	SALES      	CHICAGO 
-- MARTIN   	 300 	SALES      	CHICAGO 
-- TURNER      	0 	SALES      	CHICAGO 
select ename 직원명
, comm 커미션
, dname 부서명
, city 도시명
from emp
join dept
using (deptno)
join locations
using (loc_code)
where comm is not null;

select* 
from emp
join dept
using (deptno)
join locations
using (loc_code)
where comm is not null;

-- 14. DALLAS에서 근무하는 사원의 이름,  월급, 등급을 출력하시오.
-- 이름         월급             등급          
-- -------- --------- --------------
-- SMITH      800            1      
-- JONES      2975          4   
-- SCOTT	     3000	        4
-- FORD       3000          4     
select ename 이름
, sal 월급
, grade 등급
from emp e
join dept
using (deptno)
join locations
using (loc_code)
join salgrade s
on e.sal between s.LOSAL and s.HISAL
where city = 'DALLAS';




-- 15. 사원들의 이름, 부서번호, 부서이름을 출력하시오. 
-- 단, 직원이 없는 부서도 출력하며 이경우 직원 이름을 '누구?'라고
-- 출력한다. 아직 부서 배치를 못받은 직원도  출력하며 부서 번호와 부서 이름을
-- '어디?' 이라고 출력한다.     (16행)
-- 부서명을 기준으로 정렬한다.
-- 직원명   부서번호   부서명    
-- ----------------------------
-- CLARK  10       ACCOUNTING
-- KING   10       ACCOUNTING
-- MILLER 10       ACCOUNTING
-- 누구?  NULL     INSA      
-- 누구?  NULL     OPERATIONS
-- SMITH  20       RESEARCH  
-- JONES  20       RESEARCH  
-- SCOTT  20       RESEARCH  
-- FORD   20       RESEARCH  
-- ALLEN  30       SALES     
-- WARD   30       SALES     
-- MARTIN 30       SALES     
-- BLAKE  30       SALES     
-- TURNER 30       SALES     
-- JAMES  30       SALES     
-- ADAMS  어디?    어디?     
select ifnull(e.ename, '누구?'), d.deptno, d.dname 부서명
from emp e
right join dept d
using(deptno) 
union
select ifnull(e.ename, '누구?'), ifnull(d.deptno, '어디?'), ifnull(d.dname,'어디?')
from emp e
left join dept d
using(deptno)
order by 부서명;





select e.ename, 
		ifnull(d.deptno,'없음'),
        ifnull(d.dname, '없음') 'aaaa'
from emp e left join dept d
using(deptno)
union
select ifnull(e.ename, '누구'), 
		if(e.ename is null, null, d.deptno),
        d.dname
from emp e right join dept d
using(deptno) 
order by aaaa;



-- 16. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 
--   사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
--   '사원이름', '관리자번호', '관리자이름'으로 하여 출력하시오. 
--     관리자가 없으면 '없음'을 대신 출력한다.
--    사원번호 사원이름            관리자번호 관리자이름     
-- --------------------------------------
--     7369 SMITH    7902       FORD      
--     7499 ALLEN    7698       BLAKE     
--     7521 WARD     7698       BLAKE     
--     7566 JONES    7839       KING      
--     7654 MARTIN   7698       BLAKE     
--     7698 BLAKE    7839       KING      
--     7782 CLARK    7839       KING      
--     7788 SCOTT    7566       JONES     
--    7839 KING     없음       없음      
--     7844 TURNER   7698       BLAKE     
--     7876 ADAMS    7788       SCOTT     
--     7900 JAMES    7698       BLAKE     
--     7902 FORD     7566       JONES     
--     7934 MILLER   7782       CLARK      
-- 하나의 직원 테이블, 하나는 매니저 테이블
select e.empno 사원번호
, e.ename 사원이름
, ifnull(e.mgr, '없음') 관리자번호
, ifnull(m.ename, '없음') 관리자이름
from emp e
left join emp m
on e.mgr = m.empno;

select ename, format(sal, 0) from emp;