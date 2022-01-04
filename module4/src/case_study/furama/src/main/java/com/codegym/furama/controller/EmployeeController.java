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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/delete";
    }

    @PostMapping("/actionDelete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.remove(id);
        return "redirect:/employee/list";
    }

    @PostMapping("/create")
    public String saveEmployee(@Valid @ModelAttribute Employee employee,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Add success employee: "
                + employee.getEmployeeName());
        return "redirect:/employee/list";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute Employee employee,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/employee/edit";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Update success employee: "
                + employee.getEmployeeName());
        return "redirect:/employee/list";
    }
}
