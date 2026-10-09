package com.pm.notificationservice.model;

public class Notification {

    private final String email;
    private final String name;
    private final String template;
    private final String message;

    private Notification(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.template = builder.template;
        this.message = builder.message;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getTemplate() {
        return template;
    }

    public String getMessage() {
        return message;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String email;
        private String name;
        private String template;
        private String message;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}