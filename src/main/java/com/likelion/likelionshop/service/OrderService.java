package com.likelion.likelionshop.service;

import com.likelion.likelionshop.dto.request.CreateOrderRequestDto;
import com.likelion.likelionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.likelionshop.dto.response.OrderResponseDto;
import com.likelion.likelionshop.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
//    private final OrderRepository orderRepository;

    @Transactional
    public List<OrderResponseDto> createOrders(List<CreateOrderRequestDto> requests) {
        List<OrderResponseDto> responses = null;
        for (CreateOrderRequestDto request : requests) {
            Order order = request.toEntity();
//            orderRepository.save(order);
            responses.add(OrderResponseDto.from(order));
        }
        return responses;
    }

    @Transactional
    public OrderResponseDto updateOrder(UpdateOrderRequestDto request, Long orderId) {
        Order order = request.toEntity();
        order.update(request);
        //orderRepository.save(order);
        return OrderResponseDto.from(order);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long id) {
        Order order = null;
        //order = orderRepository.findById(id);
        return OrderResponseDto.from(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        //orderRepository.deleteById(id);
    }
}
