package com.durgesh.onlydevs.entities;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.bridge.IMessage;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "username")
    @NotNull(message = "username cannot be null")

    String username;
    @Column(name = "password")
    @NotNull(message = "password cannot be null")

    String password;
    @Column(name = "email")
    @NotNull(message = "email cannot be null")

    String email;
    @Column(name = "type")
    @NotNull(message = "type cannot be null")

    String type;


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
