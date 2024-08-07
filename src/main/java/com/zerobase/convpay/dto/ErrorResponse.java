package com.zerobase.convpay.dto;

import com.zerobase.convpay.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;
}
