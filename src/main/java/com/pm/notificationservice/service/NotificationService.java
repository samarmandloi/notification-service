package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.sender.EmailNotificationAdapter;
import com.pm.notificationservice.sender.NotificationSender;
import com.pm.notificationservice.thirdparty.ThirdPartyEmailClient;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationSender notificationSender;

    public NotificationService() {

        ThirdPartyEmailClient emailClient =
                new ThirdPartyEmailClient();

        this.notificationSender =
                new EmailNotificationAdapter(emailClient);
    }

    public void sendEmail(NotificationPayload payload) {

        notificationSender.send(
                payload.email(),
                payload.name(),
                payload.type().name(),
                payload.message()
        );
    }
}