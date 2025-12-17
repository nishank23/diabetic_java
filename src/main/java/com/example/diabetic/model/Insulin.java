package com.example.diabetic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
public class Insulin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "insulin_id")
    private long insulin_id;

    private String insulin_type;

    private String insulin_name;

    private int daily_freq;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user_id;

    private Instant insulin_time;

    private int total_units_pack;

    private int insulin_unit_cost;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

}
