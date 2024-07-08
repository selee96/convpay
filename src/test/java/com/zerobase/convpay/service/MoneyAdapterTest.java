package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static com.zerobase.convpay.type.MoneyUseCancelResult.USE_CANCEL_FAIL;
import static com.zerobase.convpay.type.MoneyUseCancelResult.USE_CANCEL_SUCCESS;
import static com.zerobase.convpay.type.MoneyUseResult.USE_FAIL;
import static com.zerobase.convpay.type.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {

    MoneyAdapter moneyAdapter = new MoneyAdapter();

    @Test
    void money_use_fail() {
        // given
        Integer payAmount = 1000_001;

        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(USE_FAIL, moneyUseResult);
    }

    @Test
    void money_use_success() {
        // given
        Integer payAmount = 1000_000;

        // when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        // then
        assertEquals(USE_SUCCESS, moneyUseResult);
    }

    @Test
    void money_use_cancel_fail() {
        // given
        Integer payAmount = 99;

        // when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payAmount);

        // then
        assertEquals(USE_CANCEL_FAIL, moneyUseCancelResult);
    }

    @Test
    void money_use_cancel_success() {
        // given
        Integer payAmount = 100;

        // when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payAmount);

        // then
        assertEquals(USE_CANCEL_SUCCESS, moneyUseCancelResult);
    }
}