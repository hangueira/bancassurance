package com.hks.bancassurance.controller.internal.data.incomming.customer;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hks.bancassurance.controller.internal.Head;
import com.hks.bancassurance.controller.internal.TransFormFactory;
import com.hks.bancassurance.domain.customer.Customer;
import com.hks.bancassurance.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerFactory extends TransFormFactory<CustomerResponseDto> {

    private final Gson gson;
    private final CustomerService customerService;

    @Override
    public CustomerResponseDto createData(String requestJsonString) {

        JsonObject jsonObject = (JsonObject) JsonParser.parseString(requestJsonString);
        JsonObject jsonObjectHead = (JsonObject) jsonObject.get("head");
        Head head = gson.fromJson(jsonObjectHead, Head.class);

//        JsonObject jsonObject = gson.fromJson(requestJsonString, JsonObject.class);
        int hostNo = Integer.parseInt(jsonObject.getAsJsonObject("data").get("hostNo").getAsString());

        Customer findCustomer = customerService.findCustomerByHostNo(hostNo);

        return CustomerResponseDto.builder()
                .hostNo(findCustomer.getHostNo())
                .name(findCustomer.getName())
                .age(findCustomer.getAge())
                .build();

    }
}
