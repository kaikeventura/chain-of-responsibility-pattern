package com.kaikeventura.wallet.handler;

import com.kaikeventura.wallet.domain.Method;
import com.kaikeventura.wallet.domain.Order;
import lombok.extern.java.Log;

@Log
public class OpenBanking extends OrderHandler {

    public OpenBanking(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var walletCreditCardPaymentMethod = order.getPayer().getPaymentMethod(Method.OPEN_BANKING);

        if (order.getValue() <= walletCreditCardPaymentMethod.getAvailableBalance()) {
            order.markHandled();
            walletCreditCardPaymentMethod.withdrawBalance(order.getValue());
            log.info("Payed with OPEN_BANKING");
        }
        else {
            super.handleRequest(order);
        }
    }
}
