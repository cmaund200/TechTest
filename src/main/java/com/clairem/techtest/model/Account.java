package com.clairem.techtest.model;


import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "accounts")
public class Account {

    @Id
    @Column(name = "accountId")
    private int accountId;
    @Column(name = "id")
    private int id;
    @Column(name = "meterId")
    private int meterId;
    @Column(name = "reading")
    private int reading;
    @Column(name = "date")
    private LocalDate date;

//    private List<GasReading> gasReadings;
//    private List<ElectricReading> electricReadings;


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", id=" + id +
                ", meterId=" + meterId +
                ", reading=" + reading +
                ", date=" + date +
                '}';
    }

    public Account() {
    }

    public Account(int accountId, int id, int meterId, int reading, LocalDate date) {
        this.accountId = accountId;
        this.id = id;
        this.meterId = meterId;
        this.reading = reading;
        this.date = date;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

