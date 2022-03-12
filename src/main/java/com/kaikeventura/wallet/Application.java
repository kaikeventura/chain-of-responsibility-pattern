package com.kaikeventura.wallet;

import com.kaikeventura.wallet.domain.Method;
import com.kaikeventura.wallet.domain.Order;
import com.kaikeventura.wallet.domain.Payer;
import com.kaikeventura.wallet.domain.PaymentMethod;
import com.kaikeventura.wallet.handler.ChainedPayment;
import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class Application {

    public static void main(String[] args) {
        var payerWallet = new PaymentMethod(Method.WALLET, 100000);
        var payerCreditCard = new PaymentMethod(Method.CREDIT_CARD, 0);
        var payerOpenBanking = new PaymentMethod(Method.OPEN_BANKING, 0);
        var payer = new Payer("Kaike Ventura", Arrays.asList(payerWallet, payerOpenBanking, payerCreditCard));

        log.info(String.format("Payer before payment => %s", payer));

        var chainedPayment = new ChainedPayment();
        var order = new Order(payer, 60000);

        chainedPayment.makeRequest(order);

        if (!order.isHandled()) {
            throw new RuntimeException("Error making payment");
        }

        log.info(String.format("Payer after payment => %s", payer));
    }

}
