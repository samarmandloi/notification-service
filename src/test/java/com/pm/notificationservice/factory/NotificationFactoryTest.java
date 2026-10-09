
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
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationFactoryTest {

    private static final Map<NotificationType, Class<? extends NotificationHandler>>
            EXPECTED_HANDLERS = Map.of(
            NotificationType.ORDER_CREATED, OrderCreatedHandler.class,
            NotificationType.ORDER_CANCELLED, OrderCancelledHandler.class,
            NotificationType.PAYMENT_SUCCESS, PaymentSuccessHandler.class,
            NotificationType.PAYMENT_FAILED, PaymentFailedHandler.class,
            NotificationType.PASSWORD_RESET, PasswordResetHandler.class,
            NotificationType.WELCOME, WelcomeHandler.class,
            NotificationType.SHIPPED, ShippedHandler.class,
            NotificationType.DELIVERED, DeliveredHandler.class,
            NotificationType.RESERVATION_CREATED, ReservationCreatedHandler.class,
            NotificationType.RESERVATION_CANCELLED, ReservationCancelledHandler.class
    );

    @Test
    void shouldRegisterEveryNotificationType() {
        assertEquals(
                NotificationType.values().length,
                EXPECTED_HANDLERS.size()
        );
    }

    @Test
    void shouldReturnCorrectHandlerForEveryNotificationType() {
        for (var entry : EXPECTED_HANDLERS.entrySet()) {
            NotificationHandler handler =
                    NotificationFactory.getHandler(entry.getKey());

            assertNotNull(handler);
            assertInstanceOf(
                    entry.getValue(),
                    handler,
                    "Incorrect handler for " + entry.getKey()
            );
        }
    }

    @Test
    void shouldReturnSameHandlerInstanceForRepeatedCalls() {
        NotificationHandler first =
                NotificationFactory.getHandler(NotificationType.WELCOME);

        NotificationHandler second =
                NotificationFactory.getHandler(NotificationType.WELCOME);

        assertSame(first, second);
    }

    @Test
    void shouldRejectNullNotificationType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NotificationFactory.getHandler(null)
        );
    }
}