package com.hks.bancassurance.controller.dto;

import lombok.Builder;

@Builder
public record HelloResponseDto(String title, String content, String author) {
}
