package com.zerobase.convpay.controller;

import com.zerobase.convpay.dto.ErrorResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException {
        log.info("Get some order : " + id);

        if ("500".equals(id)) {
            throw new IllegalAccessException("500 is not valid orderId");
        }
        return "orderId:" + id + ", orderAmount:1000";
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler
    public ErrorResponse handelIllegalAccessException(
            IllegalAccessException e) {
        log.error("IllegalAccessException is occurred.", e);

        return new ErrorResponse("INVALID_ACCESS", "IllegalAccessException is occurred.");
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteOrder(@PathVariable("orderId") String id) {
        log.info("Delete some order : " + id);
        return "Delete orderId:" + id;
    }

    @GetMapping("/order")
    public String getOrderWithRequestParam(
            @RequestParam(value = "orderId", required = false, defaultValue = "defaultId") String id,
            @RequestParam("orderAmount") String amount) {
        log.info("Get order : " + id + ", get Amount : " + amount);
        return "orderId:" + id + ", orderAmount:" + amount;
    }

    @PostMapping("/order")
    public String createOrder(
            @RequestBody CreateOrderRequest createOrderRequest,
            @RequestHeader String userAccountId) {
        log.info("orderRequest : " + createOrderRequest + ", userAccountId : " + userAccountId);
        return "orderRequest : " + createOrderRequest;
    }

    @Data
    public static class CreateOrderRequest {
        private String orderId;
        private Integer orderAmount;
    }
}