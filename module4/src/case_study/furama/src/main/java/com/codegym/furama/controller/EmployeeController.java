package com.codegym.furama.controller;

import com.codegym.furama.model.Division;
import com.codegym.furama.model.EducationDegree;
import com.codegym.furama.model.Employee;
import com.codegym.furama.model.Position;
import com.codegym.furama.repository.DivisionRepository;
import com.codegym.furama.repository.EducationDegreeRepository;
import com.codegym.furama.repository.PositionRepository;
import com.codegym.furama.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return divisionRepository.findAll();
    }

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return positionRepository.findAll();
    }

    @ModelAttribute("educations")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreeRepository.findAll();
    }

    @GetMapping("/list")
    public String listEmployee(@RequestParam("name") Optional<String> name, Model model,
                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(name = "size", required = false, defaultValue = "3") int size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("employeeName").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("employeeName").descending();
        }
        Pageable pageable = PageRequest.of(page, size, order);
        Page<Employee> employees;
        if (name.isPresent()) {
            employees = employeeService.findAllByEmployeeNameContaining(name.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        model.addAttribute("employees", employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee, Model model){
        employeeService.save(employee);
//        model.addAttribute("message", "Saved successfully");
        return "redirect:/employee/list";
    } 
}
