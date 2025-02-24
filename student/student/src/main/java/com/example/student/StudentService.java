package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    public Student getStudentById(int id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("school not found"));
    }
    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }
    public Student updateSchool(int id, Student student)
    {
        return repository.findById(id).map(
                s->{
                    s.setFirstname(student.getFirstname());
                    s.setLastname(student.getLastname());
                    s.setEmail(student.getEmail());
                    s.setSchoolId(student.getSchoolId());
                    return repository.save(s);
                }).orElseThrow(() -> new RuntimeException("school not found"));

    }


    public List<Student> findAllStudentsBySchool(int id) {
        return repository.findAllBySchoolId(id);
    }
}
