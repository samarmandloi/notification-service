package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class PaymentFailedTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "PAYMENT FAILED";
    }
}