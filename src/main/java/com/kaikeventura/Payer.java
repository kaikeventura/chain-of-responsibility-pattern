package com.kaikeventura;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Payer {
    private String name;
    private List<PaymentMethod> paymentMethods;
}
