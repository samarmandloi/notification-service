package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.factory.NotificationFactory;
import com.pm.notificationservice.factory.NotificationHandler;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmail(NotificationPayload payload) {

        NotificationHandler handler =
                NotificationFactory.getHandler(payload.type());

        handler.send(payload);
    }
}