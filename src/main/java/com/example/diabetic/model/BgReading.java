package com.example.diabetic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.Instant;

@Entity()
@Table(name = "BgReading")
public class BgReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, updatable = false)
    private Instant reading_time;


    @Column(nullable = false)
    private int bg_value;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BgUnits bg_unit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BgSource bgSource;

    @Column(nullable = false)
    private long sourceId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user_id;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getReading_time() {
        return reading_time;
    }

    public void setReading_time(Instant reading_time) {
        this.reading_time = reading_time;
    }

    public int getBg_value() {
        return bg_value;
    }

    public void setBg_value(int bg_value) {
        this.bg_value = bg_value;
    }

    public BgUnits getBg_unit() {
        return bg_unit;
    }

    public void setBg_unit(BgUnits bg_unit) {
        this.bg_unit = bg_unit;
    }

    public BgSource getBgSource() {
        return bgSource;
    }

    public void setBgSource(BgSource bgSource) {
        this.bgSource = bgSource;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public Users getUser_id() {
        return user_id;
    }

    public void setUser_id(Users user_id) {
        this.user_id = user_id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
