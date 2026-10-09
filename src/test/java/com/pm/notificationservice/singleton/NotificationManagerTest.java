
package com.pm.notificationservice.singleton;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class NotificationManagerTest {

    @Test
    void getInstanceShouldReturnNonNullInstance() {
        NotificationManager manager = NotificationManager.getInstance();

        assertNotNull(manager);
    }

    @Test
    void getInstanceShouldReturnSameInstance() {
        NotificationManager first = NotificationManager.getInstance();
        NotificationManager second = NotificationManager.getInstance();

        assertSame(first, second);
    }

    @Test
    void concurrentCallsShouldReturnSameInstance() throws Exception {
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            List<Callable<NotificationManager>> tasks =
                    java.util.stream.IntStream.range(0, 100)
                            .<Callable<NotificationManager>>mapToObj(
                                    i -> NotificationManager::getInstance)
                            .toList();

            NotificationManager expected =
                    NotificationManager.getInstance();

            for (var future : executor.invokeAll(tasks)) {
                assertSame(expected, future.get());
            }
        }
    }

    @Test
    void sendShouldPrintNotificationDetails() {
        NotificationManager manager = NotificationManager.getInstance();
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream testOut = new PrintStream(
                output, true, StandardCharsets.UTF_8)) {
            System.setOut(testOut);

            manager.send("samar@example.com", "Welcome message");
        } finally {
            System.setOut(originalOut);
        }

        assertEquals(
                "NotificationManager → samar@example.com | Welcome message",
                output.toString(StandardCharsets.UTF_8).trim()
        );
    }
}