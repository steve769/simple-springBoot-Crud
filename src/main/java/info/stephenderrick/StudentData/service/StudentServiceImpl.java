package info.stephenderrick.StudentData.service;

import info.stephenderrick.StudentData.entity.Student;
import info.stephenderrick.StudentData.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentByRegNo(Long regNo) {
        Optional<Student> student = studentRepository.findById(regNo);

        return student.get();
    }


}
