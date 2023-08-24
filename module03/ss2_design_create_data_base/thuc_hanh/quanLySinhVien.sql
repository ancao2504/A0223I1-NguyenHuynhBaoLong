create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
classID int primary key not null auto_increment,
className varchar(60) not null,
startDate datetime not null,
`status` bit
);

create table student (
studentID int auto_increment primary key not null,
studentName varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit,
classID int not null,
foreign key (classID) references class(classID)
);

create table `Subject` (
SubID int not null auto_increment primary key,
SubName varchar(30) not null,
Credit tinyint not null default 1 check ( credit >=1),
`Status` bit default 1
);

create table Mark(
MarkID int not null auto_increment primary key,
SubID int not null unique,
StudentID int not null unique,
Mark float default 0 check (Mark between 0 and 100),
ExamTimes tinyint default 1
);
alter table Mark add constraint foreign key (StudentID) references student(StudentID);
alter table Mark add constraint foreign key (SubID) references `Subject`(SubID);

