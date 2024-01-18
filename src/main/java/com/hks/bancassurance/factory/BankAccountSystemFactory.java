package com.hks.bancassurance.factory;

import com.hks.bancassurance.controller.dto.internal.ResponseBankAccountSystemDto;
import com.hks.bancassurance.controller.dto.internal.ResponseHeaderDto;
import com.hks.bancassurance.controller.dto.internal.ResponseMessageDto;
import org.springframework.stereotype.Component;

@Component
public abstract class BankAccountSystemFactory<T> {

    public ResponseBankAccountSystemDto createResponseForm(String request) {

        ResponseHeaderDto header = ResponseHeaderDto.builder()
                .systemName("bancassurance")
                .build();
        ResponseMessageDto message = ResponseMessageDto.builder()
                .returnCode("success")
                .build();
        return ResponseBankAccountSystemDto.builder()
                .HEAD(header)
                .MSG(message)
                .DATA(createData(request))
                .build();
    }

    public abstract T createData(String requestDto);
}
