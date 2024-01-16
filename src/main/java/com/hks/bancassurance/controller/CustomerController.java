package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.CustomerDto;
import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/find")
    public HttpEntity<ResponseWrapper<CustomerDto>> findCustomer(@RequestBody RequestBody1 requestBody) {
        int hostNo = requestBody.data().hostNo();
        Customer findCustomer = customerService.findCustomerByHostNo(hostNo);
        CustomerDto customerDto = CustomerDto.toDto(findCustomer);

        // 데이터를 ResponseWrapper로 래핑
        ResponseWrapper<CustomerDto> responseWrapper = new ResponseWrapper<>(
                new ResponseHeader("banca"),
                new ResponseMessage("nm"),
                customerDto
        );

        // ResponseEntity를 사용하여 헤더, 상태 코드, 본문을 갖는 응답을 생성
        return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
    }

    // 요청을 처리하기 위한 클래스 정의
    private record RequestBody1(RequestData data) {
    }

    private record RequestData(int hostNo) {
    }

    // 간단한 래퍼 클래스
    private record ResponseWrapper<T>(ResponseHeader header, ResponseMessage message, T data) {
    }

    private record ResponseHeader(String systemName) {
    }

    private record ResponseMessage(String returnCode) {
    }
}
