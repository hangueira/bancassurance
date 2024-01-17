package com.hks.bancassurance.factory;

import com.hks.bancassurance.controller.CustomerController;
import com.hks.bancassurance.controller.dto.customer.RequestFindCustomer;
import com.hks.bancassurance.controller.dto.customer.ResponseFindCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
public class FindCustomerFactory extends BankAccountInterfaceFactory<RequestFindCustomer, ResponseFindCustomer> {

    CustomerController customerController;
    @Override
    public ResponseFindCustomer createData(RequestFindCustomer data) {
        return customerController.findCustomer(data);
    }
}



