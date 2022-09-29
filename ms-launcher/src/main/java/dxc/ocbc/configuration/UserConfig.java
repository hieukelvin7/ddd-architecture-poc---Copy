package dxc.ocbc.configuration;

import dxc.ocbc.data.UserDataImpl;
import dxc.ocbc.adapters.service.UserService;
import dxc.ocbc.adapters.data.UserData;
import dxc.ocbc.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public UserData userPersistence(){
        return new UserDataImpl();
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userPersistence());
    }
}
