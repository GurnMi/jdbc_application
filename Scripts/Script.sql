select * from department;

insert into department values(4, '개발1',10);

delete from department where deptno =4;
delete from department;
delete from employee;
delete from title;

select * from title;

insert into department values(1,'영업',	8),
(2,	'기획'	,10),
(3,	'개발'	,9),
(5	,'연구',	1);

insert into title values(1,'사장'),(2,'부장'),(3,'과장'),(4, '대리'),(5, '사원');

insert into title values(1, '사장');
insert into title values(2, '대리');
insert into title values(3, '사원');

delete from title where titleno = 2;

select titleno, titlename from title where titleno =3;

update title set titlename='사원' where titleno=3;


select * from employee;
select empno, empname, title, manager, salary, dno from employee;

insert into employee values
(4377,	'이성래',	1,	null,	5000000,	2	);

insert into employee values
(1003,	'조민희',	3,	4377,	3000000,	2	);

insert into employee values(1004,	'김태희',	5,	1003,	1540000,	2	);


insert into employee values(1005,	'송중기',	5,	1003,	2000000,	2	);
insert into employee values(1006,	'송혜교',	2,	4377,	4500000,	2	);
insert into employee values
(3426,	'박영권',	3,	4377,	3000000,	1	),
(1365,	'김상원',	5,	3426,	1500000,	1	),
(2106,	'김창섭',	4,	1003,	2625000,	3	),
(3011,	'이수민',	2,	4377,	4000000,	3	),
(3427,	'최종철',	5,	3011,	1500000,	3	);

delete from employee where empno =200;

insert into employee values(1003,'조민희',3, null , 3000000,4);

insert into department values (10, '홍길동', 3, 1, 1500000,1);