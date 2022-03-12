package com.kaikeventura.wallet.handler;

import com.kaikeventura.wallet.commanders.CreditCardCommander;
import com.kaikeventura.wallet.commanders.OpenBankingCommander;
import com.kaikeventura.wallet.commanders.WalletCommander;
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
        chain = new WalletCommander(new OpenBankingCommander(new CreditCardCommander(null)));
    }
}
