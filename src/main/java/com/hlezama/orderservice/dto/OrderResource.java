package com.hlezama.orderservice.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResource {

  private Long id;
  private String orderNumber;
  private List<OrderLineItemDto> orderLineItemList;
}
