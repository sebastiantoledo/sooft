package com.chalenge.sooft.controller.dto;

import lombok.Data;

@Data
public class TransferDto {
    private String debitAccount;
    private String creditAccount;
    private Double amount;
    private Long companyId;
}
