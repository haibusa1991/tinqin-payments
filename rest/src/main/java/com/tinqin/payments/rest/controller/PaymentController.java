package com.tinqin.payments.rest.controller;

import com.tinqin.payments.api.operation.payment.payment.PaymentOperation;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationInput;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationResult;
import com.tinqin.restexport.annotation.RestExport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentOperation payment;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment was processed by remote system and payment status is returned."),
    })
    @Operation(description = "Makes charge to the supplied card and returns whether the payment was successful.",
            summary = "Makes charge to the supplied card.")
    @PostMapping
    @RestExport
    public ResponseEntity<PaymentOperationResult> makeCharge(@RequestBody PaymentOperationInput input) {
//        PaymentOperationInput cardInfo = PaymentOperationInput.builder()
//                .cardNumber("4242424242424242")
//                .expiryMonth(8)
//                .expiryYear(2024)
//                .cvc("333")
//                .cartPrice(9.99)
//                .build();

        return new ResponseEntity<>(payment.process(input), HttpStatus.OK);
    }
}
