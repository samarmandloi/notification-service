package com.pm.notificationservice.factory;

import com.pm.notificationservice.dto.NotificationType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class NotificationFactory {

    private final Map<NotificationType, NotificationHandler> handlers;

    public NotificationFactory(List<NotificationHandler> handlerList) {
        this.handlers = handlerList.stream()
                .collect(Collectors.toUnmodifiableMap(
                        NotificationHandler::getType,
                        Function.identity()
                ));
    }

    public NotificationHandler getHandler(NotificationType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Notification type must not be null"
            );
        }

        NotificationHandler handler = handlers.get(type);

        if (handler == null) {
            throw new IllegalArgumentException(
                    "Unsupported notification type: " + type
            );
        }

        return handler;
    }
}
