package org.example.projections.service;

import org.example.projections.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department save(Department department);

    List<Department> getAll();

    Department getById(Long id);

    Department update(Long id, Department department);

    void deleteById(Long id);
}
