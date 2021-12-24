-- from > where > group by(그룹단위로 데이터가 나온다) > 
-- emp 테이블로부터 deptno가 널이 아닌 값들을 추려내고 이들을 deptno로 그룹핑한다
select deptno, sum(sal) from emp where deptno is not null group by deptno;

-- 부서별 최저월급, 최고월급
select deptno, min(sal) from emp where deptno is not null group by deptno;
select deptno, max(sal) from emp where deptno is not null group by deptno;

-- count 행의 수를 센다
-- count 는 null이 아닌 수만 센다
-- count(*)는 null까지 다 세버린다
select deptno, count(*) from emp where deptno is not null group by deptno;

-- 그룹으로 나눈 컬럼을 select에 무조건 써줘 그래야 명시적으로 나눈 것들의 수나 각종 정보를 알아볼 수 있다.
-- 그룹을 사용 했을때는 select절에 그룹을 나눈 컬럼, 집계함수만 올 수 있다
select year(hiredate), sum(sal), avg(sal), min(sal), max(sal) from emp group by year(hiredate);


-- group by 기준1, 기준2 ... 기준2부터는 서브그룹
-- deptno를 기준으로 그룹을 나누고 그 안에서 job으로 한번 더 나눈다
select deptno, job, count(*) from emp where deptno is not null group by deptno, job;

-- 그룹단위로 나눈 것들 중에서 일정값보다 작은 애들을 빼고 추출하고 싶을때 Having사용
-- 행에 대한 조건 = where
-- 그룹에 대한 조건 = having
-- Group by와 Having은 짝
select year(hiredate), count(*) from emp group by year(hiredate) having count(*) >= 2;
select year(hiredate), sum(sal) from emp group by year(hiredate) having sum(sal) > 1000;


-- with rollup 총합을 구해준다
-- 무조건 group by랑 같이 쓴다.
select job, sum(sal) '급여' from emp group by job with rollup;
select ifnull(job, '합계') 직무, sum(sal) '급여' from emp group by job with rollup;
-- job이 null일때는 모든직무합게를 내보내라, ename이 null일때는 소합게로 내보내라
select ifnull(job, '모든 직무 합계'), ifnull(ename, '소합계'), sum(sal) '급여'
from emp
group by job, ename
with rollup;