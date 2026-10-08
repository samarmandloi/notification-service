package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmail(NotificationPayload payload) {

        Notification notification = Notification.builder()
                .email(payload.email())
                .name(payload.name())
                .template(payload.type().name())
                .message(payload.message())
                .build();

        printNotification(notification);
    }

    private void printNotification(Notification notification) {

        System.out.println(
                notification.getTemplate()
                        + " EMAIL → "
                        + notification.getEmail()
                        + " | "
                        + notification.getMessage()
        );
    }
}