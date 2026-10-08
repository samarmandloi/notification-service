package com.pm.notificationservice.template.type;

import com.pm.notificationservice.template.NotificationTemplate;

public class PasswordResetTemplate extends NotificationTemplate {

    @Override
    protected String createTemplate() {
        return "PASSWORD RESET";
    }
}