package com.movedigital.ms.dto;

import com.movedigital.ms.constant.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationResponse<T> {

    private ResultCode code;
    private String message;
    private T data;
}
