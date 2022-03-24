package info.stephenderrick.StudentData.service;

import info.stephenderrick.StudentData.entity.Student;
import info.stephenderrick.StudentData.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public void deleteStudentByRegNo(Long regNo) {
        studentRepository.deleteById(regNo);
    }

    @Override
    public Student updateStudentByRegNo(Long regNo, Student student) {
       Student studentInDataBase = studentRepository.findById(regNo).get();

       if(Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())){
           studentInDataBase.setName(student.getName());
       }

       if(Objects.nonNull(student.getCourse()) && !"".equalsIgnoreCase(student.getCourse())){
            studentInDataBase.setCourse(student.getCourse());
       }

       return studentRepository.save(studentInDataBase);

    }


}
