package com.hks.bancassurance.controller.dto.internal;

import lombok.Builder;

@Builder
public record ResponseMessageDto(String returnCode) {
}
