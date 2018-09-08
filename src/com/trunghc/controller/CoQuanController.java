package com.trunghc.controller;

import com.trunghc.connect.MySqlConnection;
import com.trunghc.model.CoQuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CoQuanController {
    //Lấy ra thông tin cơ quan
    public static CoQuan layChiTietCoQuan(String idCoQuan){
        CoQuan cq = null;
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "select * from tblcoquan where id_coquan = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,idCoQuan);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                cq = new CoQuan();
                cq.setIdCoQuan(result.getString(1));
                cq.setTenCoQuan(result.getString(2));
                return cq;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return cq;
    }
}
