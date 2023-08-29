package com.tinqin.payments.api.operation.payment.payment;


import com.tinqin.payments.api.base.ProcessorInput;
import lombok.*;

@Setter(AccessLevel.PRIVATE)
@Getter
@Builder
public class PaymentOperationInput implements ProcessorInput {
    private String cardNumber;
    private Integer expiryMonth;
    private Integer expiryYear;
    private String cvc;
    private Double cartPrice;
}
