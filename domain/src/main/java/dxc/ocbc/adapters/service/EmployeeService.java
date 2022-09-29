package dxc.ocbc.adapters.service;

import dxc.ocbc.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
    EmployeeDto get(long id);

    EmployeeDto update(long id, EmployeeDto employeeDto);

    Boolean delete(long id);
}
