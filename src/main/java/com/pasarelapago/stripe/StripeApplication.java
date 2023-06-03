package com.pasarelapago.stripe;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StripeApplication {

	@PostConstruct
	public void setup(){
		Stripe.apiKey = "sk_test_51NDohNIxorrkFKJxb4OCZROwXjCbcKjVCBPaY8LXkb75KOZmwJeLqSSyHbQHWKKQZfYRBsFgHoxCtDSu1DMrrsZv004FpQvhN7";
	}

	public static void main(String[] args) {
		SpringApplication.run(StripeApplication.class, args);
	}

}
