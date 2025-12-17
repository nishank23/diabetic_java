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
    private Users user_id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insulin_id", nullable = false)
    private Insulin insulin_id;

    private Instant taken_at;

    private int unit_taken;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;







}
