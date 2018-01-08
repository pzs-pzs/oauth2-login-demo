package com.example.demo.repository;

import com.example.demo.domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoles,Long> {
}
