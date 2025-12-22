package com.example.diabetic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
public class Insulin_Logs {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users userId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insulin_id", nullable = false)
    private Insulin insulinId;

    private Instant takenAt;

    private int unitTaken;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;







}
