package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptGetDetailsDTO {

    private Long studentId;
    private String parentName;
    private String studentName;
    private int grade;
    private String mobileNumber;
    private String schoolName;
    private List<ReceiptDTO> receiptDTOList;
}
