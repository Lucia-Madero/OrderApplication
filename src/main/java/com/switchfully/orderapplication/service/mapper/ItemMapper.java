package com.switchfully.orderapplication.service.mapper;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.service.dto.item.CreateItemDto;
import com.switchfully.orderapplication.service.dto.item.ItemDto;
import com.switchfully.orderapplication.service.dto.item.UpdateItemDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemMapper {

    public Item mapCreateItemDtoToItem(CreateItemDto createItemDto) {
        return new Item(createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getAmountInStock());
    }

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setAmount(item.getAmountInStock());

    }

    public Item mapUpdateItemDtoToItemDto(UpdateItemDto updateItemDto, UUID itemId) {
                return new Item(
                itemId,
                updateItemDto.getName(),
                updateItemDto.getDescription(),
                updateItemDto.getPrice(),
                updateItemDto.getAmountInStock());
    }
}
