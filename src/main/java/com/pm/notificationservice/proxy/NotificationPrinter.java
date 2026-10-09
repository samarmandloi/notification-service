package com.pm.notificationservice.proxy;

public interface NotificationPrinter {

    void print(
            String email,
            String name,
            String template,
            String message
    );
}