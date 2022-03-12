package com.kaikeventura.wallet.handler;

import com.kaikeventura.wallet.domain.Order;

public class ChainedPayment {

    private OrderHandler chain;

    public ChainedPayment() {
        buildChain();
    }

    public void makeRequest(Order order) {
        chain.handleRequest(order);
    }

    private void buildChain() {
        chain = new Wallet(new OpenBanking(new CreditCard(null)));
    }
}
