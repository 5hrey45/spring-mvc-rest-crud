package com.example.springboot.thymeleafdemo.service;

import com.example.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByFirstName();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteByID(int id);
}
