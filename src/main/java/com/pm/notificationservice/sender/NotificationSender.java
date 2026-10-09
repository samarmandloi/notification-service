package com.pm.notificationservice.sender;

public interface NotificationSender {

    void send(
            String email,
            String name,
            String template,
            String message
    );
}