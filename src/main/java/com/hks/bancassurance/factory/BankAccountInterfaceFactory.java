package com.hks.bancassurance.factory;

import com.hks.bancassurance.controller.dto.RequestDto;
import com.hks.bancassurance.controller.dto.ResponseDto;
import com.hks.bancassurance.controller.dto.ResponseHeaderDto;
import com.hks.bancassurance.controller.dto.ResponseMessageDto;
import com.hks.bancassurance.controller.dto.customer.ResponseFindCustomer;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class BankAccountInterfaceFactory<T, K> {

    public ResponseDto<K> createResponseForm(RequestDto<T> requestDto) {

        ResponseHeaderDto header = ResponseHeaderDto.builder()
                .systemName("bancassurance")
                .build();
        ResponseMessageDto message = ResponseMessageDto.builder()
                .returnCode("success")
                .build();
        return ResponseDto.<K>builder()
                .HEAD(header)
                .MSG(message)
                .DATA(createData(requestDto))
                .build();
    }

    public abstract K createData(RequestDto<T> requestDto);
}
