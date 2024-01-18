package com.hks.bancassurance.controller.dto.internal.customer;

import com.hks.bancassurance.domain.customer.Customer;
import lombok.Builder;

@Builder
public record ResponseFindCustomerDto(Long id, int hostNo, String name, int age) {
    public static ResponseFindCustomerDto toDto(Customer customer) {
        return ResponseFindCustomerDto.builder()
                .id(customer.getId())
                .hostNo(customer.getHostNo())
                .name(customer.getName())
                .age(customer.getAge())
                .build();
    }
}
