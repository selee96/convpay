package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;

public class PayCancelResponse {
    PayCancelResult payCancelResult;
    Integer PayCancledAmount;

    public PayCancelResponse(PayCancelResult payCancelResult, Integer payCancledAmount) {
        this.payCancelResult = payCancelResult;
        PayCancledAmount = payCancledAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayCancledAmount() {
        return PayCancledAmount;
    }

    public void setPayCancledAmount(Integer payCancledAmount) {
        PayCancledAmount = payCancledAmount;
    }

    @Override
    public String toString() {
        return "PayCancelResponse{" +
                "payCancelResult=" + payCancelResult +
                ", PayCancledAmount=" + PayCancledAmount +
                '}';
    }
}
