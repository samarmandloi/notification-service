package com.pm.notificationservice.singleton;

public class NotificationManager {

    private static NotificationManager instance;

    private NotificationManager() {
    }

    public static NotificationManager getInstance() {

        if (instance == null) {
            instance = new NotificationManager();
        }

        return instance;
    }

    public void send(String email, String message) {

        System.out.println(
                "NotificationManager → "
                        + email
                        + " | "
                        + message
        );
    }
}