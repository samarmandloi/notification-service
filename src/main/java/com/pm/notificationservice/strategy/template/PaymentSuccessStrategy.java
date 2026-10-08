package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.strategy.NotificationStrategy;

public class PaymentSuccessStrategy implements NotificationStrategy {

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "PAYMENT SUCCESS EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}