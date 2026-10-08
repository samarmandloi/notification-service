package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class ShippedTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "SHIPPED";
    }
}