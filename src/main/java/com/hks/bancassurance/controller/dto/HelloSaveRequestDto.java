package com.hks.bancassurance.controller.dto;

import com.hks.bancassurance.domain.hello.Hello;
import lombok.Builder;

@Builder
public record HelloSaveRequestDto(String title, String content, String author) {
    public Hello toEntity() {
        return Hello.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}