package com.stylefeng.guns.rest.persistence.model.bo.cinemabo;

import java.io.Serializable;

public class CinemaFieldBO implements Serializable {
    private static final long serialVersionUID = 7605129606429803257L;

    private int    fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private float price;


    public CinemaFieldBO() {
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
}
