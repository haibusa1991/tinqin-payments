package com.tinqin.payments.core.payment;

import com.tinqin.payments.api.operation.payment.payment.PaymentOperation;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationInput;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentProcessor implements PaymentOperation {


    @Override
    public PaymentOperationResult process(PaymentOperationInput input) {
        return null;
    }
}
