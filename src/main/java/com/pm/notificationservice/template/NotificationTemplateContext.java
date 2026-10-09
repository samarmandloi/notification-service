package com.pm.notificationservice.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.template.type.DeliveredTemplate;
import com.pm.notificationservice.template.type.OrderCancelledTemplate;
import com.pm.notificationservice.template.type.OrderCreatedTemplate;
import com.pm.notificationservice.template.type.PasswordResetTemplate;
import com.pm.notificationservice.template.type.PaymentFailedTemplate;
import com.pm.notificationservice.template.type.PaymentSuccessTemplate;
import com.pm.notificationservice.template.type.ReservationCancelledTemplate;
import com.pm.notificationservice.template.type.ReservationCreatedTemplate;
import com.pm.notificationservice.template.type.ShippedTemplate;
import com.pm.notificationservice.template.type.WelcomeTemplate;

public class NotificationTemplateContext {

    public void sendEmail(NotificationPayload payload) {
        if (payload == null) {
            throw new IllegalArgumentException(
                    "Notification payload must not be null"
            );
        }

        NotificationTemplate template = getTemplate(payload.type());
        template.sendEmail(payload);
    }

    private NotificationTemplate getTemplate(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Notification type must not be null"
            );
        }

        return switch (type) {
            case ORDER_CREATED -> new OrderCreatedTemplate();
            case ORDER_CANCELLED -> new OrderCancelledTemplate();
            case PAYMENT_SUCCESS -> new PaymentSuccessTemplate();
            case PAYMENT_FAILED -> new PaymentFailedTemplate();
            case PASSWORD_RESET -> new PasswordResetTemplate();
            case WELCOME -> new WelcomeTemplate();
            case SHIPPED -> new ShippedTemplate();
            case DELIVERED -> new DeliveredTemplate();
            case RESERVATION_CREATED -> new ReservationCreatedTemplate();
            case RESERVATION_CANCELLED -> new ReservationCancelledTemplate();
        };
    }
}
