package com.pm.notificationservice.sender;

import com.pm.notificationservice.thirdparty.ThirdPartyEmailClient;

public class EmailNotificationAdapter implements NotificationSender {

    private final ThirdPartyEmailClient emailClient;

    public EmailNotificationAdapter(ThirdPartyEmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void send(
            String email,
            String name,
            String template,
            String message
    ) {

        emailClient.sendEmail(
                email,
                name,
                template,
                message
        );
    }
}