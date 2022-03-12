package com.kaikeventura;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public abstract class OrderHandler {

    private final OrderHandler next;

    public void handleRequest(Order order) {
        if (next != null) {
            next.handleRequest(order);
        }
    }
}
