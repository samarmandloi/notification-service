package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.facade.NotificationFacade;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationFacade notificationFacade;

    public NotificationService() {
        this.notificationFacade = new NotificationFacade();
    }

    public void sendEmail(NotificationPayload payload) {

        notificationFacade.process(payload);
    }
}