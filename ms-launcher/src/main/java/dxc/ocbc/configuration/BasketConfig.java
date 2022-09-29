package dxc.ocbc.configuration;

import dxc.ocbc.data.BasketDataImpl;
import dxc.ocbc.adapters.service.BasketService;
import dxc.ocbc.adapters.data.BasketData;
import dxc.ocbc.service.BasketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketConfig {

    @Bean
    public BasketData basketPersistence(){
        return new BasketDataImpl();
    }

    @Bean
    public BasketService basketService(){
        return new BasketServiceImpl(basketPersistence());
    }
}
