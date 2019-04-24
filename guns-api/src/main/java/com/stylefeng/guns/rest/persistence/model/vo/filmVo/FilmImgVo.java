/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: FilmImgVo
 * Author:   john
 * Date:     2019/4/23 22:50
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
 * @create 2019/4/23
 * @since 1.0.0
 */
public class FilmImgVo implements Serializable {
    private String mainImg;
    private String img01;
    private String img02;
    private String img03;
    private String img04;

    @Override
    public String toString() {
        return "FilmImgVo{" +
                "mainImg='" + mainImg + '\'' +
                ", img01='" + img01 + '\'' +
                ", img02='" + img02 + '\'' +
                ", img03='" + img03 + '\'' +
                ", img04='" + img04 + '\'' +
                '}';
    }

    public FilmImgVo() {
    }

    public FilmImgVo(String mainImg, String img01, String img02, String img03, String img04) {
        this.mainImg = mainImg;
        this.img01 = img01;
        this.img02 = img02;
        this.img03 = img03;
        this.img04 = img04;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getImg01() {
        return img01;
    }

    public void setImg01(String img01) {
        this.img01 = img01;
    }

    public String getImg02() {
        return img02;
    }

    public void setImg02(String img02) {
        this.img02 = img02;
    }

    public String getImg03() {
        return img03;
    }

    public void setImg03(String img03) {
        this.img03 = img03;
    }

    public String getImg04() {
        return img04;
    }

    public void setImg04(String img04) {
        this.img04 = img04;
    }
}
