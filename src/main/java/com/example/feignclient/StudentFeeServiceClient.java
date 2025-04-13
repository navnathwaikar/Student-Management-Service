package com.example.feignclient;

import com.example.dto.ReceiptDTO;
import com.example.dto.ReceiptGetDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Student-Fee-Management-Service", url = "http://localhost:9002/fee-collect")
public interface StudentFeeServiceClient {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ReceiptGetDetailsDTO> collectFee(@RequestBody ReceiptDTO feeReceiptEntity);

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public ResponseEntity<List<ReceiptDTO>> getAllReceipts(@PathVariable Long studentId);


}
