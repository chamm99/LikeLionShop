package com.likelion.likelionshop.dto.request;

import com.likelion.likelionshop.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateOrderRequestDto {

    //상품 이름
    public String name;

    //수량
    public int quantity;

    //가격
    public int price;

    public Order toEntity() {
        return Order.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();
    }
}