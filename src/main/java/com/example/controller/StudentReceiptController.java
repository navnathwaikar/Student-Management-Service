package com.example.controller;

import com.example.dto.ReceiptDTO;
import com.example.dto.ReceiptGetDetailsDTO;
import com.example.service.StudentReceiptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipt")
public class StudentReceiptController {

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(StudentReceiptController.class);

    @Autowired
    StudentReceiptService studentReceiptService;


    @GetMapping("/{studentId}")
    public ResponseEntity<ReceiptGetDetailsDTO> getReceiptByStudentId(@PathVariable Long studentId){
        logger.info("Student Receipt Details start with id={}", studentId);
        //return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getReceiptByStudentId(studentId));
        ReceiptGetDetailsDTO response = studentReceiptService.getReceiptByStudentId(studentId);
        logger.info(response.toString());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ReceiptGetDetailsDTO> saveReceiptByStudentId(@RequestBody ReceiptDTO receiptDTO){
        logger.info("Student Receipt Save started!!!");
        ResponseEntity<ReceiptGetDetailsDTO> response = studentReceiptService.saveReceipt(receiptDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }
}
