package com.clairem.techtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name= "readings")
public class Readings {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "meterId")
    private int meterId;
    @Column(name = "reading")
    private int reading;
    @Column(name = "date")
    private LocalDate date;


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
