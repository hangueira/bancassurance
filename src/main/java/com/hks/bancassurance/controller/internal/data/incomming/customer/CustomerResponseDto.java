package com.hks.bancassurance.controller.internal.data.incomming.customer;

import lombok.Builder;

@Builder
public record CustomerResponseDto(
        int hostNo,
        String name,
        int age
) {
}
