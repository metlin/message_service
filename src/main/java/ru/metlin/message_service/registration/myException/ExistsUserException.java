package ru.metlin.message_service.registration.myException;

public class ExistsUserException extends RuntimeException {

    public ExistsUserException(String message) {
        super(message);
    }
}
