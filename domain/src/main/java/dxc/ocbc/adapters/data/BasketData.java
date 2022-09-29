package dxc.ocbc.adapters.data;

import dxc.ocbc.dto.BasketDto;

import java.util.List;

public interface BasketData {
    BasketDto saveBasket(BasketDto basket);
    BasketDto updateBasket(BasketDto basket);
    BasketDto getBasketById(Long id);
    List<BasketDto> getAllBasket();
}
