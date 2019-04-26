package com.stylefeng.guns.rest.persistence.model.vo.commonvo;

public class PageVO extends DataVO {
    private static final long serialVersionUID = 1295391214446946455L;

    private int nowPage;
    private int totalPage;

    public PageVO(){}


    public PageVO(int nowPage, int totalPage) {
        this.nowPage = nowPage;
        this.totalPage = totalPage;
    }

    public PageVO(int status, Object data, int nowPage, int totalPage) {
        super(status, data);
        this.nowPage = nowPage;
        this.totalPage = totalPage;
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
}
