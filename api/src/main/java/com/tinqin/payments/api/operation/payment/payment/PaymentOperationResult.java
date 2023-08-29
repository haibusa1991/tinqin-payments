package com.tinqin.payments.api.operation.payment.payment;


import com.tinqin.payments.api.base.ProcessorResult;
import lombok.*;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentOperationResult implements ProcessorResult {
    private boolean isSuccessful;
}
