package com.pm.notificationservice.strategy;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.dto.NotificationType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class NotificationStrategyContext {

    private final Map<NotificationType, NotificationStrategy> strategies;

    public NotificationStrategyContext(
            List<NotificationStrategy> strategyList) {

        this.strategies = strategyList.stream()
                .collect(Collectors.toUnmodifiableMap(
                        NotificationStrategy::getType,
                        Function.identity()
                ));
    }

    public void sendEmail(NotificationPayload payload) {

        NotificationStrategy strategy = strategies.get(payload.type());

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "No notification strategy found for type: "
                            + payload.type()
            );
        }

        strategy.sendEmail(payload);
    }
}