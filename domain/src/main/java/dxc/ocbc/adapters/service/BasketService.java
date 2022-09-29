package dxc.ocbc.adapters.service;

import dxc.ocbc.dto.BasketDto;

import java.util.List;

public interface BasketService {
    BasketDto saveBasket(BasketDto basket);
    BasketDto updateBasket(BasketDto basket);
   BasketDto getBasketById(Long id);
    List<BasketDto> getAllBasket();

}
