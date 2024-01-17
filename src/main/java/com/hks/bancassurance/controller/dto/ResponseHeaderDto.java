package com.hks.bancassurance.controller.dto;

import lombok.Builder;

@Builder
public record ResponseHeaderDto(String systemName) {
}


/*
{
    "header": {
        "systemName": "banca"
    },
    "message": {
        "returnCode": "nm"
    },
    "data": {
        "id": 1,
        "hostNo": 1,
        "name": "Alice",
        "age": 30
    }
}

 */