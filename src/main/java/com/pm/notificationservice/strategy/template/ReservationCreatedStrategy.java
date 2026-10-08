package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.strategy.NotificationStrategy;

public class ReservationCreatedStrategy implements NotificationStrategy {

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "RESERVATION CREATED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}