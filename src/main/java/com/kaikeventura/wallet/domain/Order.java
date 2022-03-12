package com.kaikeventura.wallet.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Order {

    private final Payer payer;
    private final int value;
    private boolean handled;

    public Order(final Payer payer, final int value) {
        this.payer = Objects.requireNonNull(payer);
        this.value = value;
    }

    public void markHandled() {
        this.handled = true;
    }

    public boolean isHandled() {
        return this.handled;
    }
}
