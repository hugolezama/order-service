package com.hlezama.orderservice.mapper;

import com.hlezama.orderservice.dto.OrderLineItemDto;
import com.hlezama.orderservice.dto.OrderResource;
import com.hlezama.orderservice.model.Order;
import com.hlezama.orderservice.model.OrderLineItem;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

  public static OrderResource toDto(Order order) {

    return (order == null) ? null : OrderResource.builder()
        .id(order.getId())
        .orderNumber(order.getOrderNumber())
        .orderLineItemList(toOrderLineItemDtoList(order.getOrderLineItemList()))
        .build();
  }

  public static Order toEntity(OrderResource orderResource) {

    return (orderResource == null) ? null : Order.builder()
        .id(orderResource.getId())
        .orderNumber(orderResource.getOrderNumber())
        .orderLineItemList(toOrderLineItemList(orderResource.getOrderLineItemList()))
        .build();
  }

  public static OrderLineItemDto toDto(OrderLineItem orderLineItem) {
    return (orderLineItem == null) ? null : OrderLineItemDto.builder()
        .id(orderLineItem.getId())
        .quantity(orderLineItem.getQuantity())
        .sku(orderLineItem.getSku())
        .price(orderLineItem.getPrice())
        .build();
  }

  public static OrderLineItem toEntity(OrderLineItemDto orderLineItemDto) {
    return (orderLineItemDto == null) ? null : OrderLineItem.builder()
        .id(orderLineItemDto.getId())
        .quantity(orderLineItemDto.getQuantity())
        .sku(orderLineItemDto.getSku())
        .price(orderLineItemDto.getPrice())
        .build();
  }

  public static List<OrderResource> toDto(List<Order> orders) {

    return orders.stream().map(OrderMapper::toDto).collect(Collectors.toList());
  }

  public static List<Order> toEntity(List<OrderResource> orderResources) {

    return orderResources.stream().map(OrderMapper::toEntity).collect(Collectors.toList());
  }

  public static List<OrderLineItemDto> toOrderLineItemDtoList(List<OrderLineItem> orderLineItems) {

    return orderLineItems.stream().map(OrderMapper::toDto).collect(Collectors.toList());
  }

  public static List<OrderLineItem> toOrderLineItemList(List<OrderLineItemDto> orderLineItemDtos) {

    return orderLineItemDtos.stream().map(OrderMapper::toEntity).collect(Collectors.toList());
  }

}
