package com.ironhack.courses.repositories;

import com.ironhack.courses.models.Grade;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
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

    @Query("SELECT MAX(score), sectionId FROM Grade GROUP BY sectionId")
    List<Object[]> findMaxScoreBySectionId();

    @Query("SELECT MAX(score) FROM Grade WHERE sectionId = ?1")
    Optional<Object> findMaxScoreBySectionId(String sectionId);

    @Query("SELECT AVG(score) FROM Grade WHERE sectionId = :variable1 AND score > :variable2")
    Optional<Object> findAverageBySectionId(String variable1, Integer variable2);

    @Query(value = "SELECT student_name, CAST(AVG(score) AS double) FROM" +
            " grade GROUP BY student_name HAVING AVG(score) > :score " +
            "ORDER BY student_name DESC", nativeQuery = true)
    List<Object[]> findAverageDoubleByStudent(@Param("score") double score);

}
