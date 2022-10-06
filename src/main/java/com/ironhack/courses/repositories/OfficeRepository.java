package com.ironhack.courses.repositories;

import com.ironhack.courses.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    Optional<Office> findByFacultyLastName(String lastName);
}
