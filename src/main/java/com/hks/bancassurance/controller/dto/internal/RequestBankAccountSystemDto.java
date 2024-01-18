package com.hks.bancassurance.controller.dto.internal;

public record RequestBankAccountSystemDto<T>(RequestHeaderDto HEAD, T DATA) {
}
