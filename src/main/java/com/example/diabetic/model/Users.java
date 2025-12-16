package com.example.diabetic.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;

enum UserType {
    ADMIN,
    USER,
}
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password_hash;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant last_logged_in;


    @Column(nullable = false)
    private boolean is_active;

    @Column(nullable = false)
    private String locale;

    @Column(nullable = false)
    private String currency;


    @Enumerated(EnumType.STRING)
    private UserType user_type;


}
