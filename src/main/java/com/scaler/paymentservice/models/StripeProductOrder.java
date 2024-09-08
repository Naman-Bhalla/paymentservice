package com.scaler.paymentservice.models;

// import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

// @Entity
@Getter
@Setter
public class StripeProductOrder extends BaseModel {
    private Long productId;
    private String stripePriceId;
    private String stripeProductId;

}
