package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedStrategy implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.ORDER_CREATED;
    }

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