package com.hks.bancassurance.factory;

import com.google.gson.Gson;
import com.hks.bancassurance.controller.CustomerController;
import com.hks.bancassurance.controller.dto.internal.RequestBankAccountSystemDto;
import com.hks.bancassurance.controller.dto.internal.customer.RequestFindCustomerDto;
import com.hks.bancassurance.controller.dto.internal.customer.ResponseFindCustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

@Component
@RequiredArgsConstructor
public class FindCustomerFactory extends BankAccountSystemFactory<ResponseFindCustomerDto> {

    private final CustomerController customerController;
    private final Gson gson;

    @Override
    public ResponseFindCustomerDto createData(String requestDto) {
        RequestFindCustomerDto requestFindCustomerDto = getFindCustomerDto(requestDto);
        return customerController.findCustomer(requestFindCustomerDto);
    }

    private RequestFindCustomerDto getFindCustomerDto(String request) {
        TypeToken<RequestBankAccountSystemDto<RequestFindCustomerDto>> typeToken = new TypeToken<>() {};
        RequestBankAccountSystemDto<RequestFindCustomerDto> requestDto = gson.fromJson(request, typeToken.getType());
        return RequestFindCustomerDto.builder()
                .hostNo(requestDto.DATA().hostNo())
                .build();
    }


}



