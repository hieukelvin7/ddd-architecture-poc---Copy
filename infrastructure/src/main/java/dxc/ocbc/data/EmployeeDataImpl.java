package dxc.ocbc.data;

import dxc.ocbc.adapters.data.EmployeeData;
import dxc.ocbc.dto.EmployeeDto;
import dxc.ocbc.entity.Basket;
import dxc.ocbc.entity.Employee;
import dxc.ocbc.mappers.BasketMapper;
import dxc.ocbc.mappers.EmployeeMapper;
import dxc.ocbc.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Slf4j
public class EmployeeDataImpl implements EmployeeData {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        log.info("Create successfully");
        Employee employee = EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeDto);

        Employee employeeSave = employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employeeSave);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        return EmployeeMapper.INSTANCE.employeeListToEmployeeDtoList(employeeList);
    }

    @Override
    public EmployeeDto get(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return EmployeeMapper.INSTANCE.employeeToEmployeeDto(employee.get());
        }

        return null;
    }

    @Override
    public EmployeeDto update(long id, EmployeeDto employeeDto) {
        return create(employeeDto);
    }

    @Override
    public Boolean delete(long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
