package com.pm.notificationservice.facade;

import com.pm.notificationservice.dto.NotificationPayload;

public class NotificationValidator {

    public void validate(NotificationPayload payload) {

        if (payload == null) {
            throw new IllegalArgumentException(
                    "Notification payload cannot be null"
            );
        }

        if (payload.email() == null || payload.email().isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be empty"
            );
        }

        if (payload.message() == null || payload.message().isBlank()) {
            throw new IllegalArgumentException(
                    "Message cannot be empty"
            );
        }

        if (payload.type() == null) {
            throw new IllegalArgumentException(
                    "Notification type cannot be null"
            );
        }
    }
}