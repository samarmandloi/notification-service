
package com.pm.notificationservice.factory;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;

public interface NotificationHandler {

    NotificationType getType();

    void send(NotificationPayload payload);
}
