
package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class OrderCancelledHandler implements NotificationHandler {

    @Override
    public NotificationType getType() {
        return NotificationType.ORDER_CANCELLED;
    }

    @Override
    public void send(NotificationPayload payload) {
        System.out.println(
                "ORDER CANCELLED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}
