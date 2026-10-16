
package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class DeliveredHandler implements NotificationHandler {

    @Override
    public NotificationType getType() {
        return NotificationType.DELIVERED;
    }

    @Override
    public void send(NotificationPayload payload) {
        System.out.println(
                "DELIVERED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}
