package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class CatDict implements Serializable {

    private String catId;
    private String catName;
    private boolean isActive;

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    @Override
    public String toString() {
        return "CatDict{" +
                "catId='" + catId + '\'' +
                ", catName='" + catName + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
