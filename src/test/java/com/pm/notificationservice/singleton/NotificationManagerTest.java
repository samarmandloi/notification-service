package com.pm.notificationservice.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class NotificationManagerTest {

    @Test
    void shouldReturnSameInstance() {

        NotificationManager first =
                NotificationManager.getInstance();

        NotificationManager second =
                NotificationManager.getInstance();

        assertSame(first, second);
    }
}