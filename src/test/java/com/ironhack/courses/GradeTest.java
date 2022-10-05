package com.ironhack.courses;

import com.ironhack.courses.models.*;
import com.ironhack.courses.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GradeTest {
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

    List<Grade> grades;
    List<Course> courses;

    List<Section> sections;

    @BeforeEach
    void setUp() {

        courses = courseRepository.saveAll(List.of(
                new Course("CS101", "Intro to java"),
                new Course("CS103", "Databases")
        ));

        sections = sectionRepository.saveAll(List.of(
                new Section("CS101-A", "CS101", (short) 1802, "Balderez"),
                new Section("CS101-B", "CS101", (short) 1650, "Su"),
                new Section("CS103-A", "CS103", (short) 1200, "Rojas"),
                new Section("CS103-B", "CS103", (short) 1208, "Tonno")
        ));

        grades = gradeRepository.saveAll(List.of(
                new Grade("Maya Charlotte", "CS101-A", 98),
                new Grade("James Fields", "CS101-A", 82),
                new Grade("Michael Alcocer", "CS101-B", 65),
                new Grade("Maya Charlotte", "CS103-A", 89),
                new Grade("Tomas Lacroix", "CS101-A", 99),
                new Grade("Sara Bisat", "CS101-A", 87),
                new Grade("James Fields", "CS101-B", 46),
                new Grade("Helena Sepulvida", "CS103-A", 72)
        ));

    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
        sectionRepository.deleteAll();
        gradeRepository.deleteAll();
    }


    @Test
    @DisplayName("Adds a new grade")
    void addGrade() {
        Grade grade = gradeRepository.save(new Grade("Oscar", "JA001", 95));
        Optional<Grade> gradeOptional = gradeRepository.findById(grade.getId());
        Assertions.assertTrue(gradeOptional.isPresent());
        Grade gradeFromDb = gradeOptional.get();


        assertEquals("Oscar", gradeFromDb.getStudentName());

    }

    @Test
    void findByStudentName_works() {
        Grade grade = gradeRepository.save(new Grade("Oscar", "JA001", 95));

        Optional<Grade> gradeOptional = gradeRepository.findByStudentName("Oscar");

        Assertions.assertTrue(gradeOptional.isPresent());

        assertEquals(95, gradeOptional.get().getScore());

    }

    @Test
    void findAverageBySectionId_works() {


        List<Object[]> result = gradeRepository.findAverageBySectionId();
        assertEquals(91.5, result.get(0)[1]);
        assertEquals("CS101-A", result.get(0)[0]);
        assertEquals(80.5, result.get(1)[1]);
        assertEquals("CS103-A", result.get(1)[0]);


    }
}
