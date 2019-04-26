package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

import java.io.Serializable;

public class CinemaBO implements Serializable {

    private static final long serialVersionUID = -512069946937585226L;

    private int uuid;
    private String cinemaName;
    private String address;
    private float minimumPrice;

    public CinemaBO() {
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(float minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
}
