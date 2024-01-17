package com.hks.bancassurance.factory;

import com.hks.bancassurance.controller.CustomerController;
import com.hks.bancassurance.controller.dto.RequestDto;
import com.hks.bancassurance.controller.dto.customer.RequestFindCustomer;
import com.hks.bancassurance.controller.dto.customer.ResponseFindCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerFactory extends BankAccountInterfaceFactory<RequestFindCustomer, ResponseFindCustomer> {

    private final CustomerController customerController;

    @Override
    public ResponseFindCustomer createData(RequestDto<RequestFindCustomer> requestDto) {

        RequestFindCustomer requestFindCustomer = RequestFindCustomer.builder()
                .hostNo((Integer) requestDto.DATA().get("hostNo"))
                .build();

        return customerController.findCustomer(requestFindCustomer);
    }
}



