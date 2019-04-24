/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SearchFilmVo
 * Author:   john
 * Date:     2019/4/21 23:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.stylefeng.guns.rest.persistence.model.vo.filmVo;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author john
 * @create 2019/4/21
 * @since 1.0.0
 */
public class SearchFilmVo implements Serializable {
    private String filmId;
    private int filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;

    public SearchFilmVo() {
    }

    public SearchFilmVo(String filmId, int filmType, String imgAddress, String filmName, String filmScore) {
        this.filmId = filmId;
        this.filmType = filmType;
        this.imgAddress = imgAddress;
        this.filmName = filmName;
        this.filmScore = filmScore;
    }

    @Override
    public String toString() {
        return "SearchFilmVo{" +
                "filmId='" + filmId + '\'' +
                ", filmType=" + filmType +
                ", imgAddress='" + imgAddress + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmScore='" + filmScore + '\'' +
                '}';
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(String filmScore) {
        this.filmScore = filmScore;
    }
}
