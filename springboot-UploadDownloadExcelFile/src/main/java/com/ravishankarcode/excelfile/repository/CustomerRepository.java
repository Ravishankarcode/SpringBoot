package com.ravishankarcode.excelfile.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravishankarcode.excelfile.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
