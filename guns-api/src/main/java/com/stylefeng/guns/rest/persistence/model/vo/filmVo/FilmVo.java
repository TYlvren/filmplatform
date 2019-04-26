package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Flying Elephant
 * Date 2019/4/23 0023 Time 20:14
 */
public class FilmVo implements Serializable {
    private int filmNum;
    private int nowPage;
    private int totalPage;
    private List<FilmInfo> filmInfo;

    @Override
    public String toString() {
        return "FilmVo{" +
                "filmNum=" + filmNum +
                ", nowPafe=" + nowPage +
                ", totalPage=" + totalPage +
                ", filmInfo=" + filmInfo +
                '}';
    }

    public int getFilmNum() {
        return filmNum;
    }

    public void setFilmNum(int filmNum) {
        this.filmNum = filmNum;
    }

    public int getNowPafe() {
        return nowPage;
    }

    public void setNowPafe(int nowPafe) {
        this.nowPage = nowPafe;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<FilmInfo> getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(List<FilmInfo> filmInfo) {
        this.filmInfo = filmInfo;
    }
}
