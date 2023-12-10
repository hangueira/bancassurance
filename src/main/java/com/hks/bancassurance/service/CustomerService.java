package com.hks.bancassurance.service;

import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findCustomerByHostNo(int hostNo) {
        return customerRepository.findByHostNo(hostNo);
    }
}
