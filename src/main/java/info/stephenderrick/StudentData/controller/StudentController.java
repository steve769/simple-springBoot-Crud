package info.stephenderrick.StudentData.controller;


import info.stephenderrick.StudentData.dto.APIResponse;
import info.stephenderrick.StudentData.entity.Student;
import info.stephenderrick.StudentData.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    @GetMapping("/students/sorting/{field}")
    public APIResponse<List<Student>> getAllStudentsWithSorting(@PathVariable("field") String field){
            List<Student> allStudents = studentService.getAllStudentsWithSorting(field);

            return new APIResponse<>(allStudents.size(), allStudents);
    }
    @GetMapping("/students/pagination/{offset}/{pageSize}")
    public APIResponse<Page<Student>> getAllStudentsWithPagination(@PathVariable("offset") int offset,
                                                                   @PathVariable("pageSize") int pageSize){
        Page<Student> allStudents = studentService.getAllStudentsWithPagination(offset, pageSize);

        return new APIResponse<>(allStudents.getSize(), allStudents);
    }
    @GetMapping("/students/pagination/{offset}/{pageSize}/{field}")
    public APIResponse<Page<Student>> getAllStudentsWithPaginationAndSorting(@PathVariable("offset") int offset,
                                                                   @PathVariable("pageSize") int pageSize,
                                                                             @PathVariable("field") String field){
        Page<Student> allStudents = studentService.getAllStudentsWithPaginationAndSorting(offset, pageSize, field);

        return new APIResponse<>(allStudents.getSize(), allStudents);
    }
    @DeleteMapping("/students/{regNo}")
    public String deleteStudentByRegNo (@PathVariable("regNo") Long regNo){
        studentService.deleteStudentByRegNo(regNo);
        return "Student successfully deleted!";
    }
    @PutMapping("/students/{regNo}")
    public Student updateStudentByRegNo(@PathVariable("regNo") Long regNo, @RequestBody Student student){
        return studentService.updateStudentByRegNo(regNo, student);
    }
}
