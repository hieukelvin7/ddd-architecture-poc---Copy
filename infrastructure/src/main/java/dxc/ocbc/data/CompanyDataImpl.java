package dxc.ocbc.data;

import dxc.ocbc.adapters.data.CompanyData;
import dxc.ocbc.dto.CompanyDto;
import dxc.ocbc.entity.Company;
import dxc.ocbc.entity.Employee;
import dxc.ocbc.mappers.CompanyMapper;
import dxc.ocbc.mappers.EmployeeMapper;
import dxc.ocbc.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
public class CompanyDataImpl implements CompanyData {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public CompanyDto create(CompanyDto companyDto) {
        log.info("Create successfully");
        Company company = CompanyMapper.INSTANCE.companyDtoToCompany(companyDto);

        Company companySave = companyRepository.save(company);
        return CompanyMapper.INSTANCE.companyToCompanyDto(companySave);
    }

    @Override
    public List<CompanyDto> getAll() {
        List<Company> companyList = companyRepository.findAll();
        return CompanyMapper.INSTANCE.companyListToCompanyDtoList(companyList);
    }

    @Override
    public CompanyDto findCompanyId(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            return CompanyMapper.INSTANCE.companyToCompanyDto(company.get());
        }
        return null;
    }

    @Override
    public CompanyDto update(long id, CompanyDto companyDto) {
        return create(companyDto);
    }

    @Override
    public Boolean delete(long id) {
        companyRepository.deleteById(id);
        return true;
    }
}
