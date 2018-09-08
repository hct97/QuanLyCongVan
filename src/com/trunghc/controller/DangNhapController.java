package com.trunghc.controller;

import com.trunghc.connect.MySqlConnection;
import com.trunghc.model.NguoiDung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DangNhapController {

    //Hàm kiểm tra người dùng, nếu đúng sẽ trả về Arraylist gồm người dùng vừa đăng nhập
    public static NguoiDung Login(String username, char[] password) {
        ArrayList<NguoiDung> dsNguoiDung = new ArrayList<NguoiDung>();
        NguoiDung nguoiDung = null;
        try{
            Connection connection = MySqlConnection.getMySQLConnection();
            String sql = "select * from tblnguoidung where username = ? and password = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2, String.valueOf(password));
            ResultSet result = pre.executeQuery();
            if (result.next()){
                nguoiDung = new NguoiDung();
                nguoiDung.setIdUser(result.getInt("id_user"));
                nguoiDung.setUsername(result.getString("username"));
                nguoiDung.setPassword(result.getString("password"));
                nguoiDung.setHoTen(result.getString("hoten"));
                dsNguoiDung.add(nguoiDung);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return nguoiDung;
    }
}
