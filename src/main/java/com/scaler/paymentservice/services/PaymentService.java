package com.scaler.paymentservice.services;

import org.springframework.stereotype.Service;

import com.scaler.paymentservice.adapters.paymentgatewaysadapters.PaymentGatewayAdapter;
import com.scaler.paymentservice.adapters.paymentgatewaysadapters.PaymentGatewayStrategy;

@Service
public class PaymentService {
    private final PaymentGatewayStrategy paymentGatewayStrategy;

    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }


    public String createPaymentLink(Long orderId) {
        // 1. Get the order details from the order service
        // restTemplate.getForObject("http://orderservice.naman.dev/orders/{orderId}", Order.class, orderId);
        /// price = order.getPrice();
        Long price = 123L;

        // 2. Get a payment gateway based upon a `strategy`
        PaymentGatewayAdapter paymentGatewayAdapter = paymentGatewayStrategy.getPaymentGateway();


        String url = "";

        // 3. Call the payment gateway to create a payment link
        try {
            url = paymentGatewayAdapter.createPaymentLink(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 4. Return the payment link
        return url;
    }
}
