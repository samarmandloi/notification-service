
package com.pm.notificationservice.sender;

import com.pm.notificationservice.thirdparty.ThirdPartyEmailClient;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailNotificationAdapterTest {

    @Test
    void shouldForwardAllArgumentsToThirdPartyClient() {
        AtomicReference<List<String>> received =
                new AtomicReference<>();

        ThirdPartyEmailClient client = new ThirdPartyEmailClient() {
            @Override
            public void sendEmail(
                    String recipient,
                    String recipientName,
                    String emailTemplate,
                    String emailContent) {

                received.set(List.of(
                        recipient,
                        recipientName,
                        emailTemplate,
                        emailContent
                ));
            }
        };

        EmailNotificationAdapter adapter =
                new EmailNotificationAdapter(client);

        adapter.send(
                "samar@example.com",
                "Samar",
                "WELCOME",
                "Welcome message"
        );

        assertEquals(
                List.of(
                        "samar@example.com",
                        "Samar",
                        "WELCOME",
                        "Welcome message"
                ),
                received.get()
        );
    }

    @Test
    void shouldForwardDifferentNotificationDetails() {
        AtomicReference<List<String>> received =
                new AtomicReference<>();

        ThirdPartyEmailClient client = new ThirdPartyEmailClient() {
            @Override
            public void sendEmail(
                    String recipient,
                    String recipientName,
                    String emailTemplate,
                    String emailContent) {

                received.set(List.of(
                        recipient,
                        recipientName,
                        emailTemplate,
                        emailContent
                ));
            }
        };

        EmailNotificationAdapter adapter =
                new EmailNotificationAdapter(client);

        adapter.send(
                "order@example.com",
                "Customer",
                "ORDER_CREATED",
                "Your order was created"
        );

        assertEquals(
                List.of(
                        "order@example.com",
                        "Customer",
                        "ORDER_CREATED",
                        "Your order was created"
                ),
                received.get()
        );
    }
}