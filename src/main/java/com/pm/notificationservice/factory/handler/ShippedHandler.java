package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.factory.NotificationHandler;

public class ShippedHandler implements NotificationHandler {

    @Override
    public void send(NotificationPayload payload) {

        System.out.println(
                "SHIPPED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}