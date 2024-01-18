package com.hks.bancassurance.controller.internal;

import com.google.gson.Gson;
import com.hks.bancassurance.controller.dto.internal.RequestBankAccountSystemDto;
import com.hks.bancassurance.controller.dto.internal.ResponseBankAccountSystemDto;
import com.hks.bancassurance.factory.FindCustomerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive/bank/account")
@RequiredArgsConstructor
public class BankAccountSystemFrontController {

    private final FindCustomerFactory findCustomerFactory;
    private final Gson gson;

    @PostMapping
    public ResponseBankAccountSystemDto receiveBankAccountV2(@RequestBody String requestBankAccountSystem) {
        return createResponseDto(requestBankAccountSystem);
    }

    private ResponseBankAccountSystemDto createResponseDto(String request) {
        String interfaceName = getInterfaceName(request);
        switch (interfaceName) {
            case "findCustomer":
                return findCustomerFactory.createResponseForm(request);
            default:
                throw new UnsupportedOperationException("Unsupported interface: " + interfaceName);
        }
    }

    private String getInterfaceName(String requestDto) {
        return gson.fromJson(requestDto, RequestBankAccountSystemDto.class)
                .HEAD()
                .interfaceName();
    }
}
