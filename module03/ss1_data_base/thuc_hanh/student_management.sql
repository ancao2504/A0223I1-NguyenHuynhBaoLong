create database student_management;
use student_management;
create table student (
id int primary key,
`name` varchar(255),
age int,
country varchar(255)
);

create table class (
id int primary key,
`name` varchar(255)
);

create table teacher (
id int primary key,
`name` varchar(255),
age int,
country varchar(255)
);
-- select * from .... : lấy tất cả các cột 

select * from teacher;
insert into teacher (id, `name`, age, country) values(1,'bld',12,'Vn'),
													(1,'bld',12,'Vn');
                                                    
                                                    
