package com.kaikeventura;

public class WalletCreditCard extends OrderHandler {

    public WalletCreditCard(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var walletCreditCardPaymentMethod = order.getPayer()
                .getPaymentMethods()
                .stream()
                .filter(paymentMethods -> paymentMethods.getMethod().equals(Method.WALLET_CREDIT_CARD))
                .findFirst()
                .get();

        if (order.getValue() <= walletCreditCardPaymentMethod.getBalance()) {
            System.out.println("Payed with WALLET_CREDIT_CARD");
        }
        else {
            super.handleRequest(order);
        }
    }
}
