package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class YearDict implements Serializable {

   private String yearId;
   private String yearName;
   private boolean isActive;

    @Override
    public String toString() {
        return "YearDict{" +
                "yearId='" + yearId + '\'' +
                ", yearName='" + yearName + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
