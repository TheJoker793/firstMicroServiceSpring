package com.example.school.Client;

import com.example.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${spring.config.students-url}")
public interface StudentClients {
    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable ("school-id")Integer schoolId);
}
