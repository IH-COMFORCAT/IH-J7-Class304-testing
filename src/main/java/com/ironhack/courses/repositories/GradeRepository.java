package com.ironhack.courses.repositories;

import com.ironhack.courses.models.Grade;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    Optional<Grade> findByStudentName(String name);
    List<Grade> findByScoreBetween(int min, int max);
    //List<Grade> findByStudentNameEndingWithAndScoreGreaterThan(String ending, int score);

    //select section_id, AVG(score) from grade group by section_id ORDER by AVG(score) DESC;
    @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId ORDER BY AVG(score) DESC")
    List<Object[]> findAverageBySectionId();

}
