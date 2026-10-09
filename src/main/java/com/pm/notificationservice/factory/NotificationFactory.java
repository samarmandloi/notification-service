
package com.pm.notificationservice.factory;

import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.factory.handler.DeliveredHandler;
import com.pm.notificationservice.factory.handler.OrderCancelledHandler;
import com.pm.notificationservice.factory.handler.OrderCreatedHandler;
import com.pm.notificationservice.factory.handler.PasswordResetHandler;
import com.pm.notificationservice.factory.handler.PaymentFailedHandler;
import com.pm.notificationservice.factory.handler.PaymentSuccessHandler;
import com.pm.notificationservice.factory.handler.ReservationCancelledHandler;
import com.pm.notificationservice.factory.handler.ReservationCreatedHandler;
import com.pm.notificationservice.factory.handler.ShippedHandler;
import com.pm.notificationservice.factory.handler.WelcomeHandler;

import java.util.Map;

public final class NotificationFactory {

    private static final Map<NotificationType, NotificationHandler> HANDLERS =
            Map.of(
                    NotificationType.ORDER_CREATED, new OrderCreatedHandler(),
                    NotificationType.ORDER_CANCELLED, new OrderCancelledHandler(),
                    NotificationType.PAYMENT_SUCCESS, new PaymentSuccessHandler(),
                    NotificationType.PAYMENT_FAILED, new PaymentFailedHandler(),
                    NotificationType.PASSWORD_RESET, new PasswordResetHandler(),
                    NotificationType.WELCOME, new WelcomeHandler(),
                    NotificationType.SHIPPED, new ShippedHandler(),
                    NotificationType.DELIVERED, new DeliveredHandler(),
                    NotificationType.RESERVATION_CREATED, new ReservationCreatedHandler(),
                    NotificationType.RESERVATION_CANCELLED, new ReservationCancelledHandler()
            );

    private NotificationFactory() {
    }

    public static NotificationHandler getHandler(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Notification type must not be null"
            );
        }

        NotificationHandler handler = HANDLERS.get(type);

        if (handler == null) {
            throw new IllegalArgumentException(
                    "Unsupported notification type: " + type
            );
        }

        return handler;
    }
}