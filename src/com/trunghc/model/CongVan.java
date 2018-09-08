package com.trunghc.model;

public class CongVan {
    int idCongVan,loaiCongVan;
    String idCoQuan,nguoiNhan,ngayNhap,ngayThucHien,noiDung,tenCongVan;

    public CongVan() {
    }

    public CongVan(int idCongVan, int loaiCongVan, String idCoQuan, String nguoiNhan, String ngayNhap, String ngayThucHien, String noiDung, String tenCongVan) {
        this.idCongVan = idCongVan;
        this.loaiCongVan = loaiCongVan;
        this.idCoQuan = idCoQuan;
        this.nguoiNhan = nguoiNhan;
        this.ngayNhap = ngayNhap;
        this.ngayThucHien = ngayThucHien;
        this.noiDung = noiDung;
        this.tenCongVan = tenCongVan;
    }

    public int getIdCongVan() {
        return idCongVan;
    }

    public void setIdCongVan(int idCongVan) {
        this.idCongVan = idCongVan;
    }

    public int getLoaiCongVan() {
        return loaiCongVan;
    }

    public void setLoaiCongVan(int loaiCongVan) {
        this.loaiCongVan = loaiCongVan;
    }

    public String getIdCoQuan() {
        return idCoQuan;
    }

    public void setIdCoQuan(String idCoQuan) {
        this.idCoQuan = idCoQuan;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(String ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenCongVan() {
        return tenCongVan;
    }

    public void setTenCongVan(String tenCongVan) {
        this.tenCongVan = tenCongVan;
    }
}
