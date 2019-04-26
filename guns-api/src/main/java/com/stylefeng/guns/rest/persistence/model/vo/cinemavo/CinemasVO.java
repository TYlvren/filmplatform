package com.stylefeng.guns.rest.persistence.model.vo.cinemavo;

import com.stylefeng.guns.rest.persistence.model.vo.StatusVO;

import java.io.Serializable;

public class CinemasVO extends StatusVO implements Serializable {

    private static final long serialVersionUID = -1153570805905559717L;
    private int nowPage;
    private int totalPage;

    private Object data;


    public CinemasVO() {
    }

    public CinemasVO(int status, int nowPage, int totalPage, Object data) {
        super(status);
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
