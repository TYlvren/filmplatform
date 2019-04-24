package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import java.io.Serializable;
import java.util.Date;


public class Film implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer uuid;

    private String filmName;

    private Integer filmType;

    private String imgAddress;

    private String filmScore;

    private Integer filmPresalenum;

    private Integer filmBoxOffice;

    private Integer filmSource;

    private String filmCats;

    private Integer filmArea;

    private Integer filmDate;

    private Date filmTime;

    private Integer filmStatus;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Integer getFilmType() {
        return filmType;
    }

    public void setFilmType(Integer filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public Integer getFilmPresalenum() {
        return filmPresalenum;
    }

    public void setFilmPresalenum(Integer filmPresalenum) {
        this.filmPresalenum = filmPresalenum;
    }

    public Integer getFilmBoxOffice() {
        return filmBoxOffice;
    }

    public void setFilmBoxOffice(Integer filmBoxOffice) {
        this.filmBoxOffice = filmBoxOffice;
    }

    public Integer getFilmSource() {
        return filmSource;
    }

    public void setFilmSource(Integer filmSource) {
        this.filmSource = filmSource;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public Integer getFilmArea() {
        return filmArea;
    }

    public void setFilmArea(Integer filmArea) {
        this.filmArea = filmArea;
    }

    public Integer getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(Integer filmDate) {
        this.filmDate = filmDate;
    }

    public Date getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Date filmTime) {
        this.filmTime = filmTime;
    }

    public Integer getFilmStatus() {
        return filmStatus;
    }

    public void setFilmStatus(Integer filmStatus) {
        this.filmStatus = filmStatus;
    }

    @Override
    public String toString() {
        return "Film{" +
        "uuid=" + uuid +
        ", filmName=" + filmName +
        ", filmType=" + filmType +
        ", imgAddress=" + imgAddress +
        ", filmScore=" + filmScore +
        ", filmPresalenum=" + filmPresalenum +
        ", filmBoxOffice=" + filmBoxOffice +
        ", filmSource=" + filmSource +
        ", filmCats=" + filmCats +
        ", filmArea=" + filmArea +
        ", filmDate=" + filmDate +
        ", filmTime=" + filmTime +
        ", filmStatus=" + filmStatus +
        "}";
    }
}
