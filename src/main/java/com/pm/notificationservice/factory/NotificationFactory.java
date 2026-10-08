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

public final class NotificationFactory {

    private NotificationFactory() {
    }

    public static NotificationHandler create(NotificationType type) {

        return switch (type) {

            case ORDER_CREATED ->
                    new OrderCreatedHandler();

            case ORDER_CANCELLED ->
                    new OrderCancelledHandler();

            case PAYMENT_SUCCESS ->
                    new PaymentSuccessHandler();

            case PAYMENT_FAILED ->
                    new PaymentFailedHandler();

            case PASSWORD_RESET ->
                    new PasswordResetHandler();

            case WELCOME ->
                    new WelcomeHandler();

            case SHIPPED ->
                    new ShippedHandler();

            case DELIVERED ->
                    new DeliveredHandler();

            case RESERVATION_CREATED ->
                    new ReservationCreatedHandler();

            case RESERVATION_CANCELLED ->
                    new ReservationCancelledHandler();
        };
    }
}