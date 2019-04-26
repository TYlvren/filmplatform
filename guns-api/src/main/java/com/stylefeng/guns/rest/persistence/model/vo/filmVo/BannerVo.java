package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 20:11
 */
public class BannerVo {
    private String bannerId;
    private String bannerAddress;
    private String bannerUrl;

    @Override
    public String toString() {
        return "BannerVo{" +
                "bannerId='" + bannerId + '\'' +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
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
}
