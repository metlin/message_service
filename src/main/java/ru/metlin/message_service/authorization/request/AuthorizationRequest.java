package ru.metlin.message_service.authorization.request;

public class AuthorizationRequest {

    private String login;
    private String password;

    public AuthorizationRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public AuthorizationRequest() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
