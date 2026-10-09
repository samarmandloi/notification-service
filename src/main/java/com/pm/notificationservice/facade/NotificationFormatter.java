package com.pm.notificationservice.facade;

import com.pm.notificationservice.dto.NotificationPayload;

public class NotificationFormatter {

    public String format(
            String template,
            NotificationPayload payload
    ) {

        return template
                + " → "
                + payload.email()
                + " | "
                + payload.message();
    }
}