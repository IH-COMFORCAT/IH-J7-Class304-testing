package com.ironhack.courses;

import com.ironhack.courses.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoursesApplicationTests {

	@Test
	void contextLoads() {

		Student student = new Student(1l, "Jaume", "Sanchez",
				new Address("Calle Random", 1, 46900, "Malaga"),
				new Address("Calle La otra", 5, 29770, "Barcelona"));
	}

}
