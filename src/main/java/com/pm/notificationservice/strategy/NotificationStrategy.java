package com.pm.notificationservice.strategy;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;

public interface NotificationStrategy {

    NotificationType getType();

    void sendEmail(NotificationPayload payload);
}