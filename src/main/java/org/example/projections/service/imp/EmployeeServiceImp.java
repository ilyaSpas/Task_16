package org.example.projections.service.imp;

import org.example.projections.entity.Employee;
import org.example.projections.exception.EmployeeNotFoundException;
import org.example.projections.repository.EmployeeRepository;
import org.example.projections.repository.projection.EmployeeProjection;
import org.example.projections.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee employeeFromDB = getById(id);
        employeeFromDB.setFirstName(employeeFromDB.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.setSalary(employee.getSalary());
        employeeFromDB.setPosition(employee.getPosition());
        employeeFromDB.setDepartment(employee.getDepartment());
        return employeeFromDB;
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeProjection getProjectionById(Long id) {
        return employeeRepository.findProjectionById(id);
    }
}
