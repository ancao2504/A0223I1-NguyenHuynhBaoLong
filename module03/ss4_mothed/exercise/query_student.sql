use quan_ly_sinh_vien;

select *
from `subject` 
group by sub_id, sub_name,`status`
having max(credit)>= all (select max(credit)  from `subject` );

select s.sub_id, s.sub_name, s.credit, s.`status`, max(m.mark) as diem_cao
from `subject` s
join mark m on s.sub_id = m.sub_id
group by s.sub_id, s.sub_name,`status`
having diem_cao >=  (select max(m.mark) from mark m );

select s.*, avg(m.mark)
from student s
join mark m on s.student_iD = m.student_iD
group by s.student_iD, s.student_name, s.address, s.phone, s.`status`, s.class_id
