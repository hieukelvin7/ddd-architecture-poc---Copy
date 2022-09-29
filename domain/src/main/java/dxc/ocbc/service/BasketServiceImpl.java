package dxc.ocbc.service;

import dxc.ocbc.dto.BasketDto;
import dxc.ocbc.adapters.service.BasketService;
import dxc.ocbc.adapters.data.BasketData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BasketServiceImpl implements BasketService {

    private BasketData basketData;

    @Autowired
    public BasketServiceImpl(BasketData basketData){
        this.basketData = basketData;
    }


    @Override
    public BasketDto saveBasket(BasketDto basket) {
        return basketData.saveBasket(basket);
    }

    @Override
    public BasketDto updateBasket(BasketDto basket) {
        return basketData.updateBasket(basket);
    }

    @Override
    public BasketDto getBasketById(Long id) {
        return basketData.getBasketById(id);
    }

    @Override
    public List<BasketDto> getAllBasket() {
        return basketData.getAllBasket();
    }
}
