package dxc.ocbc;

import dxc.ocbc.adapters.service.CompanyService;
import dxc.ocbc.adapters.service.EmployeeService;
import dxc.ocbc.adapters.service.UserService;

import dxc.ocbc.dto.CompanyDto;
import dxc.ocbc.dto.EmployeeDto;
import dxc.ocbc.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableWebSecurity
@RestController
public class DDDApplication{


	public static void main(String[] args) {
		SpringApplication.run(DDDApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
@Bean
CommandLineRunner commandLineRunner (UserService userService,CompanyService companyService,EmployeeService employeeService){
	return args -> {
		userService.saveUser(new UserDto(1L,"OCBC DXC","ocbc","123456","ADMIN"));
		userService.saveUser(new UserDto(2L,"OCBC POC","ocbc1","123456","USER"));
		companyService.create(new CompanyDto(1L,"dxc"));
		//employeeService.create(new EmployeeDto(1L,"hieu","","",20));
	};
}


//	@Override
//	public void run(String... args) throws Exception {
//		CompanyDto c1 = new CompanyDto();
//		c1.setName("dxc");
//		CompanyDto c2 = new CompanyDto();
//		c2.setName("fpt");
//
//		comapnyService.create(c1);
//		comapnyService.create(c2);
//
//		EmployeeDto e1 = new EmployeeDto();
//		e1.setName("hieu");
//		e1.setEmail("hieu@gmail.com");
//		e1.setAddress("hcm");
//		e1.setAge(22);
//		e1.setCompany(c1);
//		EmployeeDto e3 = new EmployeeDto();
//		e3.setName("hoa");
//		e3.setEmail("hoa@gmail.com");
//		e3.setAddress("hcm");
//		e3.setAge(22);
//		e3.setCompany(c1);
//		EmployeeDto e4 = new EmployeeDto();
//		e4.setName("hai");
//		e4.setEmail("hai@gmail.com");
//		e4.setAddress("hcm");
//		e4.setAge(22);
//		e4.setCompany(c1);
//		EmployeeDto e2 = new EmployeeDto();
//		e2.setName("admin");
//		e2.setEmail("admin@gmail.com");
//		e2.setAddress("hanoi");
//		e2.setAge(30);
//		e2.setCompany(c2);
//		employeeService.create(e1);
//		employeeService.create(e2);
//		employeeService.create(e3);
//		employeeService.create(e4);
//	}
}
