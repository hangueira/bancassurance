package com.hks.bancassurance.controller.dto;

import lombok.Builder;

@Builder
public record ResponseDto<T>(ResponseHeaderDto HEAD, ResponseMessageDto MSG, T DATA) {
}
