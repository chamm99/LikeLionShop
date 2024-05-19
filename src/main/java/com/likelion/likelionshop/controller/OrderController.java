package com.likelion.likelionshop.controller;

import com.likelion.likelionshop.dto.request.CreateOrderRequestDto;
import com.likelion.likelionshop.dto.response.OrderResponseDto;
import com.likelion.likelionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.likelionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // uri가 /order로 시작하는 요청을 받습니다.
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<List<OrderResponseDto>> createOrder(@AuthenticationPrincipal UserDetails userDetails,  @RequestBody List<CreateOrderRequestDto> orders) {
        List<OrderResponseDto> responseDto = orderService.createOrder(userDetails.getUsername(), orders);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@AuthenticationPrincipal UserDetails userDetails, @PathVariable Long orderId) {
        OrderResponseDto responseDto = orderService.getOrder(userDetails.getUsername(), orderId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrders(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(orderService.getOrders(userDetails.getUsername()));
    }

    @PutMapping("")
    public ResponseEntity<OrderResponseDto> updateOrder(@AuthenticationPrincipal UserDetails userDetails, @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        OrderResponseDto responseDto = orderService.updateOrder(updateOrderRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteOrder(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}