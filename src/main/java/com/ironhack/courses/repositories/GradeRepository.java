package com.ironhack.courses.repositories;

import com.ironhack.courses.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Optional<Grade> findByStudentName(String name);
    List<Grade> findByScoreBetween(int min, int max);
    List<Grade> findByStudentNameEndingWithAndScoreGreaterThan(String ending, int score);


}
