package MVC.repository.impl;

import MVC.model.Student;
import MVC.repository.IStudentRepository;

import java.util.LinkedList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private List<Student> listStudent = new LinkedList<>();
    @Override
    public void addStudent(Student student) {
        listStudent.add(student);
    }
}
