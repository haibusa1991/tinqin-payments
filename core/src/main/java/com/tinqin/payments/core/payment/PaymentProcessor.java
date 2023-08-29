package com.tinqin.payments.core.payment;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperation;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationInput;
import com.tinqin.payments.api.operation.payment.payment.PaymentOperationResult;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentProcessor implements PaymentOperation {

    @Value("${stripe-secret-key}")
    private String SECRET_KEY;

    @Value("${stripe-publishable-key:}")
    private String PUBLISHABLE_KEY;

    @Override
    public PaymentOperationResult process(PaymentOperationInput input) {

        Token cardToken;
        try {
            cardToken = this.getCardToken(input);
        } catch (StripeException e) {
            throw new RuntimeException(e); //TODO
        }


        Integer paymentPrice = Double.valueOf(input.getCartPrice() * 100).intValue();
        boolean isPaymentSuccessful;
        try {
            isPaymentSuccessful = this.isPaymentSuccessful(cardToken, paymentPrice);
        } catch (StripeException e) {
            throw new RuntimeException(e); //TODO
        }

        return PaymentOperationResult.builder()
                .isSuccessful(isPaymentSuccessful)
                .build();
    }

    private Token getCardToken(PaymentOperationInput input) throws StripeException {
        Map<String, Object> cardData = new HashMap<>() {{
            put("number", input.getCardNumber());
            put("exp_month", input.getExpiryMonth());
            put("exp_year", input.getExpiryYear());
            put("cvc", input.getCvc());
        }};

        Map<String, Object> card = new HashMap<>() {{
            put("card", cardData);
        }};

        RequestOptions requestOptions = RequestOptions.builder().setApiKey(PUBLISHABLE_KEY).build();

        return Token.create(card, requestOptions);
    }

    private boolean isPaymentSuccessful(Token cardToken, Integer chargePrice) throws StripeException {
        Map<String, Object> params = new HashMap<>() {{
            put("amount", chargePrice);
            put("currency", "BGN");
            put("source", cardToken.getId());
        }};

        RequestOptions requestOptions = RequestOptions.builder().setApiKey(SECRET_KEY).build();
        return Charge.create(params, requestOptions).getPaid();

    }
}