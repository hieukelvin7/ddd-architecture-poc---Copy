package dxc.ocbc.Graphql;

import dxc.ocbc.adapters.service.CompanyService;
import dxc.ocbc.adapters.service.EmployeeService;
import dxc.ocbc.dto.CompanyDto;
import dxc.ocbc.dto.EmployeeDto;
import dxc.ocbc.requestBodyObject.EmployeeInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
//@RestController
//@RequestMapping("/employee")
public class EmployeeController{
    private final EmployeeService employeeService;
    private final CompanyService companyService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, CompanyService companyService) {
        this.employeeService = employeeService;
        this.companyService = companyService;
    }


    @MutationMapping("createEmployee")
    public EmployeeDto createEmployee (@Argument EmployeeInput employee){
       // CompanyDto company = companyRepository.findById(employee.getCompanyId()).get();
        CompanyDto company = companyService.findCompanyId(employee.getCompanyId());
        EmployeeDto emp = new EmployeeDto();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        emp.setCompanyId(company.getId());
        return employeeService.create(emp);
    }
    @MutationMapping("updateEmployee")
    public EmployeeDto update (@Argument Long id ,@Argument EmployeeInput employee){
        CompanyDto company = companyService.findCompanyId(employee.getCompanyId());
        EmployeeDto emp = new EmployeeDto();
        emp.setId(id);
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setAddress(employee.getAddress());
        emp.setAge(employee.getAge());
        emp.setCompanyId(company.getId());
        return employeeService.update(id,emp);
    }

    @QueryMapping("allEmployees")
//    @GetMapping(value = "/")
    public List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

    @QueryMapping("getEmployee")
    @GetMapping()
    public EmployeeDto get(@Argument long id){
        return employeeService.get(id);
    }

    @MutationMapping("deleteEmployee")
    public Boolean delete (@Argument long id){
        return employeeService.delete(id);
    }



}
