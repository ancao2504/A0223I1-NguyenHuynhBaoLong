use quan_ly_sinh_vien;
insert into class (class_id, class_name, start_date, `status` ) 
values(1, 'A1', '2008-12-20', 1),
	  (2, 'A2', '2008-12-21', 1),
	  (3, 'A3', '2008-12-22', 0),
	  (4, 'A4', '2008-12-23', 1);
select * from class;

insert into student (student_name, address, phone , `status`, class_id) 
values ('Hung', 'Ha Noi', '0912113113', 1, 1),
	   ('Hoa', 'Ha Noi', '0912113113', 1, 1),
	   ('Manh', 'HCM', '0912113113', 0, 2);
       
insert into student (student_name, address, phone , `status`, class_id) 
values ('ll', 'Ha Noi', '0912113113', 1, 1);

select * from student;

insert into subject (sub_name, credit, `status`) 
values ('CF', 5,1),
	   ('C', 6,1),
	   ('DF', 5,1),
	   ('CF', 5,1);
        
INSERT INTO Mark (Sub_Id, Student_Id, Mark, Exam_times)
values  (1,1,12,5),
		(2,3,12,5);
        
INSERT INTO Mark (Sub_Id, Student_Id, Mark, Exam_times)
values  (3,2,1,5),
		(4,4,2,5),
		(5,5,10,5),
		(6,6,5,5),
		(7,7,2,5);
select * from `subject`;
set sql_safe_updates=0;
update `subject` 
set sub_name='CF'
where sub_name = 'DF';
