package com.kaikeventura;

public class OrderCommander extends OrderHandler {

    public OrderCommander(OrderHandler next) {
        super(next);
    }

    @Override
    public void handleRequest(Order order) {
        var walletPaymentMethod = order.getPayer()
                .getPaymentMethods()
                .stream()
                .filter(paymentMethods -> paymentMethods.getMethod().equals(Method.WALLET))
                .findFirst()
                .get();

        if (order.getValue() <= walletPaymentMethod.getBalance()) {
            order.markHandled();
            System.out.println("Payed with WALLET");
        }
        else {
            super.handleRequest(order);
        }
    }
}
