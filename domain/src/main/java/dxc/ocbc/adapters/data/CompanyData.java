package dxc.ocbc.adapters.data;

import dxc.ocbc.dto.CompanyDto;

import java.util.List;

public interface CompanyData {
    CompanyDto create(CompanyDto companyDto);
    List<CompanyDto> getAll();

    CompanyDto findCompanyId(Long id);
    CompanyDto update(long id, CompanyDto companyDto);

    Boolean delete(long id);
}
