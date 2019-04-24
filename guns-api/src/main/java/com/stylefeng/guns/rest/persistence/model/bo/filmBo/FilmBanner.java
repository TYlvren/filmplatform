package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

public class FilmBanner implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer uuid;

    private String bannerAddress;

    private String bannerUrl;

    private Integer isValid;

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "FilmBanner{" +
                "uuid=" + uuid +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", isValid=" + isValid +
                '}';
    }
}
