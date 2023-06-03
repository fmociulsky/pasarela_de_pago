package com.pasarelapago.stripe.service;

import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public interface PagoService {

    public String pagarReserva(String monto, String email);
}
