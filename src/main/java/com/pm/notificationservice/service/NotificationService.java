package com.pm.notificationservice.service;

import com.pm.notificationservice.dto.NotificationPayload;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendEmail(NotificationPayload payload) {

        switch (payload.type()) {

            case ORDER_CREATED ->
                    System.out.println(
                            "ORDER CREATED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case ORDER_CANCELLED ->
                    System.out.println(
                            "ORDER CANCELLED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case PAYMENT_SUCCESS ->
                    System.out.println(
                            "PAYMENT SUCCESS EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case PAYMENT_FAILED ->
                    System.out.println(
                            "PAYMENT FAILED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case PASSWORD_RESET ->
                    System.out.println(
                            "PASSWORD RESET EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case WELCOME ->
                    System.out.println(
                            "WELCOME EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case SHIPPED ->
                    System.out.println(
                            "SHIPPED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case DELIVERED ->
                    System.out.println(
                            "DELIVERED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case RESERVATION_CREATED ->
                    System.out.println(
                            "RESERVATION CREATED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );

            case RESERVATION_CANCELLED ->
                    System.out.println(
                            "RESERVATION CANCELLED EMAIL → "
                                    + payload.email()
                                    + " | "
                                    + payload.message()
                    );
        }
    }
}