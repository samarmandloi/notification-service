package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class OrderCancelledTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "ORDER CANCELLED";
    }
}