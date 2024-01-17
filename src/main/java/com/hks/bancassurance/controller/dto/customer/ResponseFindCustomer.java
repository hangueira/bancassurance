package com.hks.bancassurance.controller.dto.customer;

import com.hks.bancassurance.domain.customer.Customer;
import lombok.Builder;

@Builder
public record ResponseFindCustomer(Long id, int hostNo, String name, int age) {
    public static ResponseFindCustomer toDto(Customer customer) {
        return ResponseFindCustomer.builder()
                .id(customer.getId())
                .hostNo(customer.getHostNo())
                .name(customer.getName())
                .age(customer.getAge())
                .build();
    }
}
