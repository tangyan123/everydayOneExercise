package com.ty.demo.entity;


import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
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

public class DustfallMonitoring  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private Integer id;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private Integer reportId;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String code;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String name;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String countCityName;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String monitoringName;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String monitoringDate;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String dustData;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String countDustData;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String cityAvg;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String monitoringMax;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String monitoringMin;

    @ApiModelProperty(value = "")
    @NotEmpty(message = "不能为空")
    private String description;



}
