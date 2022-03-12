package com.kaikeventura.wallet.handler;

import com.kaikeventura.wallet.domain.Method;
import com.kaikeventura.wallet.domain.Order;
import lombok.extern.java.Log;

@Log
public class Wallet extends OrderHandler {

    public Wallet(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var walletPaymentMethod = order.getPayer().getPaymentMethod(Method.WALLET);

        if (order.getValue() <= walletPaymentMethod.getAvailableBalance()) {
            order.markHandled();
            walletPaymentMethod.withdrawBalance(order.getValue());
            log.info("Payed with WALLET");
        }
        else {
            super.handleRequest(order);
        }
    }
}
