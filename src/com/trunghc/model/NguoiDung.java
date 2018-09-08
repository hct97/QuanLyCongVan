package com.trunghc.model;

public class NguoiDung {
    int idUser;
    String username,password,hoTen;

    public NguoiDung() {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
}
