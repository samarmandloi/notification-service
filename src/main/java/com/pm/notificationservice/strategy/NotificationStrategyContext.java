package com.pm.notificationservice.strategy;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import com.pm.notificationservice.strategy.template.DeliveredStrategy;
import com.pm.notificationservice.strategy.template.OrderCancelledStrategy;
import com.pm.notificationservice.strategy.template.OrderCreatedStrategy;
import com.pm.notificationservice.strategy.template.PasswordResetStrategy;
import com.pm.notificationservice.strategy.template.PaymentFailedStrategy;
import com.pm.notificationservice.strategy.template.PaymentSuccessStrategy;
import com.pm.notificationservice.strategy.template.ReservationCancelledStrategy;
import com.pm.notificationservice.strategy.template.ReservationCreatedStrategy;
import com.pm.notificationservice.strategy.template.ShippedStrategy;
import com.pm.notificationservice.strategy.template.WelcomeStrategy;

import java.util.Map;

public class NotificationStrategyContext {

    private final Map<NotificationType, NotificationStrategy> strategies;

    public NotificationStrategyContext() {
        strategies = Map.of(
                NotificationType.ORDER_CREATED,
                new OrderCreatedStrategy(),

                NotificationType.ORDER_CANCELLED,
                new OrderCancelledStrategy(),

                NotificationType.PAYMENT_SUCCESS,
                new PaymentSuccessStrategy(),

                NotificationType.PAYMENT_FAILED,
                new PaymentFailedStrategy(),

                NotificationType.PASSWORD_RESET,
                new PasswordResetStrategy(),

                NotificationType.WELCOME,
                new WelcomeStrategy(),

                NotificationType.SHIPPED,
                new ShippedStrategy(),

                NotificationType.DELIVERED,
                new DeliveredStrategy(),

                NotificationType.RESERVATION_CREATED,
                new ReservationCreatedStrategy(),

                NotificationType.RESERVATION_CANCELLED,
                new ReservationCancelledStrategy()
        );
    }

    public void sendEmail(NotificationPayload payload) {

        NotificationStrategy strategy =
                strategies.get(payload.type());

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "No notification strategy found for type: "
                            + payload.type()
            );
        }

        strategy.sendEmail(payload);
    }
}