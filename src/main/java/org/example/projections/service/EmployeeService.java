package org.example.projections.service;

import org.example.projections.entity.Employee;
import org.example.projections.repository.projection.EmployeeProjection;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    Employee update(Long id, Employee employee);

    void deleteById(Long id);

    EmployeeProjection getProjectionById(Long id);
}
