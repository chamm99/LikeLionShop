package com.likelion.likelionshop.Controller;

import com.likelion.likelionshop.Dto.CreateOrderRequestDto;
import com.likelion.likelionshop.Dto.UpdateOrderRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order") // uri가 http://~/user로 시작하는 요청을 받습니다.
public class OrderController {

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    @PostMapping
    public String createOrder(
            @RequestBody List<CreateOrderRequestDto> requestDtoList) {
        return "주문 생성하기";
    }

    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping
    public String getOrder(
            @RequestBody CreateOrderRequestDto requestDto) {
        return "주문 가져오기";
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    @PutMapping
    public String updateOrder(
            @RequestBody UpdateOrderRequestDto requestDto) {
        return "주문 수정하기";
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping
    public String deleteOrder(
            @RequestBody UpdateOrderRequestDto requestDto) {
        return "주문 삭제하기";
    }

}