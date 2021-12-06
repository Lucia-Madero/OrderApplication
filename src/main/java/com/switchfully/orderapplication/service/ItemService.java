package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.repository.ItemRepository;
import com.switchfully.orderapplication.service.dto.CreateItemDto;
import com.switchfully.orderapplication.service.dto.ItemDto;
import com.switchfully.orderapplication.service.mapper.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    ItemRepository itemRepository;
    ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto addItem(CreateItemDto createItemDto) {
       Item itemToAdd = itemMapper.mapCreateItemDtoToItem(createItemDto);
       itemRepository.add(itemToAdd);
       return itemMapper.mapItemToItemDto(itemToAdd);
    }
}
