package com.example.diabetic.model;

import com.example.diabetic.model.enums.BgSource;
import com.example.diabetic.model.enums.BgUnits;
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
    private Instant readingTime;


    @Column(nullable = false)
    private int bgValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BgUnits bgUnit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BgSource bgSource;

    @Column(nullable = false)
    private long sourceId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users userId;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(Instant readingTime) {
        this.readingTime = readingTime;
    }

    public int getBgValue() {
        return bgValue;
    }

    public void setBgValue(int bgValue) {
        this.bgValue = bgValue;
    }

    public BgUnits getBgUnit() {
        return bgUnit;
    }

    public void setBgUnit(BgUnits bgUnit) {
        this.bgUnit = bgUnit;
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

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
