package com.trunghc.ui;

import com.trunghc.connect.MySqlConnection;
import com.trunghc.controller.DangNhapController;
import com.trunghc.model.NguoiDung;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DangNhapUI extends JFrame {

    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnDangNhap,btnThoat;

    public DangNhapUI(String title){
        super(title);
        addControlls();
        addEvents();
    }

    private void addControlls() {
        //Layout đăng nhập
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel pnTitle = new JPanel();
        JLabel lblTittle = new JLabel("Đăng nhập hệ thống");
        lblTittle.setForeground(Color.blue);
        Font ft = new Font("segeo ui",Font.BOLD,20);
        lblTittle.setFont(ft);
        pnTitle.add(lblTittle);
        container.add(pnTitle, BorderLayout.NORTH);

        JPanel pnDangNhap = new JPanel();
        pnDangNhap.setLayout(new BoxLayout(pnDangNhap,BoxLayout.Y_AXIS));
        JPanel pnUser = new JPanel();
        JLabel lblUser = new JLabel("Username: ");
        txtUsername = new JTextField(20);
        pnUser.add(lblUser);
        pnUser.add(txtUsername);
        pnDangNhap.add(pnUser);

        JPanel pnPassword = new JPanel();
        JLabel lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField(20);
        pnPassword.add(lblPassword);
        pnPassword.add(txtPassword);

        pnDangNhap.add(pnPassword);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout());
        btnDangNhap = new JButton("Login");
        btnThoat = new JButton("Exit");
        pnButton.add(btnDangNhap);
        pnButton.add(btnThoat);

        pnDangNhap.add(pnButton);

        TitledBorder borderDangNhap = new TitledBorder(BorderFactory.createLineBorder(Color.blue),"Login");
        pnDangNhap.setBorder(borderDangNhap);

        container.add(pnDangNhap,BorderLayout.CENTER);
    }

    private void addEvents() {
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xyLyDangNhap();
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void xyLyDangNhap() {
        //Gọi hàm kiểm tra người dùng
        NguoiDung nguoiDung = DangNhapController.Login(txtUsername.getText(),txtPassword.getPassword());
        if(nguoiDung == null){
            JOptionPane.showMessageDialog(null,"Đăng nhập thất bại"); //Người dùng nhập không chính xác
        }
        else {
            //Gọi hàm hiển thị Giao diện chính nếu đăng nhập thành công
            QuanLyCongVanUI ui = new QuanLyCongVanUI("Quản lý công văn");
            ui.showWindow();
            dispose();
            JOptionPane.showInternalConfirmDialog(null,"Khi thêm mới hoặc sửa công văn, phần tên cơ quan cần phải nhập mã cơ quan!");
        }
    }

    public void showWindow(){
        this.setSize(450,250);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
