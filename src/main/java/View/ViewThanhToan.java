package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField txtVnd;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField txtHd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewThanhToan frame = new ViewThanhToan();
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
	public ViewThanhToan() {
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
		textField.setText("20/03/2023");
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
		lblMaKH.setBounds(75, 59, 136, 17);
		panel_1.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên Khách Hàng:");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenKH.setBounds(75, 84, 136, 17);
		panel_1.add(lblTenKH);
		
		JLabel lblTongThanhToan = new JLabel("Tổng Thanh Toán:");
		lblTongThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongThanhToan.setBounds(75, 109, 136, 17);
		panel_1.add(lblTongThanhToan);
		
		JLabel lblTienKHDua = new JLabel("Tiền Khách Đưa:");
		lblTienKHDua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienKHDua.setBounds(75, 134, 136, 17);
		panel_1.add(lblTienKHDua);
		
		JLabel lblTienTra = new JLabel("Tiền Trả Khách:");
		lblTienTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienTra.setBounds(75, 159, 136, 17);
		panel_1.add(lblTienTra);
		
		final JButton btnDong = new JButton("Đóng");
		btnDong.setBounds(187, 204, 65, 35);
		panel_1.add(btnDong);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBounds(262, 204, 100, 35);
		panel_1.add(btnThanhToan);
		
		JButton btnInHoaDon = new JButton("In hoá đơn");
		btnInHoaDon.setBounds(372, 204, 102, 35);
		panel_1.add(btnInHoaDon);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMaKH.setText("KH200320100001");
		textFieldMaKH.setEditable(false);
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBorder(null);
		textFieldMaKH.setOpaque(false);
		textFieldMaKH.setBackground(new Color(0, 0, 0, 0));
		textFieldMaKH.setBounds(262, 58, 156, 20);
		panel_1.add(textFieldMaKH);
		textFieldMaKH.setColumns(10);
		
		textFieldTenKH = new JTextField();
		textFieldTenKH.setText("Lê Bá Hậu");
		textFieldTenKH.setOpaque(false);
		textFieldTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTenKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTenKH.setEditable(false);
		textFieldTenKH.setColumns(10);
		textFieldTenKH.setBorder(null);
		textFieldTenKH.setBackground(new Color(0, 0, 0, 0));
		textFieldTenKH.setBounds(262, 84, 156, 20);
		panel_1.add(textFieldTenKH);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setText("3400000");
		textFieldTongTien.setOpaque(false);
		textFieldTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTongTien.setEditable(false);
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBorder(null);
		textFieldTongTien.setBackground(new Color(0, 0, 0, 0));
		textFieldTongTien.setBounds(262, 109, 88, 20);
		panel_1.add(textFieldTongTien);
		
		textField_3 = new JTextField();
		textField_3.setText("100000");
		textField_3.setOpaque(false);
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(0, 0, 0, 0));
		textField_3.setBounds(262, 159, 88, 20);
		panel_1.add(textField_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setText("3500000");
		textField_1.setBounds(262, 134, 88, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		txtVnd = new JTextField();
		txtVnd.setText("VND");
		txtVnd.setOpaque(false);
		txtVnd.setHorizontalAlignment(SwingConstants.LEFT);
		txtVnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtVnd.setEditable(false);
		txtVnd.setColumns(10);
		txtVnd.setBorder(null);
		txtVnd.setBackground(new Color(0, 0, 0, 0));
		txtVnd.setBounds(360, 133, 58, 20);
		panel_1.add(txtVnd);
		
		textField_2 = new JTextField();
		textField_2.setText("VND");
		textField_2.setOpaque(false);
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(0, 0, 0, 0));
		textField_2.setBounds(360, 109, 58, 20);
		panel_1.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setText("VND");
		textField_4.setOpaque(false);
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(0, 0, 0, 0));
		textField_4.setBounds(360, 159, 58, 20);
		panel_1.add(textField_4);
		
		txtHd = new JTextField();
		txtHd.setText("HD200320100001");
		txtHd.setOpaque(false);
		txtHd.setHorizontalAlignment(SwingConstants.CENTER);
		txtHd.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtHd.setEditable(false);
		txtHd.setColumns(10);
		txtHd.setBorder(null);
		txtHd.setBackground(new Color(0, 0, 0, 0));
		txtHd.setBounds(161, 21, 189, 27);
		panel_1.add(txtHd);
		
		// Code xu ly event
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnDong)) {
		    		dispose();
		        }
			}
		});
	}

}
