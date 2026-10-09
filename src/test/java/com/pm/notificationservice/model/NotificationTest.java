package com.pm.notificationservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

class NotificationTest {

    @Test
    void builderShouldSetAllFields() {
        Notification notification = Notification.builder()
                .email("samar@example.com")
                .name("Samar")
                .template("WELCOME")
                .message("Welcome message")
                .build();

        assertEquals("samar@example.com", notification.getEmail());
        assertEquals("Samar", notification.getName());
        assertEquals("WELCOME", notification.getTemplate());
        assertEquals("Welcome message", notification.getMessage());
    }

    @Test
    void builderShouldCreateIndependentNotifications() {
        Notification first = Notification.builder()
                .email("first@example.com")
                .message("First message")
                .build();

        Notification second = Notification.builder()
                .email("second@example.com")
                .message("Second message")
                .build();

        assertNotSame(first, second);
        assertEquals("first@example.com", first.getEmail());
        assertEquals("second@example.com", second.getEmail());
    }

    @Test
    void optionalFieldsShouldBeNullWhenNotProvided() {
        Notification notification = Notification.builder().build();

        assertNull(notification.getName());
        assertNull(notification.getTemplate());
    }
}