package com.example.school;

import com.example.school.Client.StudentClients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClients studentClients;

    public SchoolService(SchoolRepository repository, StudentClients studentClients) {
        this.repository = repository;
        this.studentClients = studentClients;
    }

    public School saveSchool(School school) {
        return repository.save(school);
    }

    public List<School> getAllSchools() {
        return repository.findAll();
    }

    public School getSchoolById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("school not found"));
    }

    public void deleteSchoolById(int id) {
        repository.deleteById(id);
    }

    public School updateSchool(int id, School school) {
        return repository.findById(id).map(p -> {
            p.setName(school.getName());
            p.setEmail(school.getEmail());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("school not found"));
    }
    public FullSchoolResponse findSchoolWithStudents(int schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        new School()
                );
        var students = studentClients.findAllStudentsBySchool(schoolId);
        return new FullSchoolResponse(school.getName(), school.getEmail(), students);
    }


}
