package com.movedigital.ms.service;

import com.movedigital.ms.dto.InsertRequestDto;
import com.movedigital.ms.dto.OperationResponse;
import com.movedigital.ms.dto.SelectRequestDto;
import com.movedigital.ms.dto.UpdateRequestDto;
import com.movedigital.ms.model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.movedigital.ms.constant.ResultCode.ERROR;
import static com.movedigital.ms.constant.ResultCode.OK;

@Service
public class DbOpsService {

    @Autowired
    Database database;

    public OperationResponse<Integer> insert(InsertRequestDto request) {
        OperationResponse<Integer> operationResponse;
        int id = database.insert(request.getTableName(), request.getValues());
        if (id > 0) {
            operationResponse =
                    new OperationResponse<>(OK, "successfully processed", id);
        } else {
            operationResponse =
                    new OperationResponse<>(ERROR, "processing failed", id);
        }
        return operationResponse;
    }

    public OperationResponse<Void> update(UpdateRequestDto request) {
        OperationResponse<Void> operationResponse;
        try {
            database.update(request.getTableName(), request.getRowId(), request.getValues());
            operationResponse =
                    OperationResponse.<Void>builder()
                            .code(OK)
                            .message("successfully processed")
                            .build();
        } catch (Exception e) {
            operationResponse =
                    OperationResponse.<Void>builder()
                            .code(ERROR)
                            .message(e.getMessage())
                            .build();
        }
        return operationResponse;
    }

    public OperationResponse<List<String>> select(SelectRequestDto request) {
        OperationResponse<List<String>> operationResponse;
        try {
            List<String> values = database.select(request.getTableName(), request.getRowId());
            operationResponse =
                    OperationResponse.<List<String>>builder()
                            .code(OK)
                            .message("successfully processed")
                            .data(values)
                            .build();
        } catch (Exception e) {
            operationResponse =
                    OperationResponse.<List<String>>builder()
                            .code(ERROR)
                            .message(e.getMessage())
                            .build();
        }
        return operationResponse;
    }

}
