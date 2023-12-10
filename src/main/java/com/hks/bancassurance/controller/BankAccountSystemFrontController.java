package com.hks.bancassurance.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hks.bancassurance.controller.internal.TransForm;
import com.hks.bancassurance.controller.internal.data.incomming.customer.CustomerFactory;
import com.hks.bancassurance.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive/bank/account")
@RequiredArgsConstructor
public class BankAccountSystemFrontController {

    private final Gson gson;
    private final CustomerService customerService;

    @PostMapping
    public TransForm receive(@RequestBody String requestJsonString) {
        TransForm transForm;
        String ifId = getIfId(requestJsonString);
        return createReponseTransForm(ifId, requestJsonString);
    }

    private TransForm createReponseTransForm(String ifId, String requestJsonString) {
        TransForm transForm;
        switch (ifId) {
            case "customer":
//                transForm = new CustomerFactory().createTransForm(ifId, requestJsonString);
                transForm = new CustomerFactory(gson, customerService).createTransForm(ifId, requestJsonString);
                break;
            case "contract":
//                transForm = new CustomerFactory().createTransForm(ifId);
                transForm = new CustomerFactory(gson, customerService).createTransForm(ifId, requestJsonString);
                break;
            default:
//                transForm = new CustomerFactory().createTransForm(ifId);
                transForm = new CustomerFactory(gson, customerService).createTransForm(ifId, requestJsonString);
                break;
        }

        return transForm;
    }

    /**
     * 한경수
     * interfaceId 값 추출
     * @param requestJsonString
     * @return
     */
    private String getIfId(String requestJsonString) {
        JsonObject jsonObject = gson.fromJson(requestJsonString, JsonObject.class);
        return jsonObject.getAsJsonObject("head").get("if_id").getAsString();
    }
}
