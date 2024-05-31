package com.example.springboot.thymeleafdemo.dao;

import com.example.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // we pass the entity and the primary key type to JpaRepository class
    // that's it, no implementation required, spring data jpa will handle it

    // add a method to sort by first name
    public List<Employee> findAllByOrderByFirstName();
}
