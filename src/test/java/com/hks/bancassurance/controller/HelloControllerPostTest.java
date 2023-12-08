package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.HelloSaveRequestDto;
import com.hks.bancassurance.domain.hello.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerPostTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private HelloRepository helloRepository;

    @BeforeEach
    public void clear() throws Exception {
        helloRepository.deleteAll();
    }

    @Test
    public void saveHello() {
        // given
        String title = "title";
        String content = "content";
        String author = "author";

        HelloSaveRequestDto requestDto = HelloSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String uri = "http://localhost:" + port + "/hello/api/v1";
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(uri, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}