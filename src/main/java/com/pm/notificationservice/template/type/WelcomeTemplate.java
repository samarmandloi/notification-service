package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class WelcomeTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "WELCOME";
    }
}