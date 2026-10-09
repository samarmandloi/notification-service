package com.pm.notificationservice.template;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationTemplateTest {

    private final NotificationTemplateContext context =
            new NotificationTemplateContext();

    @Test
    void shouldProcessEveryNotificationType() {
        for (NotificationType type : NotificationType.values()) {
            NotificationPayload payload = createPayload(type);

            assertDoesNotThrow(
                    () -> context.sendEmail(payload),
                    "Failed for notification type: " + type
            );
        }
    }

    @Test
    void shouldIncludeRecipientEmailInOutput() {
        String output = captureOutput(
                () -> context.sendEmail(
                        createPayload(NotificationType.WELCOME)
                )
        );

        assertTrue(output.contains("samar@example.com"));
    }

    @Test
    void shouldIncludeMessageInOutput() {
        String output = captureOutput(
                () -> context.sendEmail(
                        createPayload(NotificationType.ORDER_CREATED)
                )
        );

        assertTrue(output.contains("Test notification message"));
    }

    @Test
    void shouldRejectNullPayload() {
        assertThrows(
                IllegalArgumentException.class,
                () -> context.sendEmail(null)
        );
    }

    @Test
    void shouldRejectBlankEmail() {
        NotificationPayload payload = new NotificationPayload(
                NotificationType.WELCOME,
                " ",
                "Samar",
                "Test notification message"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> context.sendEmail(payload)
        );
    }

    @Test
    void shouldRejectBlankMessage() {
        NotificationPayload payload = new NotificationPayload(
                NotificationType.WELCOME,
                "samar@example.com",
                "Samar",
                " "
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> context.sendEmail(payload)
        );
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
