package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

@Component
public class ReservationCreatedStrategy implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.RESERVATION_CREATED;
    }

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