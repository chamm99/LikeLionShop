package com.likelion.likelionshop.controller;

import com.likelion.likelionshop.dto.request.CreateOrderRequestDto;
import com.likelion.likelionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.likelionshop.dto.response.OrderResponseDto;
import com.likelion.likelionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class OrderController {
    private final OrderService orderService;

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    @PostMapping("/{userId}")
    public List<OrderResponseDto> createOrder(
            @PathVariable Long userId,
            @RequestBody List<CreateOrderRequestDto> requestDtoList) {
        List<OrderResponseDto> orderResponses = orderService.createOrders(userId, requestDtoList);
        for (OrderResponseDto orderResponse : orderResponses) {
            log.info(orderResponse.toString());
        }
        return orderResponses;
    }

    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping("/{orderId}")
    public OrderResponseDto getOrder(@PathVariable Long orderId) {
        OrderResponseDto orderResponse = orderService.getOrder(orderId);
        log.info(orderResponse.toString());
        return orderResponse;
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    @PutMapping("/{orderId}")
    public OrderResponseDto updateOrder(
            @RequestBody UpdateOrderRequestDto requestDto,
            @PathVariable Long orderId) {
        OrderResponseDto orderResponse = orderService.updateOrder(requestDto, orderId);
        log.info(orderResponse.toString());
        return orderResponse;
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping("/{orderId}")
    public String deleteOrder(
            @PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "주문 삭제하기";
    }

}