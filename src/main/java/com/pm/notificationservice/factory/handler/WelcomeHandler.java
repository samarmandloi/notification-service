
package com.pm.notificationservice.factory.handler;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Component;

@Component
public class WelcomeHandler implements NotificationHandler {

    @Override
    public NotificationType getType() {
        return NotificationType.WELCOME;
    }

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
