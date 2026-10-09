package com.pm.notificationservice.proxy;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationPrinterProxyTest {

    @Test
    void shouldDelegateValidNotification() {
        AtomicInteger callCount = new AtomicInteger();
        AtomicReference<String> receivedEmail = new AtomicReference<>();
        AtomicReference<String> receivedName = new AtomicReference<>();
        AtomicReference<String> receivedTemplate = new AtomicReference<>();
        AtomicReference<String> receivedMessage = new AtomicReference<>();

        NotificationPrinter actualPrinter =
                (email, name, template, message) -> {
                    callCount.incrementAndGet();
                    receivedEmail.set(email);
                    receivedName.set(name);
                    receivedTemplate.set(template);
                    receivedMessage.set(message);
                };

        NotificationPrinterProxy proxy =
                new NotificationPrinterProxy(actualPrinter);

        proxy.print(
                "samar@example.com",
                "Samar",
                "WELCOME",
                "Welcome message"
        );

        assertEquals(1, callCount.get());
        assertEquals("samar@example.com", receivedEmail.get());
        assertEquals("Samar", receivedName.get());
        assertEquals("WELCOME", receivedTemplate.get());
        assertEquals("Welcome message", receivedMessage.get());
    }

    @Test
    void shouldRejectBlankEmail() {
        AtomicInteger callCount = new AtomicInteger();

        NotificationPrinter actualPrinter =
                (email, name, template, message) ->
                        callCount.incrementAndGet();

        NotificationPrinterProxy proxy =
                new NotificationPrinterProxy(actualPrinter);

        assertThrows(
                IllegalArgumentException.class,
                () -> proxy.print(
                        " ",
                        "Samar",
                        "WELCOME",
                        "Welcome message"
                )
        );

        assertEquals(0, callCount.get());
    }

    @Test
    void shouldRejectBlankMessage() {
        AtomicInteger callCount = new AtomicInteger();

        NotificationPrinter actualPrinter =
                (email, name, template, message) ->
                        callCount.incrementAndGet();

        NotificationPrinterProxy proxy =
                new NotificationPrinterProxy(actualPrinter);

        assertThrows(
                IllegalArgumentException.class,
                () -> proxy.print(
                        "samar@example.com",
                        "Samar",
                        "WELCOME",
                        " "
                )
        );

        assertEquals(0, callCount.get());
    }

    @Test
    void shouldRejectEmptyEmail() {
        NotificationPrinter actualPrinter =
                (email, name, template, message) -> {
                };

        NotificationPrinterProxy proxy =
                new NotificationPrinterProxy(actualPrinter);

        assertThrows(
                IllegalArgumentException.class,
                () -> proxy.print(
                        "",
                        "Samar",
                        "WELCOME",
                        "Welcome message"
                )
        );
    }

    @Test
    void shouldRejectEmptyMessage() {
        NotificationPrinter actualPrinter =
                (email, name, template, message) -> {
                };

        NotificationPrinterProxy proxy =
                new NotificationPrinterProxy(actualPrinter);

        assertThrows(
                IllegalArgumentException.class,
                () -> proxy.print(
                        "samar@example.com",
                        "Samar",
                        "WELCOME",
                        ""
                )
        );
    }
}
