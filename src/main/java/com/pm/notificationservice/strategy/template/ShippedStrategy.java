package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.strategy.NotificationStrategy;

public class ShippedStrategy implements NotificationStrategy {

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "SHIPPED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}