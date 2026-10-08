package com.pm.notificationservice.proxy;

public class ActualNotificationPrinter implements NotificationPrinter {

    @Override
    public void print(
            String email,
            String name,
            String template,
            String message
    ) {

        System.out.println(
                template
                        + " EMAIL → "
                        + email
                        + " | "
                        + message
        );
    }
}