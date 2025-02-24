package com.example.student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    @GetMapping("/bySchool/{id}")
    public ResponseEntity<List<Student>> findAll(@PathVariable int id) {
        return ResponseEntity.ok(service.findAllStudentsBySchool(id));
    }


    @GetMapping("/{id}")
    public Student findById(@PathVariable int id){
        return service.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable int id,@RequestBody Student std){
        return service.updateSchool(id,std);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.deleteStudentById(id);
    }
}
