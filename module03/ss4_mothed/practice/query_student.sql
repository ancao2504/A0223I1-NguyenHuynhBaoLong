use quan_ly_sinh_vien;

select address, count(student_iD) as so_luong_hoc_vien
from student 
group by address;

select s.student_name, s.student_id, avg(m.mark)
from student s
join mark m on s.student_id = m.student_id
join `subject` sb on m.sub_id = sb.sub_id
group by s.student_name,s.student_id;

select s.student_name, s.student_id, avg(m.mark) as diem_tb
from student s
join mark m on s.student_id = m.student_id
join `subject` sb on m.sub_id = sb.sub_id
group by s.student_name,s.student_id
having diem_tb >= all (SELECT AVG(Mark) FROM Mark GROUP BY s.Student_Id)