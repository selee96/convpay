package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPaymethodTest {
    DiscountByPaymethod discountByPaymethod = new DiscountByPaymethod();

    @Test
    void getDiscountedAmount() {
        // given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY
                , ConvenienceType.G25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD
                , ConvenienceType.G25, 1000);

        // when
        Integer discountedAmountMoney = discountByPaymethod
                .getDiscountedAmount(payRequestMoney);
        Integer discountedAmountCard = discountByPaymethod
                .getDiscountedAmount(payRequestCard);

        // then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }
}