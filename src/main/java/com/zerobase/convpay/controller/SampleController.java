package com.zerobase.convpay.controller;

import com.zerobase.convpay.dto.ErrorResponse;
import com.zerobase.convpay.exception.ErrorCode;
import com.zerobase.convpay.exception.WebSampleException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable("orderId") String id) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        log.info("Get some order : " + id);

        if ("500".equals(id)) {
            throw new WebSampleException(ErrorCode.TOO_BIG_ID_ERROR, "500 is too big orderId.");
        }

        if ("3".equals(id)) {
            throw new WebSampleException(ErrorCode.TOO_SMALL_ID_ERROR, "3 is too small orderId.");
        }

        if ("4".equals(id)) {
            throw new SQLIntegrityConstraintViolationException("Duplicated insertion was tried.");
        }
        return "orderId:" + id + ", orderAmount:1000";
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