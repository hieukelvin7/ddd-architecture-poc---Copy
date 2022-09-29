package dxc.ocbc.service;

import dxc.ocbc.adapters.data.CompanyData;
import dxc.ocbc.adapters.service.CompanyService;
import dxc.ocbc.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyData companyData;

    @Autowired
    public CompanyServiceImpl(CompanyData companyData) {
        this.companyData = companyData;
    }

    @Override
    public CompanyDto create(CompanyDto companyDto) {
        return companyData.create(companyDto);
    }

    @Override
    public List<CompanyDto> getAll() {
        return companyData.getAll();
    }

    @Override
    public CompanyDto findCompanyId(Long id) {
        return companyData.findCompanyId(id);
    }

    @Override
    public CompanyDto update(long id, CompanyDto companyDto) {
        return companyData.update(id,companyDto);
    }

    @Override
    public Boolean delete(long id) {
         companyData.delete(id);
         return true;
    }
}
