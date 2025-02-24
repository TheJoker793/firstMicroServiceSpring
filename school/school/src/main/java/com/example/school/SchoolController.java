package com.example.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")

public class SchoolController {
    private final SchoolService service;
    public SchoolController(SchoolService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public School save(@RequestBody School school) {
       return service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(service.getAllSchools());
    }
    @GetMapping("/with-students/{id}")
    public ResponseEntity<FullSchoolResponse> findAll(@PathVariable int id) {return ResponseEntity.ok(service.findSchoolWithStudents(id));}


    @GetMapping("/{id}")
    public School findById(@PathVariable int id){
        return service.getSchoolById(id);
    }
    @PutMapping("/{id}")
    public School update(@PathVariable int id,@RequestBody School school){
        return service.updateSchool(id,school);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
         service.deleteSchoolById(id);
    }

}
