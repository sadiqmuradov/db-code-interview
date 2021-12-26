package com.movedigital.ms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
@ApiModel("Insert Request")
public class InsertRequestDto {

    @NotNull
    @ApiModelProperty(value = "Table name", required = true)
    private String tableName;

    @NotNull
    @ApiModelProperty(value = "Row values", required = true)
    private List<String> values;
}
