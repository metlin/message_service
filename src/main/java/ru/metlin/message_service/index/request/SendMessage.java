package ru.metlin.message_service.index.request;

import ru.metlin.message_service.index.model.Message;

public class SendMessage {

    private Long id;
    private String fromWhom;
    private String whom;
    private Message message;

    public SendMessage(Long id, String fromWhom, String whom, Message message) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
