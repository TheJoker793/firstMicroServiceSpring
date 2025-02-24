package com.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolService {
    private final SchoolRepository repository;
    public SchoolService(SchoolRepository repository) {
        this.repository = repository;
    }
    public School saveSchool(School school) {
        return repository.save(school);
    }

    public List<School> getAllSchools() {
        return repository.findAll();
    }
    public School getSchoolById(int id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("school not found"));
    }
    public void deleteSchoolById(int id) {
        repository.deleteById(id);
    }
    public School updateSchool(int id, School school) {
        return repository.findById(id).map(
                p->{
                   p.setName(school.getName());
                   p.setEmail(school.getEmail());
                   return repository.save(p);
                }).orElseThrow(() -> new RuntimeException("school not found"));

    }

    public FullSchoolResponse findSchoolWithStudents(int id) {
        var school=repository.findById(id)
                .orElse(School.builder()
                        .name("Not found")
                        .email("Not found")
                        .build());
        var students=null;
        return null;
    }
}
