package com.aibles.student_management.respositories;


import com.aibles.student_management.common.UserRole;
import com.aibles.student_management.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(UserRole name);
}
