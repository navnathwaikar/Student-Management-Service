package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDTO {

    private Long referenceId;
    private String cardNumber;
    private String cardType;
    private Date date;
    private double tuitionFee;
    private Long studentId;
}
