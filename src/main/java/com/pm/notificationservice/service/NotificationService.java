package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.strategy.NotificationStrategyContext;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationStrategyContext strategyContext;

    public NotificationService() {
        this.strategyContext =
                new NotificationStrategyContext();
    }

    public void sendEmail(NotificationPayload payload) {
        strategyContext.sendEmail(payload);
    }
}