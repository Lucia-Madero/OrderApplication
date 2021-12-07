package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.repository.ItemRepository;
import com.switchfully.orderapplication.service.ItemService;
import com.switchfully.orderapplication.service.dto.CreateItemDto;
import com.switchfully.orderapplication.service.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/items")
public class ItemController {

    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createItemDto) {
       return itemService.addItem(createItemDto);
    }
}
