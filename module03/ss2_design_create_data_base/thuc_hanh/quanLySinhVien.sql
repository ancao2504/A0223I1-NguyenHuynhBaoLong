create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
class_id int primary key not null auto_increment,
class_name varchar(60) not null,
start_date datetime not null,
`status` bit
);

create table student (
student_iD int auto_increment primary key not null,
student_name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
class_id int not null,
foreign key (class_id) references class(class_id)
);

create table `subject` (
sub_id int not null auto_increment primary key,
sub_name varchar(30) not null,
credit tinyint not null default 1 check ( credit >=1),
`status` bit default 1
);

create table mark(
mark_id int not null auto_increment primary key,
sub_id int not null unique,
student_id int not null unique,
mark float default 0 check (mark between 0 and 100),
exam_times tinyint default 1
);
alter table mark add constraint foreign key (studentID) references student(studentID);
alter table mark add constraint foreign key (subID) references `subject`(subID);

