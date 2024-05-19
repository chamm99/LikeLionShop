package com.likelion.likelionshop.entity;

import com.likelion.likelionshop.dto.request.UpdateOrderRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "price")
    public int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(UpdateOrderRequestDto updateOrderRequestDto) {
        name = updateOrderRequestDto.getName();
        quantity = updateOrderRequestDto.getQuantity();
        price = updateOrderRequestDto.getPrice();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
