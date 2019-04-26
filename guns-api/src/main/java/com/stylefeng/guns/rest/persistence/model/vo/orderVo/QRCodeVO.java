package com.stylefeng.guns.rest.persistence.model.vo.orderVo;

public class QRCodeVO  {
    private String orderId;
    private String QRCodeAddress;

    public QRCodeVO() {
    }

    public QRCodeVO(String orderId, String QRCodeAddress) {
        this.orderId = orderId;
        this.QRCodeAddress = QRCodeAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQRCodeAddress() {
        return QRCodeAddress;
    }

    public void setQRCodeAddress(String QRCodeAddress) {
        this.QRCodeAddress = QRCodeAddress;
    }
}
