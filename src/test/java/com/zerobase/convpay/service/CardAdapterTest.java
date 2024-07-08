package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {

    CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_success() {
        // given
        Integer payAmount = 100;

        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        // then
        assertEquals(cardUseResult, CardUseResult.USE_SUCCESS);
    }

    @Test
    void capture_fail() {
        // given
        Integer payAmount = 101;

        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        // then
        assertEquals(cardUseResult, CardUseResult.USE_FAIL);
    }

    @Test
    void cancelCapture_success() {
        // given
        Integer cancelAmount = 1000;

        // when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

        // then
        assertEquals(cardUseCancelResult, CardUseCancelResult.USE_CANCEL_SUCCESS);
    }

    @Test
    void cancelCapture_fail() {
        // given
        Integer cancelAmount = 999;

        // when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(cancelAmount);

        // then
        assertEquals(cardUseCancelResult, CardUseCancelResult.USE_CANCEL_FAIL);
    }
}