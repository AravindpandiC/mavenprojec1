package com.example.springlearning.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "allotted_seat", nullable = false)
    private String allottedSeat;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "booked_at", nullable = false)
    private Instant bookedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllottedSeat() {
        return allottedSeat;
    }

    public void setAllottedSeat(String allottedSeat) {
        this.allottedSeat = allottedSeat;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Instant getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(Instant bookedAt) {
        this.bookedAt = bookedAt;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

}