package org.example.projections.service.imp;

import org.example.projections.entity.Department;
import org.example.projections.exception.DepartmentNotFoundException;
import org.example.projections.repository.DepartmentRepository;
import org.example.projections.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
    }

    @Override
    public Department update(Long id, Department department) {
        Department departmentFromDB = getById(id);
        departmentFromDB.setName(department.getName());
        departmentFromDB.setEmployees(department.getEmployees());
        return departmentFromDB;
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
