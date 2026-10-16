
package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class ReservationCreatedHandler implements NotificationHandler {

    @Override
    public NotificationType getType() {
        return NotificationType.RESERVATION_CREATED;
    }

    @Override
    public void send(NotificationPayload payload) {
        System.out.println(
                "RESERVATION CREATED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}
