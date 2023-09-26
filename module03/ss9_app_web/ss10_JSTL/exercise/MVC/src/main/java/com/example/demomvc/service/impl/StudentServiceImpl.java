package com.example.demomvc.service.impl;

import com.example.demomvc.model.Student;
import com.example.demomvc.service.IStudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student(1, "Nhi", false, 6));
        students.put(2, new Student(2, "Hà", false, 5));
        students.put(3, new Student(3, "Nhật Long", true, 1));
        students.put(4, new Student(4, "Quang Ánh", true, 8));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
