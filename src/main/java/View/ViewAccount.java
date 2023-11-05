package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


import DAO.Account_DAO;
import DAO.NhanVien_DAO;
import Entity.Account;
import Entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;

public class ViewAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtName;
	private String imagePath = null;
	private JTextField txtMaAccount;
	private JTextField txtUserName;
	private JTextField txtPass;
	private JTextField txtChucVu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccount frame = new ViewAccount();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // đóng k ảnh hường tới fram cũ
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewAccount() {

		setBounds(100, 100, 651, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdd = new JLabel("Thông tin tài khoản");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdd.setBounds(248, 27, 199, 38);
		contentPane.add(lblAdd);

		final JLabel lblImg = new JLabel("");
		lblImg.setBounds(24, 92, 187, 196);
		contentPane.add(lblImg);
		// upload ảnh
		//
		JButton btnUpload = new JButton("Tải ảnh");
		btnUpload.setBounds(70, 327, 109, 38);
		contentPane.add(btnUpload);
		final JFrame frame = new JFrame("Image Uploader");

		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					imagePath = selectedFile.getAbsolutePath();
					// Kiểm tra xem tệp đã chọn là hình ảnh (có thể sử dụng các thư viện hỗ trợ hình
					// Sau đó, hiển thị hình ảnh trên JLabel.
					ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
					lblImg.setIcon(imageIcon);

					try {
						BufferedImage originalImage = ImageIO.read(selectedFile);
						int newWidth = lblImg.getWidth();
						int newHeight = lblImg.getHeight();
						Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

						ImageIcon imageIcon1 = new ImageIcon(scaledImage);
						lblImg.setIcon(imageIcon1);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// mã nhân viên
		JLabel lblMaNV = new JLabel("Mã nhân viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(282, 76, 103, 14);
		lblMaNV.setForeground(new Color(0, 153, 51));
		contentPane.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(410, 76, 187, 20);
		txtMaNV.setColumns(10);
		txtMaNV.setEditable(false);
		contentPane.add(txtMaNV);
		// tên nhân viên
		JLabel lblName = new JLabel("Tên nhân viên");
		lblName.setForeground(new Color(0, 153, 51));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(282, 109, 103, 14);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(410, 107, 187, 20);
		txtName.setEditable(false);
		contentPane.add(txtName);

		JLabel lblMaAccount = new JLabel("Mã tài khoản");
		lblMaAccount.setForeground(new Color(0, 153, 51));
		lblMaAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaAccount.setBounds(282, 146, 103, 14);
		contentPane.add(lblMaAccount);

		txtMaAccount = new JTextField();
		txtMaAccount.setColumns(10);
		txtMaAccount.setEditable(false);
		txtMaAccount.setBounds(410, 144, 187, 20);
		txtMaAccount.setEditable(false);
		contentPane.add(txtMaAccount);

		JLabel lblTenTaiKhoan = new JLabel("User Name");
		lblTenTaiKhoan.setForeground(new Color(255, 51, 51));
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenTaiKhoan.setBounds(282, 219, 103, 14);
		contentPane.add(lblTenTaiKhoan);

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setEditable(false);
		txtUserName.setBounds(410, 217, 187, 20);
		contentPane.add(txtUserName);

		JLabel lblMatKhau = new JLabel("Password");
		lblMatKhau.setForeground(new Color(255, 51, 102));
		lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatKhau.setBounds(282, 250, 103, 14);
		contentPane.add(lblMatKhau);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setEditable(false);
		txtPass.setBounds(410, 248, 187, 20);
		contentPane.add(txtPass);
		
		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setForeground(new Color(0, 153, 51));
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setBounds(282, 186, 103, 14);
		contentPane.add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(410, 182, 187, 20);
		contentPane.add(txtChucVu);
		
		final JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(488, 327, 109, 38);
		contentPane.add(btnXacNhan);
		btnXacNhan.setEnabled(false);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(282, 327, 109, 38);
		contentPane.add(btnSua);

		// sửa account
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhan.setEnabled(true);
				txtUserName.setEditable(true);
				txtPass.setEditable(true);
			}
		});
		
		// btn xác nhận  thông tin sửa
		btnXacNhan.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String accountID = txtMaAccount.getText();
		        String userName = txtUserName.getText();
		        String matKhau = txtPass.getText();	
		        String chucVu = txtChucVu.getText();
		        String maNhanVien = txtMaNV.getText();
		        if(userName.equals("") || matKhau.equals("")) {
		            JOptionPane.showMessageDialog(null, "Không được để trống");
		        } else {
		            Account accToUpdate = new Account(accountID, userName, matKhau, chucVu, maNhanVien);
		            Account_DAO accDao = new Account_DAO();
		            accDao.updateAccount(accToUpdate);
		            JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công");
		            txtUserName.setEditable(false);
		            txtPass.setEditable(false);
		        }
		    }
		});

	}

	public void setDataForAccount(String maNV, String hoTen,String role) {
		txtMaNV.setText(maNV);
		txtName.setText(hoTen);
		txtChucVu.setText(role);

		Account_DAO acc_dao = new Account_DAO();
		List<Account> taiKhoan = acc_dao.getAllAccount();

		for (Account account : taiKhoan) {
			if (maNV.equals(account.getMaNV())) {
				txtMaAccount.setText(account.getAccountID());
				txtUserName.setText(account.getUserName());
				txtPass.setText(account.getPassword());
				break; // Đã tìm thấy và thoát khỏi vòng lặp
			}
		}
	}
}
