package com.ty.demo.entity;

import javax.validation.constraints.NotEmpty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;

/**
 * @Description:  
 * @Author: tangyan
 * @Version: 1.0
 * @Date: 2021-05-14 16:18:47
 * @Modify
 */
@Data
public class DustYyyx  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private Integer id;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private Integer reportId;

    @ApiModelProperty(value = "去年同期")
    @NotEmpty(message = "不能为空")
    private String specimenDate;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String countCityName;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String townName;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String detectionProject;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String detectionDate;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String dustData;



}
