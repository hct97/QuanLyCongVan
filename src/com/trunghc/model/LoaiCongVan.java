package com.trunghc.model;

public class LoaiCongVan {
    int idLoaiCongVan;
    String tenLoaiCongVan;

    public LoaiCongVan(int idLoaiCongVan, String tenLoaiCongVan) {
        this.idLoaiCongVan = idLoaiCongVan;
        this.tenLoaiCongVan = tenLoaiCongVan;
    }

    public int getIdLoaiCongVan() {
        return idLoaiCongVan;
    }

    public void setIdLoaiCongVan(int idLoaiCongVan) {
        this.idLoaiCongVan = idLoaiCongVan;
    }

    public String getTenLoaiCongVan() {
        return tenLoaiCongVan;
    }

    public void setTenLoaiCongVan(String tenLoaiCongVan) {
        this.tenLoaiCongVan = tenLoaiCongVan;
    }
}
