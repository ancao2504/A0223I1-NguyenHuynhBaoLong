package ss10.mvc.repository;

import ss10.mvc.model.Student;

import java.util.List;

public interface IStudentRepository {

    void removeStudent(Student student);

    void addStudent(Student student);

    List<Student> getAll();
}
