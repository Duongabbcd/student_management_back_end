package com.aibles.student_management.respositories;


import com.aibles.student_management.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Long> {
   List<Mark> findAllByUserId(Long id);

    Optional <Mark> findById(Long id);

}
