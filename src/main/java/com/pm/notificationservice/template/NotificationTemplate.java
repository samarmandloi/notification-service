package com.pm.notificationservice.template;

import com.pm.notificationservice.dto.NotificationPayload;

public abstract class NotificationTemplate {

    public final void sendEmail(NotificationPayload payload) {

        validate(payload);

        String template = createTemplate();

        String message = createMessage(payload);

        printNotification(
                template,
                payload,
                message
        );
    }

    protected void validate(NotificationPayload payload) {

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
    }

    protected abstract String createTemplate();

    protected String createMessage(NotificationPayload payload) {
        return payload.message();
    }

    protected void printNotification(
            String template,
            NotificationPayload payload,
            String message
    ) {

        System.out.println(
                template
                        + " EMAIL → "
                        + payload.email()
                        + " | "
                        + message
        );
    }
}