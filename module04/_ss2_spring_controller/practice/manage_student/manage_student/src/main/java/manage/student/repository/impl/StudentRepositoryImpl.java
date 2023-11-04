package manage.student.repository.impl;

import manage.student.bean.Student;
import manage.student.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    @Override
    public List<Student> findAll() {

        return null;
    }
}
