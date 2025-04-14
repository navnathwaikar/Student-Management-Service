package com.example.service;

import com.example.dto.ReceiptDTO;
import com.example.dto.ReceiptGetDetailsDTO;
import com.example.entity.Student;
import com.example.exception.ServiceNotFound;
import com.example.exception.StudentDataNotFoundException;
import com.example.feignclient.StudentFeeServiceClient;
import com.example.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class StudentReceiptService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentFeeServiceClient client;

    @Autowired
    private StudentService studentService;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(StudentReceiptService.class);


    @CircuitBreaker(name = "feeReceiptServiceCB", fallbackMethod = "getFeeReceiptFallBack")
    public ReceiptGetDetailsDTO getReceiptByStudentId(Long studentId) {

        Student student = studentService.getStudentById(studentId);
        logger.info("Student details found with id ={}", studentId);
        ResponseEntity<List<ReceiptDTO>> response = null;
        if(student != null){
            response = client.getAllReceipts(studentId);
        }
        logger.info("Receipt Details Fetched Successfully!!");
        ReceiptGetDetailsDTO receipt = new ReceiptGetDetailsDTO();
        receipt.setStudentId(student.getStudentId());
        receipt.setStudentName(student.getStudentName());
        receipt.setParentName(student.getParentName());
        receipt.setGrade(student.getGrade());
        receipt.setMobileNumber(student.getMobileNumber());
        receipt.setSchoolName(student.getSchoolName());
        receipt.setReceiptDTOList(response.getBody());
        return receipt;
    }

    public ResponseEntity<ReceiptGetDetailsDTO> saveReceipt(ReceiptDTO receiptDTO) {
        logger.info("Receipt Details saved Successfully!!");
        return client.collectFee(receiptDTO);
    }


  public ReceiptGetDetailsDTO getFeeReceiptFallBack(Long id, Throwable ex){
      logger.info("Fallback method called!!!");
      //return "Service is temporary Down!! Please try later.";
      throw new ServiceNotFound("Service is temporary down!!!");
  }
}
