package com.ty.demo.entity;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceReqLinesInterfaceEntity  {
    private Long id;

    private Long headerId;

    private Integer lineNumber;

    private String orderNum;

    private Long businessServiceId;

    private String businessServiceName;

    private String taxRateCode;

    private String model;

    private String contractNum;

    private String contractName;

    private String unit;

    private BigDecimal quantity;

    private BigDecimal unitPrice;

    private BigDecimal priceTaxTotal;

    private BigDecimal invoiceAmount;

    private BigDecimal taxAmount;

    private String note;

    private String noteApprove;

//    private String extend1;
//
//    private String extend2;
//
//    private String extend3;
//
//    private String extend4;
//
//    private String extend5;

//    private Long objectVersionNumber;
//
//    private Date creationDate;
//
//    private String createdBy;
//
//    private Date lastModifyDate;
//
//    private String lastModifiedBy;


}