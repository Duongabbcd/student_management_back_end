package com.aibles.student_management.respositories;

import com.aibles.student_management.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findSubjectById (Long id);
    List<Subject> findAll();
}
