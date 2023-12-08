package com.hks.bancassurance.service;

import com.hks.bancassurance.domain.hello.Hello;
import com.hks.bancassurance.domain.hello.HelloRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HelloService {

    private final HelloRepository helloRepository;

    @Transactional
    public Hello save(Hello hello) {
        return helloRepository.save(hello);

    }

    @Transactional
    public Hello findById(Long id) {
        return helloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user doesn't exist"));
    }
}
