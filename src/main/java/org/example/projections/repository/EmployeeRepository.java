package org.example.projections.repository;

import org.example.projections.entity.Employee;
import org.example.projections.repository.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    EmployeeProjection findProjectionById(Long id);
}
