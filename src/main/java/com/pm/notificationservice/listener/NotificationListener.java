package com.pm.notificationservice.listener;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = "notification.queue")
    public void consume(NotificationPayload payload) {

        notificationService.sendEmail(payload);
    }
}