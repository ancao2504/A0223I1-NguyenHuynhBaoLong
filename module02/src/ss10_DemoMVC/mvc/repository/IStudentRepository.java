package ss10_DemoMVC.mvc.repository;

import ss10_DemoMVC.mvc.model.Student;

import java.util.List;

public interface IStudentRepository {

    void removeStudent(Student student);

    void addStudent(Student student);

    List<Student> getAll();
}
