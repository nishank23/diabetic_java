package com.example.diabetic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
public class Insulin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "insulin_id")
    private long insulinId;

    private String insulinType;

    private String insulinName;

    private int dailyFreq;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users userId;

    private Instant insulinTime;

    private int totalUnitsPack;

    private int insulinUnitCost;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

}
