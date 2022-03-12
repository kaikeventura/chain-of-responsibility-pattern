package com.kaikeventura.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentMethod {

    private final Method method;
    private int availableBalance;

    public void withdrawBalance(int value) {
        availableBalance -= value;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "method=" + method +
                ", availableBalance=" + availableBalance +
                '}';
    }
}
