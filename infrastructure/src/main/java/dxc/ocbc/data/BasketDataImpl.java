package dxc.ocbc.data;

import dxc.ocbc.dto.BasketDto;
import lombok.extern.slf4j.Slf4j;
import dxc.ocbc.entity.Basket;
import dxc.ocbc.mappers.BasketMapper;
import dxc.ocbc.repository.BasketRepository;
import dxc.ocbc.adapters.data.BasketData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j

public class BasketDataImpl implements BasketData {

    @Autowired
    private  BasketRepository basketRepository;

    @Override
    public BasketDto saveBasket(BasketDto basketDto) {
        log.info("Save successfully");
        Basket basket = BasketMapper.INSTANCE.basketDtoToBasket(basketDto);

         Basket basketSave = basketRepository.save(basket);
        return BasketMapper.INSTANCE.basketToBasketDto(basketSave);

    }

    @Override
    public BasketDto updateBasket(BasketDto basket) {
        return saveBasket(basket);
    }

    @Override
    public BasketDto getBasketById(Long id) {
        Optional<Basket> basket = basketRepository.findById(id);

        if (basket.isPresent()) {
            return BasketMapper.INSTANCE.basketToBasketDto(basket.get());
        }

        return null;
    }

    @Override
    public List<BasketDto> getAllBasket() {
        List<Basket> bookList = basketRepository.findAll();

        return BasketMapper.INSTANCE.basketListToBasketDtoList(bookList);
    }
}
