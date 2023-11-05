package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewThemKhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaKH;
	private JTextField textFieldTenKH;
	private JTextField textFieldTongTien;
	private JTextField textFieldSDT;
	private JTextField txtMaKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewThemKhachHang frame = new ViewThemKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewThemKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(0, 0, 484, 361);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenKH.setBounds(75, 59, 136, 17);
		panel_1.add(lblTenKH);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgaySinh.setBounds(75, 104, 136, 17);
		panel_1.add(lblNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGioiTinh.setBounds(75, 160, 136, 17);
		panel_1.add(lblGioiTinh);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSDT.setBounds(75, 207, 136, 17);
		panel_1.add(lblSDT);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(75, 278, 100, 35);
		panel_1.add(btnThem);
		
		JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(301, 278, 102, 35);
		panel_1.add(btnDong);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMaKH.setText("Lê Bá Hậu");
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(262, 58, 156, 20);
		panel_1.add(textFieldMaKH);
		
        JXDatePicker picker = new JXDatePicker();
        picker.getEditor().setFont(new Font("Tahoma", Font.BOLD, 14));
        Calendar date = Calendar.getInstance();
        date.set(2003, Calendar.MARCH, 20);
        
        picker.setDate(date.getTime());
        picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
		picker.setBounds(262, 104, 156, 20);
		panel_1.add(picker);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(262, 158, 156, 20);
		panel_1.add(textFieldTongTien);
		
		textFieldSDT = new JTextField();
		textFieldSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSDT.setBounds(262, 205, 156, 20);
		panel_1.add(textFieldSDT);
		textFieldSDT.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setText("KH200320100001");
		txtMaKH.setOpaque(false);
		txtMaKH.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBorder(null);
		txtMaKH.setBackground(new Color(0, 0, 0, 0));
		txtMaKH.setBounds(161, 21, 189, 27);
		panel_1.add(txtMaKH);
	}

}
