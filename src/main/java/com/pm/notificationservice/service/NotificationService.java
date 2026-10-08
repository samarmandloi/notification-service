package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import com.pm.notificationservice.singleton.NotificationManager;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmail(NotificationPayload payload) {

        NotificationManager notificationManager =
                NotificationManager.getInstance();

        String message = switch (payload.type()) {

            case ORDER_CREATED ->
                    "ORDER CREATED EMAIL → " + payload.message();

            case ORDER_CANCELLED ->
                    "ORDER CANCELLED EMAIL → " + payload.message();

            case PAYMENT_SUCCESS ->
                    "PAYMENT SUCCESS EMAIL → " + payload.message();

            case PAYMENT_FAILED ->
                    "PAYMENT FAILED EMAIL → " + payload.message();

            case PASSWORD_RESET ->
                    "PASSWORD RESET EMAIL → " + payload.message();

            case WELCOME ->
                    "WELCOME EMAIL → " + payload.message();

            case SHIPPED ->
                    "SHIPPED EMAIL → " + payload.message();

            case DELIVERED ->
                    "DELIVERED EMAIL → " + payload.message();

            case RESERVATION_CREATED ->
                    "RESERVATION CREATED EMAIL → " + payload.message();

            case RESERVATION_CANCELLED ->
                    "RESERVATION CANCELLED EMAIL → " + payload.message();
        };

        notificationManager.send(payload.email(), message);
    }
}