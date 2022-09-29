package dxc.ocbc.mappers;

import dxc.ocbc.dto.EmployeeDto;
import dxc.ocbc.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    //@Mapping(source = "employee.companyId",target = "companyId")
    EmployeeDto employeeToEmployeeDto(Employee employee);
    //@Mapping(source = "employeeDto.companyId",target = "companyId")

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);


    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> employeeList);

    List<Employee> employeeDtoListToEmployeeList(List<EmployeeDto> employeeDtoList);
}
