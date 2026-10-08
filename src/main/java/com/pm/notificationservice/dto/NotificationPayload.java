package com.pm.notificationservice.dto;

public record NotificationPayload(
        NotificationType type,
        String email,
        String name,
        String message
) {
}