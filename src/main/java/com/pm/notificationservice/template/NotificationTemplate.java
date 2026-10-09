package com.pm.notificationservice.template;

import com.pm.notificationservice.dto.NotificationPayload;

public abstract class NotificationTemplate {

    public final void sendEmail(NotificationPayload payload) {
        validatePayload(payload);

        String template = createTemplate();

        System.out.println(
                template + " → "
                        + payload.email() + " | "
                        + payload.message()
        );
    }

    protected abstract String createTemplate();

    private void validatePayload(NotificationPayload payload) {
        if (payload == null) {
            throw new IllegalArgumentException(
                    "Notification payload must not be null"
            );
        }

        if (payload.type() == null) {
            throw new IllegalArgumentException(
                    "Notification type must not be null"
            );
        }

        if (payload.email() == null || payload.email().isBlank()) {
            throw new IllegalArgumentException(
                    "Notification email must not be blank"
            );
        }

        if (payload.message() == null || payload.message().isBlank()) {
            throw new IllegalArgumentException(
                    "Notification message must not be blank"
            );
        }
    }
}
