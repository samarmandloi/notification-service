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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class NotificationFactory {

    private static final Map<NotificationType, NotificationHandler> HANDLERS =
            Stream.of(
                    Map.entry(NotificationType.ORDER_CREATED, new OrderCreatedHandler()),
                    Map.entry(NotificationType.ORDER_CANCELLED, new OrderCancelledHandler()),
                    Map.entry(NotificationType.PAYMENT_SUCCESS, new PaymentSuccessHandler()),
                    Map.entry(NotificationType.PAYMENT_FAILED, new PaymentFailedHandler()),
                    Map.entry(NotificationType.PASSWORD_RESET, new PasswordResetHandler()),
                    Map.entry(NotificationType.WELCOME, new WelcomeHandler()),
                    Map.entry(NotificationType.SHIPPED, new ShippedHandler()),
                    Map.entry(NotificationType.DELIVERED, new DeliveredHandler()),
                    Map.entry(NotificationType.RESERVATION_CREATED, new ReservationCreatedHandler()),
                    Map.entry(NotificationType.RESERVATION_CANCELLED, new ReservationCancelledHandler())
            ).collect(
                    Collectors.toUnmodifiableMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    )
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
