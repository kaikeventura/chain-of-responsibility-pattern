package com.kaikeventura.wallet.commanders;

import com.kaikeventura.wallet.domain.Method;
import com.kaikeventura.wallet.domain.Order;
import com.kaikeventura.wallet.handler.OrderHandler;
import lombok.extern.java.Log;

@Log
public class WalletCommander extends OrderHandler {

    public WalletCommander(OrderHandler next) {
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
