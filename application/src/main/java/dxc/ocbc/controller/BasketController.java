package dxc.ocbc.controller;
import dxc.ocbc.dto.BasketDto;
import dxc.ocbc.adapters.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @PostMapping("/add")
    public BasketDto addBook(@RequestBody BasketDto bookDto) {
        return basketService.saveBasket(bookDto);
    }

    @PutMapping("/admin/update")
    public BasketDto updateBook(@RequestBody BasketDto bookDto) {
        return basketService.updateBasket(bookDto);
    }

    @GetMapping("/get/{id}")
    public BasketDto getBookByID(@PathVariable long id) {
        return basketService.getBasketById(id);
    }

    @GetMapping("/admin/get")
    public List<BasketDto> getAllBooks() {
        return basketService.getAllBasket();
    }
}
