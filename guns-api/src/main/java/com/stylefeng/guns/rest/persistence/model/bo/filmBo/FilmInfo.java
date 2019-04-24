package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class FilmInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uuid;

    private String filmId;

    private String filmEnName;

    private String filmScore;

    private Integer filmScoreNum;

    private Integer filmLength;

    private String biography;

    private Integer directorId;

    private String filmImgs;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmEnName() {
        return filmEnName;
    }

    public void setFilmEnName(String filmEnName) {
        this.filmEnName = filmEnName;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }

    public Integer getFilmScoreNum() {
        return filmScoreNum;
    }

    public void setFilmScoreNum(Integer filmScoreNum) {
        this.filmScoreNum = filmScoreNum;
    }

    public Integer getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Integer filmLength) {
        this.filmLength = filmLength;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getFilmImgs() {
        return filmImgs;
    }

    public void setFilmImgs(String filmImgs) {
        this.filmImgs = filmImgs;
    }


    @Override
    public String toString() {
        return "FilmInfo{" +
        "uuid=" + uuid +
        ", filmId=" + filmId +
        ", filmEnName=" + filmEnName +
        ", filmScore=" + filmScore +
        ", filmScoreNum=" + filmScoreNum +
        ", filmLength=" + filmLength +
        ", biography=" + biography +
        ", directorId=" + directorId +
        ", filmImgs=" + filmImgs +
        "}";
    }
}
