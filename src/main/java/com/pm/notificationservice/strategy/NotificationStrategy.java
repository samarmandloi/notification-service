package com.pm.notificationservice.strategy;

import com.pm.notificationservice.dto.NotificationPayload;

public interface NotificationStrategy {

    void sendEmail(NotificationPayload payload);
}