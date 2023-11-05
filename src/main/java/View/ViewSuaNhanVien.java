//package View;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.filechooser.FileNameExtensionFilter;
//
//import com.toedter.calendar.JDateChooser;
//
//import DAO.NhanVien_DAO;
//import Entity.NhanVien;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.imageio.ImageIO;
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.JRadioButton;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//
//import java.awt.Color;
//
//public class ViewSuaNhanVien extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTextField txtMaNV;
//	private JTextField txtName;
//	private JTextField txtNgaySinh;
//	private JTextField txtCanCuoc;
//	private ButtonGroup gioiTinh;
//	private JTextField txtSDT;
//	private JTextField txtDiaChi;
//	private String imagePath;
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewSuaNhanVien frame = new ViewSuaNhanVien();
//					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // đóng k ảnh hường tới fram cũ
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ViewSuaNhanVien() {
//		//
//	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 651, 450);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(245, 245, 220));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		JLabel lblAdd = new JLabel("SỬA NHÂN VIÊN");
//		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblAdd.setBounds(248, 27, 199, 38);
//		contentPane.add(lblAdd);
//
//		JLabel lblImg = new JLabel();
//		lblImg.setBounds(24, 92, 187, 196);
//		contentPane.add(lblImg);
//		// upload ảnh
//
//		JButton btnUpload = new JButton("Tải lên");
//		btnUpload.setBounds(70, 327, 109, 38);
//		contentPane.add(btnUpload);
//		JFrame frame = new JFrame("Image Uploader");
//		btnUpload.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fileChooser = new JFileChooser();
//				int result = fileChooser.showOpenDialog(frame);
//				if (result == JFileChooser.APPROVE_OPTION) {
//					File selectedFile = fileChooser.getSelectedFile();
//					imagePath = selectedFile.getAbsolutePath();
//					// Kiểm tra xem tệp đã chọn là hình ảnh (có thể sử dụng các thư viện hỗ trợ hình
//					// Sau đó, hiển thị hình ảnh trên JLabel.
//					ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
//					lblImg.setIcon(imageIcon);
//
//					try {
//						BufferedImage originalImage = ImageIO.read(selectedFile);
//						int newWidth = lblImg.getWidth();
//						int newHeight = lblImg.getHeight();
//						Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//
//						ImageIcon imageIcon1 = new ImageIcon(scaledImage);
//						lblImg.setIcon(imageIcon1);
//					} catch (IOException ex) {
//						ex.printStackTrace();
//					}
//				}
//			}
//		});
//
//		frame.setVisible(true);
//
//		// mã nhân viên
//		JLabel lblMaNV = new JLabel("Mã nhân viên");
//		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblMaNV.setBounds(282, 76, 103, 14);
//		contentPane.add(lblMaNV);
//
//		txtMaNV = new JTextField();
//		txtMaNV.setBounds(410, 76, 187, 20);
//		contentPane.add(txtMaNV);
//		txtMaNV.setColumns(10);
//		// tên nhân viên
//		JLabel lblName = new JLabel("Tên nhân viên");
//		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblName.setBounds(282, 109, 103, 14);
//		contentPane.add(lblName);
//
//		txtName = new JTextField();
//		txtName.setColumns(10);
//		txtName.setBounds(410, 107, 187, 20);
//		contentPane.add(txtName);
//		// email
//		JLabel lblNgaySinh = new JLabel("Ngày sinh");
//		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblNgaySinh.setBounds(282, 137, 103, 14);
//		contentPane.add(lblNgaySinh);
//
//		JDateChooser dateChooser = new JDateChooser();
//		dateChooser.setBounds(603, 117, 156, 20);
//		dateChooser.setBounds(410, 138, 187, 20);
//		contentPane.add(dateChooser);
//		// giới tính
//		JLabel lblSex = new JLabel("Giới tính");
//		lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblSex.setBounds(282, 168, 103, 14);
//		contentPane.add(lblSex);
//
//		JRadioButton rdbtnMale = new JRadioButton("Nam");
//		rdbtnMale.setBounds(410, 165, 54, 23);
//		rdbtnMale.setBackground(new Color(245, 245, 220));
//		contentPane.add(rdbtnMale);
//
//		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
//		rdbtnFemale.setBounds(543, 165, 54, 23);
//		rdbtnFemale.setBackground(new Color(245, 245, 220));
//		contentPane.add(rdbtnFemale);
//
//		ButtonGroup gioiTinh = new ButtonGroup();
//		gioiTinh.add(rdbtnMale);
//		gioiTinh.add(rdbtnFemale);
//		// số điện thoại
//		JLabel lblSDT = new JLabel("Số điện thoại");
//		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblSDT.setBounds(282, 226, 103, 14);
//		contentPane.add(lblSDT);
//
//		txtCanCuoc = new JTextField();
//		txtCanCuoc.setColumns(10);
//		txtCanCuoc.setBounds(410, 195, 187, 20);
//		contentPane.add(txtCanCuoc);
//		// chức vụ
//		JLabel lblRole = new JLabel("Chức vụ");
//		lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblRole.setBounds(282, 289, 103, 14);
//		contentPane.add(lblRole);
//
//		JComboBox cobRole = new JComboBox();
//		cobRole.setBounds(410, 286, 187, 22);
//		contentPane.add(cobRole);
//
//		String[] arrRole = { "Chọn chức vụ", "Nhân viên quản lí", "Nhân viên bán hàng" };
//		for (String choice : arrRole) {
//			cobRole.addItem(choice);
//		}
//
//		// button xác nhận
//		JButton btnAdd = new JButton("Xác nhận");
//		btnAdd.setBounds(443, 327, 109, 38);
//		contentPane.add(btnAdd);
//
//		JLabel lblCanCuoc = new JLabel("Căn cước");
//		lblCanCuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblCanCuoc.setBounds(282, 197, 103, 14);
//		contentPane.add(lblCanCuoc);
//
//		txtSDT = new JTextField();
//		txtSDT.setColumns(10);
//		txtSDT.setBounds(410, 224, 187, 20);
//		contentPane.add(txtSDT);
//
//		JLabel lblDiaChi = new JLabel("Địa chỉ");
//		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblDiaChi.setBounds(282, 261, 103, 14);
//		contentPane.add(lblDiaChi);
//
//		txtDiaChi = new JTextField();
//		txtDiaChi.setColumns(10);
//		txtDiaChi.setBounds(410, 255, 187, 20);
//		contentPane.add(txtDiaChi);
//		
//		NhanVien_DAO dao = new NhanVien_DAO();
//		List<NhanVien> danhSachNhanVien = dao.getAllNhanVien();
//		
//		for(NhanVien nhanVien:danhSachNhanVien) {
//			txtMaNV.setText(nhanVien.getMaNhanVien());
//			txtName.setText(nhanVien.getTenNhanVien());
//			txtCanCuoc.setText(nhanVien.getCanCuoc());
//			txtDiaChi.setText(nhanVien.getDiaChi());
//			txtSDT.setText(nhanVien.getSoDienThoai());
//			String chucVu = nhanVien.getChucVu();
//			cobRole.setSelectedItem(chucVu);
//			boolean gioiTinh1 = nhanVien.isGioiTinh();
//			if (gioiTinh1 == true) {
//				rdbtnFemale.setSelected(false);
//				rdbtnMale.setSelected(true);
//			} else {
//				rdbtnFemale.setSelected(true);
//				rdbtnMale.setSelected(false);
//			}
//			Date ngaySinh = nhanVien.getNgaySinh();
//			dateChooser.setDate(ngaySinh);
//			String url = nhanVien.getHinhAnh();
//			ImageIcon icon = new ImageIcon(url);
//			Image image = icon.getImage();
//			int width = lblImg.getWidth();
//			int height = lblImg.getHeight();
//			Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//			lblImg.setIcon(new ImageIcon(scaledImage));
//		}
//		
//		btnAdd.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn cập nhật thông tin không?");
//		        if (option == JOptionPane.YES_OPTION) {
//		            String maNhanVien = txtMaNV.getText();
//		            String hoTen = txtName.getText();
//		            Date ngaySinh = new java.sql.Date(dateChooser.getDate().getTime());
//		            boolean gioiTinh = false;
//					if (rdbtnMale.isSelected()) {
//						gioiTinh = true; // Nam
//					} else if (rdbtnFemale.isSelected()) {
//						gioiTinh = false; // Nữ
//					}
//		            String canCuoc = txtCanCuoc.getText();
//		            String soDienThoai = txtSDT.getText();
//		            String diaChi = txtDiaChi.getText();
//		            String chucVu = (String) cobRole.getSelectedItem();
//		            // Lấy đường dẫn ảnh từ đối tượng hiện tại
//		            String hinhAnh = imagePath;
//	
//		            if (imagePath != null && !imagePath.isEmpty()) {
//		                ImageIcon image = new ImageIcon(imagePath);
//		                lblImg.setIcon(image);
//		            }
//		            // Tạo một đối tượng NhanVien mới với giá trị của hình ảnh được giữ nguyên
//		            NhanVien nhanVienUpdated = new NhanVien(maNhanVien, hoTen, ngaySinh, gioiTinh, canCuoc, soDienThoai, diaChi, chucVu, hinhAnh);
//		            NhanVien nhanVienUpdated1 = new NhanVien(maNhanVien, hoTen, ngaySinh, gioiTinh, canCuoc, soDienThoai, diaChi, chucVu, hinhAnh);
//		            // Gọi phương thức updateNhanVien để cập nhật dữ liệu
//		            NhanVien_DAO dao = new NhanVien_DAO();
//		            dao.updateNhanVien(nhanVienUpdated);
//		            dao.updateNhanVien(nhanVienUpdated1);
//		            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
//		            dispose();
//		        }
//		    }
//		});
//	}
//	
//}
