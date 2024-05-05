package com.likelion.likelionshop.service;

import com.likelion.likelionshop.dto.request.CreateOrderRequestDto;
import com.likelion.likelionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.likelionshop.dto.response.OrderResponseDto;
import com.likelion.likelionshop.entity.Order;
import com.likelion.likelionshop.repository.OrderRepository;
import com.likelion.likelionshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<OrderResponseDto> createOrders(Long userId, List<CreateOrderRequestDto> requests) {
        List<Order> orders = new ArrayList<>();
        userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));
        for (CreateOrderRequestDto request : requests) {
            Order savedOrder = orderRepository.save(request.toEntity());
            orders.add(savedOrder);
        }
        return OrderResponseDto.from(orders);
    }

    @Transactional
    public OrderResponseDto updateOrder(UpdateOrderRequestDto request, Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        order.update(request);
        orderRepository.save(order);
        return OrderResponseDto.from(order);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        return OrderResponseDto.from(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 주문이 존재하지 않습니다."));
        orderRepository.delete(order);
    }
}
