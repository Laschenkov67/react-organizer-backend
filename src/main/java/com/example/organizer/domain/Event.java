package com.example.organizer.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String guest;
    private String date;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(updatable = false)
    private LocalDateTime createdDate;

    public Event() {
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}