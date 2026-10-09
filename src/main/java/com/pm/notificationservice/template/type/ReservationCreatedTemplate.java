package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class ReservationCreatedTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "RESERVATION CREATED";
    }
}