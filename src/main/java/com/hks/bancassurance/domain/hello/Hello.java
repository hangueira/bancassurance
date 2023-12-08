package com.hks.bancassurance.domain.hello;

import com.hks.bancassurance.controller.dto.HelloResponseDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Hello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String author;

    public HelloResponseDto toDto() {
        return HelloResponseDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
