package com.hks.bancassurance.controller.dto;

import com.hks.bancassurance.domain.customer.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private Long id;

    private int hostNo;

    private String name;

    private int age;

    public static CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .hostNo(customer.getHostNo())
                .name(customer.getName())
                .age(customer.getAge())
                .build();
    }
}
