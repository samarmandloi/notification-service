package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class ReservationCancelledTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "RESERVATION CANCELLED";
    }
}