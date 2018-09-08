package com.trunghc.controller;

import com.trunghc.connect.MySqlConnection;
import com.trunghc.model.CongVan;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CongVanController {
    //Lây ra thông tin toàn bộ các công văn để đưa vào bảng
    public static ArrayList<CongVan> layToanBoCongVan(){
        ArrayList<CongVan> dsCongVan = new ArrayList<CongVan>();
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "select id_congvan,id_coquan,ten_congvan,ngay_nhap from tblcongvan";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                CongVan cv = new CongVan();
                cv.setIdCongVan(result.getInt(1));
                cv.setIdCoQuan(result.getString(2));
                cv.setTenCongVan(result.getString(3));
                cv.setNgayNhap(result.getString(4));
                dsCongVan.add(cv);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dsCongVan;
    }

    //Lấy chi tiết công văn đưa ra màn hình
    public static CongVan layChiTietCongVan(int idCongVan){
        CongVan cv = null;
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "select id_congvan,ten_congvan,nguoinhan,loai_congvan,ngay_thuchien,noidung from tblcongvan where id_congvan = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(idCongVan));
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                cv = new CongVan();
                cv.setIdCongVan(result.getInt(1));
                cv.setTenCongVan(result.getString(2));
                cv.setNguoiNhan(result.getString(3));
                cv.setLoaiCongVan(Integer.parseInt(result.getString(4)));
                cv.setNgayThucHien(result.getString(5));
                cv.setNoiDung(result.getString(6));
                return cv;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return cv;
    }

    //Thêm mới công văn bằng cơ sở dữ liệu
    //Chú ý Cơ quan truyền vào cần phải là id cơ quan chứ không truyền vào tên cơ quan
    public void themCongVan(int loaiCongVan,String nguoiNhan,String idCoQuan,String ngayThucHien,String noiDung,String tenCongVan){
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "INSERT INTO `tblcongvan` (`id_congvan`, `loai_congvan`, `nguoinhan`, `id_coquan`, `ngay_nhap`, `ngay_thuchien`, `noidung`, `ten_congvan`) VALUES (NULL, ?, ?, ?, CURRENT_TIMESTAMP, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(loaiCongVan));
            preparedStatement.setString(2, String.valueOf(nguoiNhan));
            preparedStatement.setString(3, String.valueOf(idCoQuan));
            preparedStatement.setString(4, String.valueOf(ngayThucHien));
            preparedStatement.setString(5, String.valueOf(noiDung));
            preparedStatement.setString(6, String.valueOf(tenCongVan));
            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //Sửa thông tin công văn bằng cơ sở dữ liệu
    //Chú ý Cơ quan truyền vào cần phải là id cơ quan chứ không truyền vào tên cơ quan
    public void suaCongVan(int loaiCongVan,String nguoiNhan,String idCoQuan ,String ngayThucHien,String noiDung,String tenCongVan, int idCongVan){
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "UPDATE `tblcongvan` set  loai_congvan = ?, nguoinhan = ?, id_coquan = ? , ngay_nhap = CURRENT_TIMESTAMP, ngay_thuchien = ?, noidung = ?, ten_congvan = ? where id_congvan = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(loaiCongVan));
            preparedStatement.setString(2, String.valueOf(nguoiNhan));
            preparedStatement.setString(3, String.valueOf(idCoQuan));
            preparedStatement.setString(4, String.valueOf(ngayThucHien));
            preparedStatement.setString(5, String.valueOf(noiDung));
            preparedStatement.setString(6, String.valueOf(tenCongVan));
            preparedStatement.setString(7, String.valueOf(idCongVan));
            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //Xoá thông tin công văn bằng cơ sở dữ liệu
    public void xoaCongVan(int idCongVan){
        try{
            Connection conn = MySqlConnection.getMySQLConnection();
            String sql = "DELETE from tblcongvan where id_congvan = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(idCongVan));
            int x= preparedStatement.executeUpdate();
            if(x>0){
                JOptionPane.showMessageDialog(null,"Sucsses");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

