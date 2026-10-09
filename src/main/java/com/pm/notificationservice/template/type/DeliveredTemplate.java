package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class DeliveredTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "DELIVERED";
    }
}