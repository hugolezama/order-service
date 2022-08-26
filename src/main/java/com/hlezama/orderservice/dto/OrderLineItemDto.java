package com.hlezama.orderservice.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderLineItemDto {

  private Long id;
  private String sku;
  private BigDecimal price;
  private Integer quantity;
}
