package com.kaikeventura;

import java.util.Arrays;

public class Run {

    public static void main(String[] args) {
        var walletP = new PaymentMethod(Method.WALLET, 0);
        var walletCreditCardP = new PaymentMethod(Method.WALLET_CREDIT_CARD, 0);
        var creditCardP = new PaymentMethod(Method.CREDIT_CARD, 50000);
        var payer = new Payer("Kaike Ventura", Arrays.asList(walletP, walletCreditCardP, creditCardP));

        var wallet = new Wallet();
        wallet.makeRequest(new Order(payer, 50000));
    }

}