package ru.metlin.message_service.registration.model;

import ru.metlin.message_service.registration.RegistrationRequest;

import javax.persistence.Entity;

@Entity
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public User(RegistrationRequest request) {
        this.firstName = request.getFirstName();
        this.lastName = request.getLastName();
        this.email = request.getEmail();
        this.login = request.getLogin();
        this.password = request.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User {" +
                " id -        " + id +
                " firstName - " + firstName +
                " lastName -  " + lastName +
                " email -     " + email +
                " login -     " + login +
                " password -  " + password +
                " }";
    }
}
