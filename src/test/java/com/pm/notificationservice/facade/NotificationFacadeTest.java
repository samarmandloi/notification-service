package com.pm.notificationservice.facade;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationFacadeTest {

    private final NotificationFacade facade =
            new NotificationFacade();

    @Test
    void shouldProcessValidNotification() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "samar@example.com",
                "Welcome message"
        );

        assertDoesNotThrow(() -> facade.process(payload));
    }

    @Test
    void shouldPrintFormattedNotification() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "samar@example.com",
                "Welcome message"
        );

        String output = captureOutput(() -> facade.process(payload));

        assertTrue(output.contains("samar@example.com"));
        assertTrue(output.contains("Welcome message"));
    }

    @Test
    void shouldRejectNullPayload() {
        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(null)
        );
    }

    @Test
    void shouldRejectEmptyEmail() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "",
                "Welcome message"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(payload)
        );
    }

    @Test
    void shouldRejectBlankEmail() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "   ",
                "Welcome message"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(payload)
        );
    }

    @Test
    void shouldRejectEmptyMessage() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "samar@example.com",
                ""
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(payload)
        );
    }

    @Test
    void shouldRejectBlankMessage() {
        NotificationPayload payload = createPayload(
                NotificationType.WELCOME,
                "samar@example.com",
                "   "
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(payload)
        );
    }

    @Test
    void shouldRejectNullNotificationType() {
        NotificationPayload payload = createPayload(
                null,
                "samar@example.com",
                "Welcome message"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> facade.process(payload)
        );
    }

    private NotificationPayload createPayload(
            NotificationType type,
            String email,
            String message) {

        return new NotificationPayload(
                type,
                email,
                "Samar",
                message
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