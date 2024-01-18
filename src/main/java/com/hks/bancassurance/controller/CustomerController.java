package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.internal.customer.RequestFindCustomerDto;
import com.hks.bancassurance.controller.dto.internal.customer.ResponseFindCustomerDto;
import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/find")
    public ResponseFindCustomerDto findCustomer(@RequestBody RequestFindCustomerDto request) {
        int hostNo = request.hostNo();
        Customer findCustomer = customerService.findCustomerByHostNo(hostNo);

        return ResponseFindCustomerDto.toDto(findCustomer);
    }

}
