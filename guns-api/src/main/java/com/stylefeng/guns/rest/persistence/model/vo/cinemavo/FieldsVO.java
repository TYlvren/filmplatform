package com.stylefeng.guns.rest.persistence.model.vo.cinemavo;

import com.stylefeng.guns.rest.persistence.model.bo.cinemabo.CinemaInfo;

import java.io.Serializable;
import java.util.List;

public class FieldsVO implements Serializable {
    private static final long serialVersionUID = -5248700241260829904L;

    private CinemaInfo cinemaInfo;
    private List filmList;

    public FieldsVO() {
    }

    public FieldsVO(CinemaInfo cinemaInfo, List filmList) {
        this.cinemaInfo = cinemaInfo;
        this.filmList = filmList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CinemaInfo getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfo cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List getFilmList() {
        return filmList;
    }

    public void setFilmList(List filmList) {
        this.filmList = filmList;
    }
}
