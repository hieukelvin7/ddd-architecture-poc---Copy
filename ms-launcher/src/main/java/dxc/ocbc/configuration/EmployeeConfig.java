package dxc.ocbc.configuration;

import dxc.ocbc.adapters.data.BasketData;
import dxc.ocbc.adapters.data.EmployeeData;
import dxc.ocbc.adapters.service.BasketService;
import dxc.ocbc.adapters.service.EmployeeService;
import dxc.ocbc.data.BasketDataImpl;
import dxc.ocbc.data.EmployeeDataImpl;
import dxc.ocbc.service.BasketServiceImpl;
import dxc.ocbc.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public EmployeeData employeePersistence(){
        return new EmployeeDataImpl();
    }

    @Bean
    public EmployeeService employeeService(){
        return new EmployeeServiceImpl(employeePersistence());
    }
}
