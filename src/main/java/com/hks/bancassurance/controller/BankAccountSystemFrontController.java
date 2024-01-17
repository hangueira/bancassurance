package com.hks.bancassurance.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hks.bancassurance.controller.dto.CustomerDto;
import com.hks.bancassurance.controller.dto.RequestDto;
import com.hks.bancassurance.controller.dto.ResponseDto;
import com.hks.bancassurance.controller.internal.TransForm;
import com.hks.bancassurance.controller.internal.data.incomming.customer.CustomerFactory;
import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.factory.BankAccountInterfaceFactory;
import com.hks.bancassurance.factory.FindCustomerFactory;
import com.hks.bancassurance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive/bank/account")
@RequiredArgsConstructor
public class BankAccountSystemFrontController {


    @PostMapping
    public ResponseDto receiveBankAccount(@RequestBody RequestDto requestBankAccountSystem) {
        return createResponseForm(requestBankAccountSystem);

    }

    private ResponseDto createResponseForm(RequestDto requestDto) {

        String interfaceName = requestDto.HEAD().interfaceName();
        System.out.println("interfaceName = " + interfaceName);
        switch (interfaceName) {
            case "findCustomer":
                return new FindCustomerFactory().createResponseForm(requestDto);
            default:
                return new FindCustomerFactory().createResponseForm(requestDto);
        }

    }
}
