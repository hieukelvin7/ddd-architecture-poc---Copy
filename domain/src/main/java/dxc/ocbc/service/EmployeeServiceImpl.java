package dxc.ocbc.service;

import dxc.ocbc.adapters.data.EmployeeData;
import dxc.ocbc.adapters.service.EmployeeService;
import dxc.ocbc.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeData employeeData;

    @Autowired
    public EmployeeServiceImpl(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }


    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        return employeeData.create(employeeDto);
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeData.getAll();
    }

    @Override
    public EmployeeDto get(long id) {
        return employeeData.get(id);
    }

    @Override
    public EmployeeDto update(long id, EmployeeDto employeeDto) {
        return employeeData.update(id,employeeDto);
    }

    @Override
    public Boolean delete(long id) {
        employeeData.delete(id);
        return true;
    }
}
