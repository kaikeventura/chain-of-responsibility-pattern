package com.kaikeventura;

public class Wallet {

    private OrderHandler chain;

    public Wallet() {
        buildChain();
    }

    public void makeRequest(Order order) {
        chain.handleRequest(order);
    }

    private void buildChain() {
        chain = new OrderCommander(new WalletCreditCard(new CreditCard(null)));
    }
}
