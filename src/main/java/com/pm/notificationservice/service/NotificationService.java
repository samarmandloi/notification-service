package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.template.NotificationTemplateContext;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationTemplateContext templateContext;

    public NotificationService() {
        this.templateContext =
                new NotificationTemplateContext();
    }

    public void sendEmail(NotificationPayload payload) {
        templateContext.sendEmail(payload);
    }
}