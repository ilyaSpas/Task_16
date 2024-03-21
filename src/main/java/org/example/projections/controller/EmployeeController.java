package org.example.projections.controller;

import org.example.projections.entity.Employee;
import org.example.projections.repository.projection.EmployeeProjection;
import org.example.projections.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/new")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/projection")
    public ResponseEntity<EmployeeProjection> findProjectionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getProjectionById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(id, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public HttpStatus deleteById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return HttpStatus.OK;
    }
}
