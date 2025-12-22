package com.example.diabetic.model;
import com.example.diabetic.model.enums.UserType;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.Instant;
@EntityListeners(AuditingEntityListener.class)
@EnableJpaAuditing
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;


    @Column(nullable = false)
    private Instant lastLoginAt;


    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String locale;

    @Column(nullable = false)
    private String currency;


    @Enumerated(EnumType.STRING)
    private UserType userType;


}
