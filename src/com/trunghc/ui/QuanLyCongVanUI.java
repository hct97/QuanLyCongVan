package com.trunghc.ui;

import com.trunghc.controller.CoQuanController;
import com.trunghc.controller.CongVanController;
import com.trunghc.model.CoQuan;
import com.trunghc.model.CongVan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

public class QuanLyCongVanUI extends JFrame {

    DefaultTableModel dtmCongVan;
    JTextField txtId,txtTenCongVan,txtNguoiNhan,txtCoQuan,txtLoaiCongVan,txtNgay;
    JTextArea txtNoiDung;
    JButton btnLuu,btnSua,btnXoa;

    JTable tblCongVan;

    ArrayList<CongVan> dsCongVan = null;


    public QuanLyCongVanUI(String title){
        super(title);
        addControlls();
        addEvents();
        hienThiCongVan();
    }

    //hàm hiển thị toàn bộ công văn ra bảng
    private void hienThiCongVan(){
        CongVanController cv = new CongVanController();
        dsCongVan = CongVanController.layToanBoCongVan();

        dtmCongVan.setRowCount(0);
        for(CongVan congVan:dsCongVan){
            Vector<Object> vector = new Vector<Object>();
            vector.add(congVan.getIdCongVan());
            vector.add(congVan.getIdCoQuan());
            vector.add(congVan.getTenCongVan());
            vector.add(congVan.getNgayNhap());
            dtmCongVan.addRow(vector);
        }
    }
    //Hàm hiển thị chi tiết công văn ra phần bên phải
    private void hienThiChiTietCongVan(CongVan congVan){
        CongVan cv = CongVanController.layChiTietCongVan(congVan.getIdCongVan());
        CoQuan cq = CoQuanController.layChiTietCoQuan(congVan.getIdCoQuan());
        txtId.setText(String.valueOf(cv.getIdCongVan()));
        txtNoiDung.setLineWrap(true);
        txtNoiDung.setWrapStyleWord(true);
        txtNoiDung.setText(cv.getNoiDung());
        txtTenCongVan.setText(cv.getTenCongVan());
        txtNguoiNhan.setText(cv.getNguoiNhan());
        txtCoQuan.setText(cq.getTenCoQuan());
        txtLoaiCongVan.setText(String.valueOf(cv.getLoaiCongVan()));
        txtNgay.setText(cv.getNgayThucHien());
    }


    private void addControlls() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JPanel pnWest = new JPanel();
        JPanel pnCenter = new JPanel();
        JPanel pnSouth = new JPanel();
        container.add(pnWest,BorderLayout.WEST);
        container.add(pnCenter,BorderLayout.CENTER);

        //Tạo bảng hiển thị danh sách công văn
        JPanel pnTable = new JPanel();
        dtmCongVan = new DefaultTableModel();
        dtmCongVan.addColumn("ID");
        dtmCongVan.addColumn("Cơ quan");
        dtmCongVan.addColumn("Tên công văn");
        dtmCongVan.addColumn("Ngày thực hiện");
        tblCongVan = new JTable(dtmCongVan);
        JScrollPane spTable = new JScrollPane(tblCongVan,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnTable.add(spTable);
        pnWest.add(pnTable);

        //Phần hiển thị chi tiết công văn
        JPanel pnChiTiet = new JPanel();
        pnChiTiet.setLayout(new BoxLayout(pnChiTiet,BoxLayout.Y_AXIS));

        JPanel pnId = new JPanel();
        txtId = new JTextField(10);
        pnId.add(txtId);
        pnChiTiet.add(pnId);

        JPanel pnTenCongVan = new JPanel();
        JLabel lblTenCongVan = new JLabel("Tên công văn: ");
        txtTenCongVan = new JTextField(20);
        pnTenCongVan.add(lblTenCongVan);
        pnTenCongVan.add(txtTenCongVan);
        pnChiTiet.add(pnTenCongVan);

        JPanel pnNguoiNhan = new JPanel();
        JLabel lblNguoiNhan = new JLabel("Người nhận: ");
        txtNguoiNhan = new JTextField(20);
        pnNguoiNhan.add(lblNguoiNhan);
        pnNguoiNhan.add(txtNguoiNhan);
        pnChiTiet.add(pnNguoiNhan);

        JPanel pnCoQuan = new JPanel();
        JLabel lblCoQuan = new JLabel("Tên cơ quan: ");
        txtCoQuan = new JTextField(20);
        pnCoQuan.add(lblCoQuan);
        pnCoQuan.add(txtCoQuan);
        pnChiTiet.add(pnCoQuan);

        JPanel pnLoaiCongVan = new JPanel();
        JLabel lblLoaiCongVan = new JLabel("Loại công văn: ");
        txtLoaiCongVan = new JTextField(20);
        pnLoaiCongVan.add(lblLoaiCongVan);
        pnLoaiCongVan.add(txtLoaiCongVan);
        pnChiTiet.add(pnLoaiCongVan);

        JPanel pnNgay = new JPanel();
        JLabel lblNgay = new JLabel("Ngày thực hiện: ");
        txtNgay = new JTextField(20);
        pnNgay.add(lblNgay);
        pnNgay.add(txtNgay);
        pnChiTiet.add(pnNgay);

        JPanel pnNoiDung = new JPanel();
        JLabel lblNoiDung = new JLabel("Nội dung: ");
        txtNoiDung = new JTextArea(5,20);
        JScrollPane scNoiDung = new JScrollPane(txtNoiDung,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnNoiDung.add(lblNoiDung);
        pnNoiDung.add(scNoiDung);
        pnChiTiet.add(pnNoiDung);

        pnCenter.add(pnChiTiet);

        //Các nút chức năng
        JPanel pnThucHien = new JPanel();
        btnLuu = new JButton("Lưu");
        btnSua = new JButton("Sửa");
        btnXoa = new JButton("Xoá");
        pnThucHien.add(btnLuu);
        pnThucHien.add(btnSua);
        pnThucHien.add(btnXoa);
        pnCenter.add(pnThucHien);

        //Căn chỉnh kích thước
        lblTenCongVan.setPreferredSize(lblNgay.getPreferredSize());
        lblNguoiNhan.setPreferredSize(lblNgay.getPreferredSize());
        lblCoQuan.setPreferredSize(lblNgay.getPreferredSize());
        lblLoaiCongVan.setPreferredSize(lblNgay.getPreferredSize());
        lblNoiDung.setPreferredSize(lblNgay.getPreferredSize());

        //Phần thông tin
        container.add(pnSouth,BorderLayout.SOUTH);
        JPanel pnFooter = new JPanel();
        JLabel lblFooter = new JLabel("Desgin By TrungHC");
        Font ft = new Font("seoge ui",Font.BOLD,16);
        lblFooter.setForeground(Color.blue);
        lblFooter.setFont(ft);
        pnFooter.add(lblFooter);
        pnSouth.add(pnFooter);

        //Tạo khung viền
        TitledBorder borderThongTin = new TitledBorder(BorderFactory.createLineBorder(Color.CYAN),"Thông tin công văn");
        pnCenter.setBorder(borderThongTin);

        //Không cho phép chỉnh sửa ID công văn
        txtId.setEditable(false);
    }

    private void addEvents() {
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLyThem();
            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuLySua();
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xyLyXoa();
            }
        });
        //Sự kiện click vào một thành phần trên bảng, hiển thị ra thông tin chi tiết công văn
        tblCongVan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblCongVan.getSelectedRow();
                if(row ==-1)
                    return;
                CongVan congVan = dsCongVan.get(row);
                hienThiChiTietCongVan(congVan);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void xyLyXoa() {
        //Gọi hàm xử lý xoá
        try{
            CongVanController cv = new CongVanController();
            cv.xoaCongVan(Integer.parseInt(txtId.getText()));
            hienThiCongVan();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void xuLySua() {
        //Gọi hàm xử lý Sửa
        try{
            CongVanController cv = new CongVanController();
            cv.suaCongVan(Integer.parseInt(txtLoaiCongVan.getText()),txtNguoiNhan.getText(),txtCoQuan.getText(),txtNgay.getText(),txtNoiDung.getText(),txtTenCongVan.getText(), Integer.parseInt(txtId.getText()));
            hienThiCongVan();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void xuLyThem() {
        //Gọi làm xử lý thêm mới
        try{
            CongVanController cv = new CongVanController();
            cv.themCongVan(Integer.parseInt(txtLoaiCongVan.getText()),txtNguoiNhan.getText(),txtCoQuan.getText(),txtNgay.getText(),txtNoiDung.getText(),txtTenCongVan.getText());
            hienThiCongVan();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void showWindow(){
        this.setSize(900,520);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
