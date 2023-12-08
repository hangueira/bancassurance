package com.hks.bancassurance.controller.dto;

import com.hks.bancassurance.controller.dto.HelloResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    @DisplayName("helloResponseDto 테스트")
    public void helloDtoTest() {

        String title = "testA";
        String content = "contentA";
        String author = "authorA";


        HelloResponseDto helloResponseDto = HelloResponseDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        assertThat(helloResponseDto.title()).isEqualTo(title);
        assertThat(helloResponseDto.content()).isEqualTo(content);
        assertThat(helloResponseDto.author()).isEqualTo(author);
    }

}