package com.pm.notificationservice.facade;

import com.pm.notificationservice.dto.NotificationPayload;

public class NotificationTemplateProcessor {

    public String createTemplate(NotificationPayload payload) {

        return switch (payload.type()) {

            case ORDER_CREATED ->
                    "ORDER CREATED EMAIL";

            case ORDER_CANCELLED ->
                    "ORDER CANCELLED EMAIL";

            case PAYMENT_SUCCESS ->
                    "PAYMENT SUCCESS EMAIL";

            case PAYMENT_FAILED ->
                    "PAYMENT FAILED EMAIL";

            case PASSWORD_RESET ->
                    "PASSWORD RESET EMAIL";

            case WELCOME ->
                    "WELCOME EMAIL";

            case SHIPPED ->
                    "SHIPPED EMAIL";

            case DELIVERED ->
                    "DELIVERED EMAIL";

            case RESERVATION_CREATED ->
                    "RESERVATION CREATED EMAIL";

            case RESERVATION_CANCELLED ->
                    "RESERVATION CANCELLED EMAIL";
        };
    }
}