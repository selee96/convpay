package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test
    void getDiscountedAmount() {
        // given
        PayRequest payRequest_G25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequest_GU = new PayRequest(PayMethodType.MONEY, ConvenienceType.GU, 1000);
        PayRequest payRequest_Seven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);

        // when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequest_G25);
        Integer discountedAmountGU = discountByConvenience.getDiscountedAmount(payRequest_GU);
        Integer discountedAmountSeven = discountByConvenience.getDiscountedAmount(payRequest_Seven);

        // then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountGU);
        assertEquals(1000, discountedAmountSeven);
    }
}