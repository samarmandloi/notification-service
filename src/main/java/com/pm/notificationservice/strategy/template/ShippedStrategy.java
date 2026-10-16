package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

@Component
public class ShippedStrategy implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.SHIPPED;
    }

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "SHIPPED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}