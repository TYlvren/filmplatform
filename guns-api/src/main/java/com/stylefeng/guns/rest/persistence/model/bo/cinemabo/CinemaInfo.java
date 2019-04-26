package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

import java.io.Serializable;

public class CinemaInfo implements Serializable {
    private static final long serialVersionUID = 1808285000201703381L;


    private int cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAdress;
    private String cinemaPhone;

    public CinemaInfo() {
    }

    public CinemaInfo(int cinemaId, String imgUrl, String cinemaName, String cinemaAdress, String cinemaPhone) {
        this.cinemaId = cinemaId;
        this.imgUrl = imgUrl;
        this.cinemaName = cinemaName;
        this.cinemaAdress = cinemaAdress;
        this.cinemaPhone = cinemaPhone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAdress() {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress) {
        this.cinemaAdress = cinemaAdress;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }
}
