package com.hks.bancassurance.domain.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HelloRepositoryTest {

    @Autowired
    private HelloRepository helloRepository;

    @Test
    public void saveHello() {
        // given
        String title = "테스트게시글";
        String content = "테스트 본문";

        helloRepository.save(Hello.builder()
                .title(title)
                .content(content)
                .author("hks713@naver.com")
                .build());
        // when
        List<Hello> findHelloList = helloRepository.findAll();

        // then
        Hello hello = findHelloList.getFirst();
        assertThat(hello.getTitle()).isEqualTo(title);
        assertThat(hello.getContent()).isEqualTo(content);
    }


}