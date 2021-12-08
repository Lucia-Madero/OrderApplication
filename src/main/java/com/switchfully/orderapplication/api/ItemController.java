package com.switchfully.orderapplication.api;

import com.switchfully.orderapplication.domain.feature.Feature;
import com.switchfully.orderapplication.service.ItemService;
import com.switchfully.orderapplication.service.SecurityService;
import com.switchfully.orderapplication.service.dto.CreateItemDto;
import com.switchfully.orderapplication.service.dto.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/items")
public class ItemController {

    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto createItemDto, @RequestHeader String authorization) {
       securityService.validateAccess(authorization, Feature.ADD_ITEM);
       return itemService.addItem(createItemDto);
    }
}
