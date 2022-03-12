package com.kaikeventura.wallet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Payer {

    private String name;
    private List<PaymentMethod> paymentMethods;

    public PaymentMethod getPaymentMethod(Method method) {
        return this.paymentMethods.stream()
                .filter(paymentMethods -> paymentMethods.getMethod().equals(method))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return "Payer{" +
                "name='" + name + '\'' +
                ", paymentMethods=" + paymentMethods +
                '}';
    }
}
