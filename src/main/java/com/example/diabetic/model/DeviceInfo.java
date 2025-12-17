package com.example.diabetic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity(name = "device_info")
public class DeviceInfo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private long device_id;

    private String app_version;

    private Instant last_synced_at;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user_id;

    //android or ios
    private String device_type;

}
