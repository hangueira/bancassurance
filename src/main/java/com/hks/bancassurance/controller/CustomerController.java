package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.CustomerDto;
import com.hks.bancassurance.controller.dto.customer.RequestFindCustomer;
import com.hks.bancassurance.controller.dto.customer.ResponseFindCustomer;
import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.service.CustomerService;
import lombok.Builder;
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
    public ResponseFindCustomer findCustomer(@RequestBody RequestFindCustomer request) {
        int hostNo = request.hostNo();
        Customer findCustomer = customerService.findCustomerByHostNo(hostNo);

        return ResponseFindCustomer.toDto(findCustomer);
    }

}
