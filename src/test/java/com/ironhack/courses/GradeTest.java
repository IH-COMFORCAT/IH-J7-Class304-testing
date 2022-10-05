package com.ironhack.courses;

import com.ironhack.courses.models.Grade;
import com.ironhack.courses.repositories.GradeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GradeTest {
    @Autowired
    GradeRepository gradeRepository;


    @AfterEach
    void tearDown() {
        //gradeRepository.deleteAll();
    }


    @Test
    @DisplayName("Adds a new grade")
    void addGrade() {
        Grade grade = gradeRepository.save(new Grade( "Oscar", "JA001", 95));
        Optional<Grade> gradeOptional = gradeRepository.findById(grade.getId());
        Assertions.assertTrue(gradeOptional.isPresent());
        Grade gradeFromDb = gradeOptional.get();



        assertEquals("Oscar", gradeFromDb.getStudentName());

    }

    @Test
    void findByStudentName_works() {
        Grade grade = gradeRepository.save(new Grade( "Oscar", "JA001", 95));

        Optional<Grade> gradeOptional = gradeRepository.findByStudentName("Oscar");

        Assertions.assertTrue(gradeOptional.isPresent());

        assertEquals(95, gradeOptional.get().getScore());

    }

    @Test
    void findAverageBySectionId_works() {


        List<Object[]> result = gradeRepository.findAverageBySectionId();
        assertEquals(85.0000, result.get(0)[1]);
        assertEquals("Bases de datos", result.get(0)[0]);
        assertEquals(79.3333, result.get(1)[1]);
        assertEquals("Java01", result.get(1)[0]);


    }
}
