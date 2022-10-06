package com.ironhack.courses;

import com.ironhack.courses.models.*;
import com.ironhack.courses.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {

    Student student;

    List<Exercises> exercisesList;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ExercisesRepository exercisesRepository;

    @BeforeEach
    void setUp(){

        student = studentRepository.save(
                new Student("Asaf", "Laszewicki", new ArrayList<>())
        );

        exercisesList = exercisesRepository.saveAll(
                List.of(
                        new Exercises("Java 01", 90, student),
                        new Exercises("Java 02", 80, student)
                )
        );

        student = studentRepository.findById(student.getId()).get();


    }

    @AfterEach
    void tearDown() {
        exercisesRepository.deleteAll();
        studentRepository.deleteAll();

    }

    @Test
    void invoiceDetails_get_works() {
        /*
        assertEquals("Matricula 2023", student.getInvoice().getInvoiceReason());
        invoice = invoiceRepository.findById(invoice.getId()).get();
        assertEquals("Asaf", invoice.getStudent().getName());
*/
    }

    @Test
    void oneToManyTest_exercises_ok() {
        List<Exercises> ex = student.getExercises();
        assertEquals("Java 01", ex.get(0).getTitle());
    }

}
