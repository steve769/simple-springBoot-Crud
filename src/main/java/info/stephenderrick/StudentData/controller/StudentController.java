package info.stephenderrick.StudentData.controller;


import info.stephenderrick.StudentData.entity.Student;
import info.stephenderrick.StudentData.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchStudents(){
        return studentService.fetchStudents();
    }

    @GetMapping("students/{regNo}")
    public Student fetchStudentByRegNo(@PathVariable("regNo") Long regNo){
        return studentService.fetchStudentByRegNo(regNo);
    }
}
