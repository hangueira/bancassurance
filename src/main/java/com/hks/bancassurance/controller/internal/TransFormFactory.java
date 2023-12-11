package com.hks.bancassurance.controller.internal;

public abstract class TransFormFactory<T> {

    public TransForm createTransForm(String interfaceId, String requestJsonString) {
        Head head = Head.builder()
                .interfaceId(interfaceId)
                .build();
        Message message = Message.builder()
                .resultCd("NM")
                .build();
        return TransForm.builder()
                .head(head)
                .message(message)
                .data(createData(requestJsonString))
                .build();
    }

    public abstract T createData(String requestJsonString);



}