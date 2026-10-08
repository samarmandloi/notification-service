package com.pm.notificationservice.facade;

import com.pm.notificationservice.dto.NotificationPayload;

public class NotificationFacade {

    private final NotificationValidator validator;
    private final NotificationTemplateProcessor templateProcessor;
    private final NotificationFormatter formatter;
    private final NotificationPrinter printer;

    public NotificationFacade() {

        this.validator = new NotificationValidator();
        this.templateProcessor = new NotificationTemplateProcessor();
        this.formatter = new NotificationFormatter();
        this.printer = new NotificationPrinter();
    }

    public void process(NotificationPayload payload) {

        validator.validate(payload);

        String template =
                templateProcessor.createTemplate(payload);

        String notification =
                formatter.format(template, payload);

        printer.print(notification);
    }
}