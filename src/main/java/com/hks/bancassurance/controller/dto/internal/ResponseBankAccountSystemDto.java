package com.hks.bancassurance.controller.dto.internal;

import lombok.Builder;

@Builder
public record ResponseBankAccountSystemDto<T>(ResponseHeaderDto HEAD, ResponseMessageDto MSG, T DATA) {
}
