package ru.metlin.message_service.index.request;

import ru.metlin.message_service.index.model.Message;

public class SendMessage {

    private String fromWhom;
    private String whom;
    private Message message;

    public SendMessage(String fromWhom, String whom, Message message) {
        this.fromWhom = fromWhom;
        this.whom = whom;
        this.message = message;
    }

    public SendMessage() {
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getWhom() {
        return whom;
    }

    public void setWhom(String whom) {
        this.whom = whom;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
