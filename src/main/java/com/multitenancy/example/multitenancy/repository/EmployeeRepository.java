package com.multitenancy.example.multitenancy.repository;


import com.multitenancy.example.multitenancy.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
