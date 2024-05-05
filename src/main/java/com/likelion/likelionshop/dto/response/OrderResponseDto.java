package com.likelion.likelionshop.dto.response;

import com.likelion.likelionshop.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderResponseDto {

    public Long id;

    public String name;

    public int quantity;

    public int price;

    public static OrderResponseDto from(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .name(order.getName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();
    }

    public static List<OrderResponseDto> from(List<Order> orders) {
        return orders.stream().map(OrderResponseDto::from).collect(Collectors.toList());
    }
}
