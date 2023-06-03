package com.pasarelapago.stripe.controller;

import com.pasarelapago.stripe.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Controller
@RequestMapping("/pago")
public class PasarelaController {

    @Autowired
    PagoService pagoService;

    @PostMapping
    public ResponseEntity<String> pagarReserva(@RequestParam String monto){

        System.out.println("Pago de Reserva en PasarelaController");
        final String secretClientKey = pagoService.pagarReserva(monto);

        if(EMPTY.equals(secretClientKey)){
            return new ResponseEntity<String>(EMPTY, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<String>(secretClientKey, HttpStatus.OK);
    }

}
