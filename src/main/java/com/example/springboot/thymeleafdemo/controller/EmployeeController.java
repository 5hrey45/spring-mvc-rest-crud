package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // constructor injection, autowired is optional as we only have one constructor
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // get the employees from db
        List<Employee> employeesData = employeeService.findAllByOrderByFirstName();

        // add it to the spring model
        theModel.addAttribute("employees", employeesData);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model theModel) {
        theModel.addAttribute("employee", new Employee());
        return "employees/add-employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateForm(@RequestParam("employeeId") int theId, Model theModel) {
        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepolulate the form
        theModel.addAttribute(theEmployee);

        // return the form
        return "employees/add-employee-form";
    }

    @PostMapping("/save")
    public String saveEmployees(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeService.deleteByID(theId);
        return "redirect:/employees/list";
    }
}
