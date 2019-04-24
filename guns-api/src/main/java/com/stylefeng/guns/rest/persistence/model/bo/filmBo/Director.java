package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import java.io.Serializable;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 17:03
 */
public class Director implements Serializable {
    private String imgAddress;
    private String directorName;

    public Director(String imgAddress, String directorName) {
        this.imgAddress = imgAddress;
        this.directorName = directorName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "imgAddress='" + imgAddress + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
