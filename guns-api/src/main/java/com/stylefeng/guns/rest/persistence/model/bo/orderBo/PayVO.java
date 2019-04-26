package com.stylefeng.guns.rest.persistence.model.bo.orderBo;

import java.io.Serializable;

public class PayVO implements Serializable {
    private static final long serialVersionUID = -6948897955218159033L;

    private String orderId;
    private int orderStatus;
    private String orderMsg;

    public PayVO() {
    }

    public PayVO(String orderId, int orderStatus, String orderMsg) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderMsg = orderMsg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }
}
