package com.pm.notificationservice.singleton;

public class NotificationManager {

    private static final NotificationManager INSTANCE =
            new NotificationManager();

    private NotificationManager() {
    }

    public static NotificationManager getInstance() {
        return INSTANCE;
    }

    public void send(String email, String message) {
        System.out.println(
                "NotificationManager → " + email + " | " + message
        );
    }
}