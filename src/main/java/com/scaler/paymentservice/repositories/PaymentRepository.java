package com.scaler.paymentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scaler.paymentservice.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment save(Payment payment);

    Payment findByPaymentGatewayReferenceId(String paymentGatewayReferenceId);
}