package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import DAO.ChiTietHoaDon_Dao;
import DAO.HoaDon_Dao;
import DAO.NhanVien_DAO;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewThanhToan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldMaKH;
	private JTextField textFieldTenKH;
	private JTextField textFieldTongTien;
	private JTextField txtHd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String maHD = "HD200303200001";
					KhachHang kh = new KhachHang("KH201923320012", "Lê Bá Hậu", "0385345330", true, "Gò Vấp");
					ArrayList<ChiTietHoaDon> ls = new ArrayList<>();
					ViewThanhToan frame = new ViewThanhToan(maHD, ls, kh, "10000");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewThanhToan(final String maHD, final ArrayList<ChiTietHoaDon> ls_cthd, final KhachHang kh, String tongTien) {		
		final NhanVien_DAO nv = new NhanVien_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 51));
		panel.setBounds(0, 0, 484, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThanhToan = new JLabel("THANH TOÁN HOÁ ĐƠN");
		lblThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhToan.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThanhToan.setBounds(84, 11, 305, 65);
		panel.add(lblThanhToan);
		
		JLabel lblNewLabel = new JLabel("Ngày lập hoá đơn:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(271, 73, 106, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		final Date date = new Date();
		textField.setText(dateFormat.format(date));
		textField.setEditable(false);
		textField.setBackground(UIManager.getColor("SystemColor.menu"));
		textField.setBorder(null);
		textField.setBounds(377, 70, 70, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(0, 111, 484, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaKH.setBounds(75, 70, 136, 17);
		panel_1.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenKH.setBounds(75, 110, 136, 17);
		panel_1.add(lblTenKH);
		
		JLabel lblTongThanhToan = new JLabel("Tổng Thanh Toán:");
		lblTongThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongThanhToan.setBounds(75, 151, 136, 17);
		panel_1.add(lblTongThanhToan);
		
		final JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(187, 204, 65, 35);
		panel_1.add(btnDong);
		
		final JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(262, 204, 100, 35);
		panel_1.add(btnThanhToan);
		
		JButton btnInHoaDon = new JButton("In hoá đơn");
		btnInHoaDon.setBounds(372, 204, 102, 35);
		panel_1.add(btnInHoaDon);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMaKH.setText(kh.getMaKhachHang());
		textFieldMaKH.setEditable(false);
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBorder(null);
		textFieldMaKH.setOpaque(false);
		textFieldMaKH.setBackground(new Color(0, 0, 0, 0));
		textFieldMaKH.setBounds(262, 69, 197, 20);
		panel_1.add(textFieldMaKH);
		textFieldMaKH.setColumns(10);
		
		textFieldTenKH = new JTextField();
		textFieldTenKH.setText(kh.getHoTen());
		textFieldTenKH.setOpaque(false);
		textFieldTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTenKH.setEditable(false);
		textFieldTenKH.setColumns(10);
		textFieldTenKH.setBorder(null);
		textFieldTenKH.setBackground(new Color(0, 0, 0, 0));
		textFieldTenKH.setBounds(262, 109, 212, 20);
		panel_1.add(textFieldTenKH);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setText(tongTien);
		textFieldTongTien.setOpaque(false);
		textFieldTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBorder(null);
		textFieldTongTien.setBackground(new Color(0, 0, 0, 0));
		textFieldTongTien.setBounds(262, 150, 197, 20);
		panel_1.add(textFieldTongTien);
		
		txtHd = new JTextField();
		txtHd.setText(maHD);
		txtHd.setOpaque(false);
		txtHd.setHorizontalAlignment(SwingConstants.CENTER);
		txtHd.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtHd.setEditable(false);
		txtHd.setColumns(10);
		txtHd.setBorder(null);
		txtHd.setBackground(new Color(0, 0, 0, 0));
		txtHd.setBounds(154, 21, 189, 27);
		panel_1.add(txtHd);
		
		// Code xu ly event
		btnDong.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnDong)) {
		    		ViewHoaDon hd = new ViewHoaDon();
		            hd.setLocationRelativeTo(null);
		            hd.setVisible(true);
		    		dispose();
		        }
			}
		});
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnThanhToan)) {
		    		HoaDon_Dao hd_dao = new HoaDon_Dao();
		    		ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Dao();
		    		HoaDon hd = new HoaDon(maHD, date, ABORT, kh, nv.getNhanVienById("NV001"));
		    		hd_dao.addHoaDon(hd);
		    		for (ChiTietHoaDon chiTietHoaDon : ls_cthd) {
						cthd_dao.addChiTietHD(chiTietHoaDon);
					}
		    		JOptionPane.showConfirmDialog(null, "Tạo hoá đơn thành công");
		    		btnThanhToan.setEnabled(false);
		        }
			}
		});
		
		
	}

}
