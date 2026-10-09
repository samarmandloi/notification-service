package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.factory.NotificationHandler;

public class WelcomeHandler implements NotificationHandler {

    @Override
    public void send(NotificationPayload payload) {

        System.out.println(
                "WELCOME EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}