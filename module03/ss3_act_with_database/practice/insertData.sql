use quan_ly_sinh_vien;
insert into class (class_id, class_name, start_date, `status` ) 
values(1, 'A1', '2008-12-20', 1),
	  (2, 'A2', '2008-12-21', 1),
	  (3, 'A3', '2008-12-22', 0),
	  (4, 'A4', '2008-12-23', 1);


insert into student (student_name, address, phone , `status`, class_id) 
values ('Hung', 'Ha Noi', '0912113113', 1, 1),
	   ('Hoa', 'Ha Noi', '0912113113', 1, 1),
	   ('Manh', 'HCM', '0912113113', 0, 2),
       ('ll', 'Ha Noi', '0912113113', 1, 1);
       

insert into subject (sub_name, credit, `status`) 
values ('CF', 5,1),
	   ('C', 6,1),
	   ('DF', 5,1),
	   ('CF', 5,1);
        

        
INSERT INTO Mark (Sub_Id, Student_Id, Mark, Exam_times)
values  (1,2,1,5),
		(2,4,2,5),
		(3,5,10,5),
		(4,6,5,5);


