package info.stephenderrick.StudentData.service;


import info.stephenderrick.StudentData.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService{

    Student addStudent(Student student);

    List<Student> fetchStudents();


    Student fetchStudentByRegNo(Long regNo);

    void deleteStudentByRegNo(Long regNo);

    Student updateStudentByRegNo(Long regNo, Student student);

    List<Student> getAllStudentsWithSorting(String field);

    Page<Student> getAllStudentsWithPagination(int offset, int pageSize);

    Page<Student> getAllStudentsWithPaginationAndSorting(int offset, int pageSize, String field);
}
