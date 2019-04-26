package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

import java.io.Serializable;

public class ImgPreDataVO extends DataVO implements Serializable {
    private static final long serialVersionUID = 1829385360726731540L;

    private String imgPre;

    public ImgPreDataVO(){}


    public ImgPreDataVO(int status, String imgPre,Object data) {
        super(status, data);
        this.imgPre = imgPre;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }
}
