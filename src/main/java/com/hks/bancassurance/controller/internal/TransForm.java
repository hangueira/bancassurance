package com.hks.bancassurance.controller.internal;

import lombok.Builder;

@Builder
public record TransForm<T>(Head head, Message message, T data) {
}
