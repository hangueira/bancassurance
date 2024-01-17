package com.hks.bancassurance.controller.dto;


public record RequestDto<T>(RequestHeaderDto HEAD, T DATA) {
}