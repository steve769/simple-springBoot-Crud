package info.stephenderrick.StudentData.service;


import info.stephenderrick.StudentData.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService{

    Student addStudent(Student student);

    List<Student> fetchStudents();


    Student fetchStudentByRegNo(Long regNo);

    void deleteStudentByRegNo(Long regNo);
}
