package ru.metlin.message_service.index.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import ru.metlin.message_service.registration.model.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_time", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(value = GenerationTime.ALWAYS)
    private Date dateTime;

    @Column(name = "from_whom")
    private String fromWhom;

    @Column(name = "message")
    private String message;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    public Message() {
    }

    public Message(Long id, Date dateTime, String fromWhom, String message) {
        this.id = id;
        this.dateTime = dateTime;
        this.fromWhom = fromWhom;
        this.message = message;
    }

    public Message(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {

        return dateTime;
    }

    public void setDateTime(Date dateTime) {

        this.dateTime = dateTime;
    }

    public String getFromWhom() {
        return fromWhom;
    }

    public void setFromWhom(String fromWhom) {
        this.fromWhom = fromWhom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", fromWhom='" + fromWhom + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}



