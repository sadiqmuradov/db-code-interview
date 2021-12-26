package com.movedigital.ms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@ToString
@ApiModel("Select Request")
public class SelectRequestDto {

    @NotNull
    @ApiModelProperty(value = "Table name", required = true)
    private String tableName;

    @NotNull
    @ApiModelProperty(value = "Row id", required = true)
    private Integer rowId;
}
