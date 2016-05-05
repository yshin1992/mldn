create database mldn default charset=utf8;

use mldn;

create table dept(
deptno int not null primary key,
dname nvarchar(14) not null,
loc nvarchar(13)
)engine = innoDB default charset=utf8;

alter table dept comment '部门表';

create table emp(
empno int primary key,
ename nvarchar(10) not null,
job nvarchar(9),
hiredate date,
sal numeric(7,2),
comm numeric(7,2)) engine=innoDB default charset=utf8;

alter table emp comment '雇员表';

insert into dept(deptno,dname,loc) values(1,'技术研发部','二楼');