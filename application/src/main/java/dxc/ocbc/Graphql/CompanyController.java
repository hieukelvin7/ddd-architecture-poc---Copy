package dxc.ocbc.Graphql;

import dxc.ocbc.adapters.service.CompanyService;
import dxc.ocbc.dto.CompanyDto;
import dxc.ocbc.requestBodyObject.CompanyInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController( CompanyService companyService) {
        this.companyService = companyService;
    }


    @MutationMapping("createCompany")
    public CompanyDto create (@Argument CompanyInput company){
        CompanyDto c = new CompanyDto();
        c.setName(company.getName());
        return companyService.create(c);
    }
    @MutationMapping("updateCompany")
    public CompanyDto update (@Argument Long id ,@Argument CompanyInput company){
        CompanyDto c = new CompanyDto();
        c.setId(id);
        c.setName(company.getName());
        return companyService.update(id,c);
    }
    @MutationMapping("deleteCompany")
    public Boolean delete (@Argument long id){
        return companyService.delete(id);
    }

    @QueryMapping("allCompany")
    public List<CompanyDto> getAll (){
        return companyService.getAll();
    }

    @QueryMapping("getCompany")
    public CompanyDto get (@Argument Long id){
        return companyService.findCompanyId(id);
    }
}
