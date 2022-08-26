package com.hlezama.orderservice.service;

import com.hlezama.orderservice.dto.OrderResource;
import com.hlezama.orderservice.mapper.OrderMapper;
import com.hlezama.orderservice.model.Order;
import com.hlezama.orderservice.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderResource createOrder(OrderResource orderResource) {

    Order order = OrderMapper.toEntity(orderResource);
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setId(null);

    return OrderMapper.toDto(orderRepository.save(order));
  }

  public List<OrderResource> listOrders() {
    return OrderMapper.toDto(orderRepository.findAll());
  }
}
