package com.ironhack.courses.repositories;

import com.ironhack.courses.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ExercisesRepository extends JpaRepository<Exercises, Long> {
    List<Exercises> findByStudent(Student student);
}
