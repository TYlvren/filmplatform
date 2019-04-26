package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 20:16
 */
public class FilmIndexVo implements Serializable {

    private List<BannerVo> banners;
    private FilmVo hotFilms;
    private FilmVo soonFilms;
    private List<FilmInfo> boxRanking;
    private List<FilmInfo> expectRanking;
    private List<FilmInfo> top100;

    @Override
    public String toString() {
        return "FilmIndexVo{" +
                "banners=" + banners +
                ", hotFilms=" + hotFilms +
                ", soonFilms=" + soonFilms +
                ", boxRanking=" + boxRanking +
                ", expectRanking=" + expectRanking +
                ", top100=" + top100 +
                '}';
    }

    public List<BannerVo> getBanners() {
        return banners;
    }

    public void setBanners(List<BannerVo> banners) {
        this.banners = banners;
    }

    public FilmVo getHotFilms() {
        return hotFilms;
    }

    public void setHotFilms(FilmVo hotFilms) {
        this.hotFilms = hotFilms;
    }

    public FilmVo getSoonFilms() {
        return soonFilms;
    }

    public void setSoonFilms(FilmVo soonFilms) {
        this.soonFilms = soonFilms;
    }

    public List<FilmInfo> getBoxRanking() {
        return boxRanking;
    }

    public void setBoxRanking(List<FilmInfo> boxRanking) {
        this.boxRanking = boxRanking;
    }

    public List<FilmInfo> getExpectRanking() {
        return expectRanking;
    }

    public void setExpectRanking(List<FilmInfo> expectRanking) {
        this.expectRanking = expectRanking;
    }

    public List<FilmInfo> getTop100() {
        return top100;
    }

    public void setTop100(List<FilmInfo> top100) {
        this.top100 = top100;
    }
}
