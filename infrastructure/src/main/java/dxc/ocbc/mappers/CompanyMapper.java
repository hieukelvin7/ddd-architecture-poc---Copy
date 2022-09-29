package dxc.ocbc.mappers;

import dxc.ocbc.dto.CompanyDto;
import dxc.ocbc.dto.EmployeeDto;
import dxc.ocbc.entity.Company;
import dxc.ocbc.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);


    CompanyDto companyToCompanyDto(Company company);

    Company companyDtoToCompany(CompanyDto companyDto);

    List<CompanyDto> companyListToCompanyDtoList(List<Company> companyList);

    List<Company> companyDtoListToEmployeeList(List<CompanyDto> companyDtoList);
}
