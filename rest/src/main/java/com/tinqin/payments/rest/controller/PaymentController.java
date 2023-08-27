package com.tinqin.payments.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment")
@RequiredArgsConstructor
public class PaymentController {
//    @SecurityRequirement(name = "Bearer Authentication")
//    @ApiResponse(responseCode = "200", description = "Voucher activated successfully.")
//    @ApiResponse(responseCode = "400", description = "Voucher is used or expired.")
//    @ApiResponse(responseCode = "403", description = "JWT is invalid.")
//    @ApiResponse(responseCode = "404", description = "Voucher code does not exist.")
//    @Operation(description = "Activates a voucher and puts the sum towards user's credit.",
//            summary = "Activates a voucher")
    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello world!", HttpStatus.OK);
    }
}
