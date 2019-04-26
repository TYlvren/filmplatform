package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

import java.io.Serializable;

public class HallInfo implements Serializable {
    private static final long serialVersionUID = 3982449836034999988L;

    private String hallFieldId;
    private String hallName;
    private float price;
    private String seatFile;
    private String soldSeats;


    public String getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(String hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }
}
