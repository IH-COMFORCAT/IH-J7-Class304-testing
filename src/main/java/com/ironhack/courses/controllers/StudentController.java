package com.ironhack.courses.controllers;

import com.ironhack.courses.models.*;
import com.ironhack.courses.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> showStudents() {
        return studentRepository.findAll();


    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        Student result =  studentRepository.save(student);

        result.getExercises().forEach(e -> e.setStudent(result));
        return studentRepository.save(result);
    }


}
