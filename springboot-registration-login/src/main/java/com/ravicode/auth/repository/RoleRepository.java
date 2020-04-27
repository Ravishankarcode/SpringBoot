package com.ravicode.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravicode.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
