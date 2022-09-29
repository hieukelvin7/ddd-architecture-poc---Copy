package dxc.ocbc.adapters.service;

import dxc.ocbc.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    CompanyDto create(CompanyDto companyDto);
    List<CompanyDto> getAll();

    CompanyDto findCompanyId(Long id);
    CompanyDto update(long id, CompanyDto companyDto);

    Boolean delete(long id);
}
