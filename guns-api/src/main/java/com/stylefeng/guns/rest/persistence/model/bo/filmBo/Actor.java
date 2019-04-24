package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import java.io.Serializable;

public class Actor implements Serializable {

    private String directorName;
    private String roleName;
    private String imgAddress;

    @Override
    public String toString() {
        return "Actor{" +
                "directorName='" + directorName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                '}';
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }
}
