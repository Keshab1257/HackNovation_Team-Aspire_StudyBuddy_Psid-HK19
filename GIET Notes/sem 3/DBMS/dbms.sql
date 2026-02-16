create database temp;

use temp;

CREATE TABLE employees (
    empno INT,
    ename VARCHAR(50),
    job VARCHAR(50),
    mgr INT,
    hiredate DATE,
    sal DECIMAL(10, 2),
    comm DECIMAL(10, 2),
    deptno INT
);


alter table emp add primary key (empno);

alter table emp add cellno int;

alter table emp modify ename varchar(20);

alter table emp rename column cellno to phoneno;

alter table emp rename to emp;

truncate table emp;

drop table emp;
alter table emp drop column phoneno;
insert into emp values(7369, "SMITH", "CLERK", 7902, "1980-12-17", 800, NULL, 20); 
insert into emp values(7499, "ALLEN", "SALESMAN",7698, "1980-02-20",1600, 300, 30), 
						(7521, "WARD", "SALESMAN", 7698, "1981-02-22", 1250, 500,30), 
						(7566, "JONES", "MANAGER", 7839,"1981-04-02", 2975, NULL, 20), 
						(7654, "MARTIN","SALESMAN",7698, "1981-09-28", 1250,1400, 30), 
						(7698, "BLAKE", "MANAGER",7839,"1981-05-01", 2850, NULL, 30), 
						(7782, "CLARK", "MANAGER", 7839, "1981-06-09",2450, NULL, 10), 
						(7788, "SCOTT", "ANALYST", 7566, "1987-04-19", 3000, NULL, 20), 
						(7839, "KING", "PRESIDENT", NULL, "1981-11-17", 5000, NULL, 10), 
						(7844, "TURNER", "SALESMAN", 7698, "1981-09-08", 1500,0,30), 
						(7876, "ADAMS", "CLERK", 7788, "1987-05-23",1100, NULL, 20);
INSERT INTO EMP values(7900, "JAMES", "CLERK", 7698, "1980-12-03",950, NULL, 30), 
						(7902, "FORD", "ANALYST",7566, "1981-12-03",3000, NULL, 20), 
						(7934, "MILLER", "CLERK",7782, "1982-01-23",1300, NULL, 10);
                        
desc emp;
select empno,deptno, mgr as reporting_manager from emp;

set sql_safe_updates = 0;

create view majorsummary as select branch,count(*) from information group by branch;

select * from emp where (job="salesman" or job="manager") and (deptno = 10 or deptno = 30);

select job,sum(sal+((sal*10)/100)) from emp group by job;

SELECT REPLACE('good morning', 'g', '') AS result;
select current_timestamp() as time;

select * from emp where sal = (select max(sal) from emp);
