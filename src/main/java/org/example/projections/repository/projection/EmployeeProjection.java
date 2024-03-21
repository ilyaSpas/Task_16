package org.example.projections.repository.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {

    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    @Value("#{target.position}")
    String getPosition();

    @Value("#{target.deprtment.name}")
    String getDepartmentName();
}
