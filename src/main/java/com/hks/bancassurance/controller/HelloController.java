package com.hks.bancassurance.controller;

import com.hks.bancassurance.controller.dto.HelloResponseDto;
import com.hks.bancassurance.controller.dto.HelloSaveRequestDto;
import com.hks.bancassurance.domain.hello.Hello;
import com.hks.bancassurance.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/{id}")
    public HelloResponseDto helloId(@PathVariable("id") Long id) {
        Hello findHello = helloService.findById(id);
        System.out.println("findHello.getTitle() = " + findHello.getTitle());
        return findHello.toDto();
    }

    @PostMapping("/api/v1")
    public Long save(@RequestBody HelloSaveRequestDto requestDto) {
        Hello hello = requestDto.toEntity();
        return helloService.save(hello).getId();
    }

}
