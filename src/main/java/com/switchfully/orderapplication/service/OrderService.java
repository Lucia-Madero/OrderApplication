package com.switchfully.orderapplication.service;

import com.switchfully.orderapplication.domain.item.Item;
import com.switchfully.orderapplication.domain.item.ItemGroup;
import com.switchfully.orderapplication.domain.order.Order;
import com.switchfully.orderapplication.repository.ItemRepository;
import com.switchfully.orderapplication.repository.OrderRepository;
import com.switchfully.orderapplication.service.dto.CreateOrderDto;
import com.switchfully.orderapplication.service.dto.OrderDto;
import com.switchfully.orderapplication.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, ItemRepository itemRepository, ItemService itemService) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    public OrderDto processNewOrder(CreateOrderDto createOrderDto) {
        Order incomingOrder = orderMapper.mapCreateOrderDtoToOrder(createOrderDto);
        incomingOrder.setTotalPriceOfOrder(calculateTotalPriceOfOrder(incomingOrder.getItemGroupsInOrder()));
        calculateShippingDateOfItemGroup(incomingOrder.getItemGroupsInOrder());
        itemService.updateStock(createOrderDto.getItemGroupsInOrder());
        orderRepository.save(incomingOrder);
        return orderMapper.mapOrderToOrderDto(incomingOrder);
    }

    public void calculateShippingDateOfItemGroup(List<ItemGroup> itemGroups) {
        for (ItemGroup eachItem : itemGroups) {
            Item item = itemRepository.getItemById(eachItem.getSelectedItemId());
            if (item.isInStock(item)) {
                eachItem.setShippingDate(LocalDate.now().plusDays(1));
            } else {
                eachItem.setShippingDate(LocalDate.now().plusDays(7));
            }
        }
    }

    public int calculateTotalPriceOfOrder(List<ItemGroup> itemGroups) {
        int price = 0;
        int amount = 0;
        for (ItemGroup item : itemGroups) {
            Item itemInItemGroup = itemRepository.getItemById(item.getSelectedItemId());
            price = itemInItemGroup.getPrice();
            amount = item.getAmount();
        }
        return price * amount;
    }

}
