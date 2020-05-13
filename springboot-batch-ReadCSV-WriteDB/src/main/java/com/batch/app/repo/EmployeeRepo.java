package com.batch.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.app.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
