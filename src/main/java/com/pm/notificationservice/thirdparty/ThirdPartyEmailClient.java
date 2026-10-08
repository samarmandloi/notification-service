package com.pm.notificationservice.thirdparty;

public class ThirdPartyEmailClient {

    public void sendEmail(
            String recipient,
            String recipientName,
            String emailTemplate,
            String emailContent
    ) {

        System.out.println(
                emailTemplate
                        + " EMAIL → "
                        + recipient
                        + " | "
                        + emailContent
        );
    }
}