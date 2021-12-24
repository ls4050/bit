-- 전체 들의 급여 평균 출력
SELECT avg(sal) 
FROM emp;

-- 직무별 직원들의 급여 평균 출력
SELECT job, avg(sal) 
FROM emp 
GROUP BY job ;

-- 직무별 직원들의 급여 평균과 전체 급여 평균을 함께 출력 
-- 전체평균 출력
SELECT job, avg(sal) 
FROM emp 
GROUP BY job 
WITH ROLLUP;

-- 부서가 정해진 직원들에 한해서 직무별 부서별 직원들의 인원수 출력
-- 1. 직무별 , 2. 부서별 앞에 나온순서대로 큰순이다.
-- 그룹핑할때 큰거부터 그룹핑
SELECT job, deptno, count(*) 
FROM emp 
WHERE deptno is not null
GROUP BY job, deptno;

-- 부서가 정해진 직원들에 한해서 직무별 부서별 직원들의 인원수
-- 직무별 인원수, 전체 인원수도 함께 출력 - 합계도 함께 출력
SELECT job, deptno, count(*) 
FROM emp 
WHERE deptno is not null
GROUP BY job, deptno
WITH ROLLUP;

-- [ 원리 ]

-- GROUP BY a WITH ROLLUP
-- (a) -- 그룹단위의 집계결과 ...
-- () -- 전체에 대한 집계결과 ...

-- GROUP BY a, b WITH ROLLUP
-- (a, b) -- 
-- (a)
-- ()

-- GROUP BY a, b, c WITH ROLLUP
-- (a, b, c)
-- (a, b)
-- (a)
-- ()

-- 부서가 정해진 직원들에 한해서 직무별 부서별 직원들의 인원수 출력
select ifnull(job, '총합계'), ifnull(deptno, '소합계'), count(*) 
from emp
where deptno is not null
group by job, deptno
with rollup;