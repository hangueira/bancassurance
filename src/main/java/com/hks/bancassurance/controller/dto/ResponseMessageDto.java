package com.hks.bancassurance.controller.dto;

import lombok.Builder;

@Builder
public record ResponseMessageDto(String returnCode) {
}
