use quan_ly_sinh_vien;
select * from student 
where student_name like 'h%';

select * from class  
where month(start_date)  = '12';

select * from `subject`
where credit between 3 and 5;

update student
set class_id = 2
where student_name = 'hung';

select s.student_name, sub.sub_name, m.mark 
from student s 
join mark m on s.student_id = m.student_id join `subject` sub on m.sub_id = sub.sub_id
order by mark, student_name desc;
