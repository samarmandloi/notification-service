package com.pm.notificationservice.proxy;

public class NotificationPrinterProxy implements NotificationPrinter {

    private final NotificationPrinter actualPrinter;

    public NotificationPrinterProxy(NotificationPrinter actualPrinter) {
        this.actualPrinter = actualPrinter;
    }

    @Override
    public void print(
            String email,
            String name,
            String template,
            String message
    ) {

        System.out.println(
                "Proxy → validating notification for " + email
        );

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be empty"
            );
        }

        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException(
                    "Message cannot be empty"
            );
        }

        System.out.println(
                "Proxy → notification validation successful"
        );

        actualPrinter.print(
                email,
                name,
                template,
                message
        );
    }
}