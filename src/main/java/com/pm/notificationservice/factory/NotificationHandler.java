package com.pm.notificationservice.factory;

import com.pm.notificationservice.dto.NotificationPayload;

public interface NotificationHandler {

    void send(NotificationPayload payload);
}