package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.HelloSaveRequestDto;
import com.hks.bancassurance.domain.hello.Hello;
import com.hks.bancassurance.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloService helloService;

    @Test
    @DisplayName("Hello 전체조회")
    public void callHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @DisplayName("Hello id로 조회")
    public void callHelloId() throws Exception {
        String title = "testA";
        String content = "contentA";
        String author = "authorA";

        Hello hello = Hello.builder()
                .title(title)
                .content(content)
                .author(author)
                .id(1L) // ID 설정
                .build();

        System.out.println("hello.getId() = " + hello.getId());
        System.out.println("hello.getTitle() = " + hello.getTitle());

        // Mock 객체에 대한 행동을 지정
        when(helloService.save(hello)).thenReturn(hello);

        // Mock 객체의 설정을 적용하도록 명시적으로 helloService.save(hello)를 호출
        Hello savedHello = helloService.save(hello);

        when(helloService.findById(savedHello.getId())).thenReturn(savedHello);

        mvc.perform(get("/hello/" + savedHello.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.content").value(content))
                .andExpect(jsonPath("$.author").value(author));
    }
}