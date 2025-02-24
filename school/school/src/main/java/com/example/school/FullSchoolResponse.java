package com.example.school;
import lombok.Builder;

import java.util.List;

@Builder

public class FullSchoolResponse {
    private String name;
    private String email;
    List<Student> students;
    public FullSchoolResponse(String name, String email, List<Student> students) {
        this.name = name;
        this.email = email;
        this.students = students;
    }
    public FullSchoolResponse(){}
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
