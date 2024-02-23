package com.poly.moneylover.models;

public class CaiDatCoBan {
    private int imgCDCB;
    private String nameCDCB;

    public CaiDatCoBan(int imgCDCB, String nameCDCB) {
        this.imgCDCB = imgCDCB;
        this.nameCDCB = nameCDCB;
    }

    public int getImgCDCB() {
        return imgCDCB;
    }

    public void setImgCDCB(int imgCDCB) {
        this.imgCDCB = imgCDCB;
    }

    public String getNameCDCB() {
        return nameCDCB;
    }

    public void setNameCDCB(String nameCDCB) {
        this.nameCDCB = nameCDCB;
    }
}
