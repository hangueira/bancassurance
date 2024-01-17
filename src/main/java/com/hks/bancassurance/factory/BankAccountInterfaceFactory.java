package com.hks.bancassurance.factory;

import com.hks.bancassurance.controller.dto.RequestDto;
import com.hks.bancassurance.controller.dto.ResponseDto;
import com.hks.bancassurance.controller.dto.ResponseHeaderDto;
import com.hks.bancassurance.controller.dto.ResponseMessageDto;
import com.hks.bancassurance.controller.dto.customer.ResponseFindCustomer;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class BankAccountInterfaceFactory<T, K> {

    public ResponseDto createResponseForm(RequestDto requestDto) {

        ResponseHeaderDto header = ResponseHeaderDto.builder()
                .systemName("bancassurance")
                .build();
        ResponseMessageDto message = ResponseMessageDto.builder()
                .returnCode("success")
                .build();
        ResponseDto<Object> build = ResponseDto.builder()
                .HEAD(header)
                .MSG(message)
                .DATA(createData((T) requestDto.DATA()))
                .build();
        return build;
    }

    public abstract K createData(T data);
}
