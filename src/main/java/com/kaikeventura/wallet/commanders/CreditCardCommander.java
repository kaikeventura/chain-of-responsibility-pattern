package com.kaikeventura.wallet.commanders;

import com.kaikeventura.wallet.domain.Method;
import com.kaikeventura.wallet.domain.Order;
import com.kaikeventura.wallet.handler.OrderHandler;
import lombok.extern.java.Log;

@Log
public class CreditCardCommander extends OrderHandler {

    public CreditCardCommander(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var creditCardPaymentMethod = order.getPayer().getPaymentMethod(Method.CREDIT_CARD);

        if (order.getValue() <= creditCardPaymentMethod.getAvailableBalance()) {
            order.markHandled();
            creditCardPaymentMethod.withdrawBalance(order.getValue());
            log.info("Payed with CREDIT_CARD");
        }
        else {
            super.handleRequest(order);
        }
    }
}
