
package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class ReservationCancelledHandler implements NotificationHandler {

    @Override
    public NotificationType getType() {
        return NotificationType.RESERVATION_CANCELLED;
    }

    @Override
    public void send(NotificationPayload payload) {
        System.out.println(
                "RESERVATION CANCELLED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}
