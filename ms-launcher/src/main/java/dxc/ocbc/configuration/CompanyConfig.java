package dxc.ocbc.configuration;

import dxc.ocbc.adapters.data.CompanyData;
import dxc.ocbc.adapters.service.CompanyService;
import dxc.ocbc.data.CompanyDataImpl;
import dxc.ocbc.service.CompanyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
    @Bean
    public CompanyData companyPersistence(){
        return new CompanyDataImpl();
    }

    @Bean
    public CompanyService companyService(){
        return new CompanyServiceImpl(companyPersistence());
    }
}
