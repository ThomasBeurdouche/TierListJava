package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Student;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.List;

public class StudentDto {
    private String firstName;
    private String lastName;
    private Instant birthdate;
    private List<Course> courses;
    private Major major;
    public static StudentDto builder() {
        return new StudentDto();
    }
    public static StudentDto builder(String firstName, String lastName, Instant birthdate, List<Course> courses, Major major) {
        StudentDto studentDto = new StudentDto();
        studentDto.firstName = firstName;
        studentDto.lastName = lastName;
        studentDto.birthdate = birthdate;
        studentDto.courses = courses;
        studentDto.major = major;
        return studentDto;
    }
    public StudentDto firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public StudentDto lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public StudentDto birthdate(Instant birthdate) {
        this.birthdate = birthdate;
        return this;
    }
    public StudentDto courses(List<Course> courses) {
        this.courses = courses;
        return this;
    }
    public StudentDto major(Major major) {
        this.major = major;
        return this;
    }
    public StudentDto build() {
        return this;
    }
    public StudentDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Major getMajor() {
        return major;
    }

}
