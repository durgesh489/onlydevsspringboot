package com.durgesh.onlydevs.entities;

import jakarta.persistence.*;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "username")
    @NotNull(message = "username cannot be null")
    @NotBlank(message ="username cannot be null" )
    @NotEmpty(message = "username cannot be null")
    String username;
    @Column(name = "password")
    @NotNull(message = "password cannot be null")
    @NotBlank(message ="password cannot be null" )
    @NotEmpty(message = "password cannot be null")
    String password;
    @Column(name = "email")
    @NotNull(message = "email cannot be null")
    @NotBlank(message ="email cannot be null" )
    @NotEmpty(message = "email cannot be null")
    String email;
    @Column(name = "type")
    @NotNull(message = "type cannot be null")
    @NotBlank(message ="type cannot be null" )
    @NotEmpty(message = "type cannot be null")
    String type;

    public User(){

    }

    public User(int id, String username, String password, String email, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
