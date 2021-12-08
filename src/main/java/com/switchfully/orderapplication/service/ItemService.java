package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;
import com.switchfully.orderapplication.repository.ItemRepository;
import com.switchfully.orderapplication.service.dto.CreateItemDto;
import com.switchfully.orderapplication.service.dto.ItemDto;
import com.switchfully.orderapplication.service.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto addItem(CreateItemDto createItemDto) {
        Item itemToAdd = itemMapper.mapCreateItemDtoToItem(createItemDto);
        itemRepository.add(itemToAdd);
        return itemMapper.mapItemToItemDto(itemToAdd);
    }

    public void subtractOrderedAmountOfItemsInOrderFromStock(List<ItemGroup> itemGroups) {
        itemGroups.forEach(itemGroup -> reduceStockAfterOrder(itemRepository.getItemById(itemGroup.getSelectedItemId()), itemGroup));
    }

    public void reduceStockAfterOrder(Item item, ItemGroup itemGroup) {
        item.setAmountInStock(item.getAmountInStock() - itemGroup.getAmount());
    }
    public void updateStock (List<ItemGroup> itemGroupsInOrder){
       subtractOrderedAmountOfItemsInOrderFromStock(itemGroupsInOrder);
    }
}
