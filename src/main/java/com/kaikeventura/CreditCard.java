package com.kaikeventura;

public class CreditCard extends OrderHandler {

    public CreditCard(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var creditCardPaymentMethod = order.getPayer()
                .getPaymentMethods()
                .stream()
                .filter(paymentMethods -> paymentMethods.getMethod().equals(Method.CREDIT_CARD))
                .findFirst()
                .get();

        if (order.getValue() <= creditCardPaymentMethod.getBalance()) {
            order.markHandled();
            System.out.println("Payed with CREDIT_CARD");
        }
        else {
            super.handleRequest(order);
        }
    }
}
