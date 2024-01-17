package com.hks.bancassurance.controller.dto;


import java.util.Map;

public record RequestDto<T>(RequestHeaderDto HEAD, Map<String, Object> DATA) {
}