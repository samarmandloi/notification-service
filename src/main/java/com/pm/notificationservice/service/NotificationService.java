package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.proxy.ActualNotificationPrinter;
import com.pm.notificationservice.proxy.NotificationPrinter;
import com.pm.notificationservice.proxy.NotificationPrinterProxy;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationPrinter notificationPrinter;

    public NotificationService() {

        NotificationPrinter actualPrinter =
                new ActualNotificationPrinter();

        this.notificationPrinter =
                new NotificationPrinterProxy(actualPrinter);
    }

    public void sendEmail(NotificationPayload payload) {

        notificationPrinter.print(
                payload.email(),
                payload.name(),
                payload.type().name(),
                payload.message()
        );
    }
}