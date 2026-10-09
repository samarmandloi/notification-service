package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.strategy.NotificationStrategy;

public class OrderCreatedStrategy implements NotificationStrategy {

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "ORDER CREATED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}