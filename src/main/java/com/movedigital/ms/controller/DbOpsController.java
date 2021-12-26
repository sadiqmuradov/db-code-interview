package com.movedigital.ms.controller;

import com.movedigital.ms.constant.URL;
import com.movedigital.ms.dto.InsertRequestDto;
import com.movedigital.ms.dto.OperationResponse;
import com.movedigital.ms.dto.SelectRequestDto;
import com.movedigital.ms.dto.UpdateRequestDto;
import com.movedigital.ms.service.DbOpsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@Validated
@Api("Database Operations API")
public class DbOpsController {

    @Autowired
    private DbOpsService dbOpsService;

    @ApiOperation("Inserting a new row to a table")
    @PostMapping(URL.INSERT)
    public OperationResponse<Integer> insert(@RequestBody @Valid final InsertRequestDto request) {

        log.info("Insert request: {}", request);
        OperationResponse<Integer> response = dbOpsService.insert(request);
        log.info("Insert response: {}", response);
        return response;
    }

    @ApiOperation("Updating a row with new values")
    @PostMapping(URL.UPDATE)
    public OperationResponse<Void> update(@RequestBody @Valid final UpdateRequestDto request) {

        log.info("Update request: {}", request);
        OperationResponse<Void> response = dbOpsService.update(request);
        log.info("Update response: {}", response);
        return response;
    }

    @ApiOperation("Retrieving specified row values")
    @PostMapping(URL.SELECT)
    public OperationResponse<List<String>> select(@RequestBody @Valid final SelectRequestDto request) {

        log.info("Select request: {}", request);
        OperationResponse<List<String>> response = dbOpsService.select(request);
        log.info("Select response: {}", response);
        return response;
    }
}
