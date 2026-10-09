package com.pm.notificationservice.strategy;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationStrategyContextTest {

    private final NotificationStrategyContext context =
            new NotificationStrategyContext();

    private static final Map<NotificationType, String> EXPECTED_OUTPUTS =
            Map.of(
                    NotificationType.ORDER_CREATED, "ORDER CREATED EMAIL",
                    NotificationType.ORDER_CANCELLED, "ORDER CANCELLED EMAIL",
                    NotificationType.PAYMENT_SUCCESS, "PAYMENT SUCCESS EMAIL",
                    NotificationType.PAYMENT_FAILED, "PAYMENT FAILED EMAIL",
                    NotificationType.PASSWORD_RESET, "PASSWORD RESET EMAIL",
                    NotificationType.WELCOME, "WELCOME EMAIL",
                    NotificationType.SHIPPED, "SHIPPED EMAIL",
                    NotificationType.DELIVERED, "DELIVERED EMAIL",
                    NotificationType.RESERVATION_CREATED, "RESERVATION CREATED EMAIL",
                    NotificationType.RESERVATION_CANCELLED, "RESERVATION CANCELLED EMAIL"
            );

    @Test
    void shouldSendEmailForEveryNotificationType() {
        for (NotificationType type : NotificationType.values()) {
            NotificationPayload payload = createPayload(type);

            assertDoesNotThrow(() -> context.sendEmail(payload));
        }
    }

    @Test
    void shouldUseCorrectStrategyForEveryNotificationType() {
        for (Map.Entry<NotificationType, String> entry
                : EXPECTED_OUTPUTS.entrySet()) {

            NotificationPayload payload = createPayload(entry.getKey());

            String output = captureOutput(
                    () -> context.sendEmail(payload)
            );

            assertTrue(
                    output.contains(entry.getValue()),
                    "Unexpected output for notification type: "
                            + entry.getKey()
                            + ". Actual output: "
                            + output
            );
        }
    }

    @Test
    void shouldIncludeRecipientEmailInOutput() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME
        );

        String output = captureOutput(
                () -> context.sendEmail(payload)
        );

        assertTrue(output.contains("samar@example.com"));
    }

    @Test
    void shouldIncludeMessageInOutput() {
        NotificationPayload payload = createPayload(
                NotificationType.ORDER_CREATED
        );

        String output = captureOutput(
                () -> context.sendEmail(payload)
        );

        assertTrue(output.contains("Test notification message"));
    }

    private NotificationPayload createPayload(NotificationType type) {
        return new NotificationPayload(
                type,
                "samar@example.com",
                "Samar",
                "Test notification message"
        );
    }

    private String captureOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOut = new PrintStream(
                output, true, StandardCharsets.UTF_8)) {

            System.setOut(testOut);
            action.run();

        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8);
    }
}
