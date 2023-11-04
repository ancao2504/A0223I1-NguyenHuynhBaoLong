package manage.student.repository;

import manage.student.bean.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
