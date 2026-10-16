package com.pm.notificationservice.strategy.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.strategy.NotificationStrategy;
import org.springframework.stereotype.Component;

@Component
public class PaymentFailedStrategy implements NotificationStrategy {

    @Override
    public NotificationType getType() {
        return NotificationType.PAYMENT_FAILED;
    }

    @Override
    public void sendEmail(NotificationPayload payload) {
        System.out.println(
                "PAYMENT FAILED EMAIL → "
                        + payload.email()
                        + " | "
                        + payload.message()
        );
    }
}