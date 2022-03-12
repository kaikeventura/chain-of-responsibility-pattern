package com.kaikeventura;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentMethod {
    private Method method;
    private int balance;
}
