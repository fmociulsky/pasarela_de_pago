package com.pasarelapago.stripe.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
public class PagoServiceImpl implements PagoService {

    @Override
    public String pagarReserva(String monto, String email) {

        final PaymentIntentCreateParams paymentIntentCreateParams = PaymentIntentCreateParams.builder()
                .setReceiptEmail(email)
                .setDescription("Intento de pago de " + email)
                .setCurrency("EUR")
                .setAmount(Long.valueOf(monto))
                .build();

        PaymentIntent paymentIntent = null;
        try {
            paymentIntent = PaymentIntent.create(paymentIntentCreateParams);
        } catch (StripeException e) {
            System.out.println("Error: " + e.getMessage());
            return EMPTY;
        }

        return paymentIntent.getClientSecret();
    }
}
