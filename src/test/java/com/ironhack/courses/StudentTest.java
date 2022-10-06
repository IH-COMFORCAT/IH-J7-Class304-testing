package com.ironhack.courses;

import com.ironhack.courses.models.*;
import com.ironhack.courses.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

@SpringBootTest
public class StudentTest {

    Invoice invoice;
    Student student;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
       invoice = invoiceRepository.save(
               new Invoice("Matricula 2023", 200.90, false));
       student = studentRepository.save(
               new Student("Asaf", "Laszewicki", new Address(), new Address(), invoice)
       );
    }

    @AfterEach
    void tearDown() {

        studentRepository.deleteAll();
        invoiceRepository.deleteAll();

    }

    @Test
    void invoiceDetails_get_works() {
        Assertions.assertEquals("Matricula 2023", student.getInvoice().getInvoiceReason());
        invoice.getStudent().getPostalAddress();

    }

}
