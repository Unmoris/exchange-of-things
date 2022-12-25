package ru.rsreu.exchangethings.view.beans;

public class NotificationBean {
    private String message;

    public NotificationBean() {
    }

    public NotificationBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
