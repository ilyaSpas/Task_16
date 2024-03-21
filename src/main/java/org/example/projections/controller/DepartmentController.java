package org.example.projections.controller;

import org.example.projections.entity.Department;
import org.example.projections.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/new")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.save(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(departmentService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Department> updateEmployee(@PathVariable("id") Long id, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.update(id, department), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public HttpStatus deleteById(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return HttpStatus.OK;
    }
}
