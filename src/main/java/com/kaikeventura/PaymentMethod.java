package com.kaikeventura;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentMethod {
    private final Method method;
    private final int balance;
}
