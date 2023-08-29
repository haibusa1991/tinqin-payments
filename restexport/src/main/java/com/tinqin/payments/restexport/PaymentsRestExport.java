package com.tinqin.payments.restexport;

import com.tinqin.payments.api.operation.payment.payment.PaymentOperationInput;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationResult;
import feign.Headers;
import feign.RequestLine;

@Headers({
    "Content-Type: application/json"
})
public interface PaymentsRestExport {

    @RequestLine("POST /payment")
    PaymentOperationResult makeCharge(PaymentOperationInput input);
}
