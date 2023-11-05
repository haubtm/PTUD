package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class ViewHoaDon extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color colorMenu = new Color(27, 64, 31);
	private JTextField textFieldMaKH;
	private JTextField textFieldHoTen;
	private JTextField textFieldGioiTinh;
	private JTextField textFieldNgaySinh;
	private JTextField textFieldMaHD;
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldNgayLapHD;
	private JTextField textFieldTimTheoTen;
	private JTextField textFieldTimTheoMa;
	private JTextField textFieldSoLuong;
	private JTextField textFieldTongTien;
	private JTextField textField_MaHD;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
	private JTextField textField_NgaySinh;
	private JTextField textField_SDT;
	private JTextField textField_TenNV;
	private JTextField textField_NgayHD;
	private JTextField textField_TongTien;
	private JTextField textField_TimTheoTen;
	private JTextField textField_TimTheoSDT;
	private JTable tableSanPham;
	private DefaultTableModel modelSanPham;
	private JTable tableHoaDon;
	private DefaultTableModel modelHoaDon;
	private JTable tableHDDaLap;
	private DefaultTableModel modelHDDaLap;
	private JTable tableChiTietHD;
	private DefaultTableModel modelChiTietHD;
	private JTextField textFieldSoHD;
	private JTextField txtTongVat;
	private JTextField txtn;
	private JTextField txtTongLoiNhuan;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHoaDon frame = new ViewHoaDon();
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
	public ViewHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color backgroundColor = new Color(239, 198, 87);
		JPanel pnlLoGo = new JPanel();
		pnlLoGo.setBounds(0, 0, 1239, 90);
		pnlLoGo.setBackground(new Color(210, 105, 30));
		contentPane.add(pnlLoGo);
		pnlLoGo.setLayout(null);
		
		JLabel lblLoGo = new JLabel("TT SHOP");
		lblLoGo.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblLoGo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoGo.setBounds(594, 21, 148, 44);
		pnlLoGo.add(lblLoGo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 87, 199, 676);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnDangXuat.setBounds(10, 161, 85, 35);
		panel_1.add(btnDangXuat);
		btnDangXuat.setBackground(colorMenu);
		btnDangXuat.setFocusPainted(false);
		
		JButton btnCaNhan = new JButton("Cá Nhân");
		btnCaNhan.setForeground(Color.WHITE);
		btnCaNhan.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnCaNhan.setBounds(105, 161, 85, 35);
		btnCaNhan.setBackground(colorMenu);
		btnCaNhan.setFocusPainted(false);
		
		panel_1.add(btnCaNhan);
		
		JLabel lblNewLabel = new JLabel("Hồ Vĩnh Duy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 206, 199, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 241, 199, 21);
		panel_1.add(lblNewLabel_1);
		
		JButton btnHoaDon = new JButton("Hoá Đơn");
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(0, 325, 199, 35);
		panel_1.add(btnHoaDon);
		btnHoaDon.setForeground(Color.BLACK);
		btnHoaDon.setFocusPainted(false);
		
		final JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhanVien.setBounds(0, 370, 199, 35);
		panel_1.add(btnNhanVien);
		btnNhanVien.setBackground(colorMenu);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFocusPainted(false);
		
		final JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(0, 415, 199, 35);
		panel_1.add(btnKhachHang);
		btnKhachHang.setBackground(colorMenu);
		btnKhachHang.setForeground(Color.WHITE);
		btnKhachHang.setFocusPainted(false);
		
		final JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSanPham.setBounds(0, 460, 199, 35);
		panel_1.add(btnSanPham);
		btnSanPham.setBackground(colorMenu);
		btnSanPham.setForeground(Color.WHITE);
		btnSanPham.setFocusPainted(false);
		
		JPanel pnlanhdaidien = new JPanel() {
		    	@Override
		    	protected void paintComponent(Graphics g) {
		        super.paintComponent(g);

		        int width = getWidth();
		        int height = getHeight();

		        // Tạo hình tròn
		        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);

		        // Làm cho góc của hình tròn trở nên bo tròn
		        Graphics2D g2d = (Graphics2D) g;
		        g2d.setClip(circle);

		        // Vẽ hình ảnh
		        ImageIcon icon = new ImageIcon(".\\IMG\\avatar.png");
		        Image img = icon.getImage();
		        g2d.drawImage(img, 0, 0, width, height, this);
		    }
		};
		pnlanhdaidien.setBounds(31, 10, 140, 140);
		pnlanhdaidien.setBackground(Color.ORANGE);
		panel_1.add(pnlanhdaidien);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(200, 92, 998, 657);
		contentPane.add(tabbedPane);
		
		JPanel panelTab1 = new JPanel();
		panelTab1.setLayout(null);
		tabbedPane.addTab("Lập hoá đơn", null, panelTab1, null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setLayout(null);
		panelLeft.setBounds(0, 0, 268, 629);
		panelTab1.add(panelLeft);
		
		JPanel panelThongTinKH = new JPanel();
		panelThongTinKH.setLayout(null);
		panelThongTinKH.setBackground(new Color(255, 255, 204));
		panelThongTinKH.setBounds(10, 11, 254, 292);
		panelLeft.add(panelThongTinKH);
		
		JButton btnThemKH = new JButton("Thêm mới KH ");
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThemKH.setBounds(10, 5, 106, 35);
		panelThongTinKH.add(btnThemKH);
		
		JLabel lblThongTinKH = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThongTinKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinKH.setBounds(37, 51, 166, 39);
		panelThongTinKH.add(lblThongTinKH);
		
		JButton btnTaoHD = new JButton("Tạo Hoá Đơn");
		btnTaoHD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTaoHD.setBounds(133, 5, 106, 35);
		panelThongTinKH.add(btnTaoHD);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setBounds(10, 101, 97, 14);
		panelThongTinKH.add(lblSDT);
		
		JComboBox comboBoxSDT = new JComboBox();
		comboBoxSDT.setEditable(true);
		comboBoxSDT.setBounds(106, 97, 118, 22);
		panelThongTinKH.add(comboBoxSDT);
		
		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setBounds(10, 136, 97, 14);
		panelThongTinKH.add(lblMaKH);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setBounds(10, 167, 97, 14);
		panelThongTinKH.add(lblHoTen);
		
		JLabel lblGioiTnh = new JLabel("Giới Tính:");
		lblGioiTnh.setBounds(10, 198, 97, 14);
		panelThongTinKH.add(lblGioiTnh);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setBounds(10, 232, 97, 14);
		panelThongTinKH.add(lblNgaySinh);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBounds(106, 133, 118, 20);
		panelThongTinKH.add(textFieldMaKH);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBounds(106, 164, 118, 20);
		panelThongTinKH.add(textFieldHoTen);
		
		textFieldGioiTinh = new JTextField();
		textFieldGioiTinh.setColumns(10);
		textFieldGioiTinh.setBounds(106, 195, 118, 20);
		panelThongTinKH.add(textFieldGioiTinh);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(106, 229, 118, 20);
		panelThongTinKH.add(textFieldNgaySinh);
		
		JPanel panelHD = new JPanel();
		panelHD.setLayout(null);
		panelHD.setBackground(new Color(255, 255, 204));
		panelHD.setBounds(10, 307, 254, 322);
		panelLeft.add(panelHD);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setText("HD202319080001");
		textFieldMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(48, 39, 141, 27);
		panelHD.add(textFieldMaHD);
		
		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setBounds(10, 90, 97, 14);
		panelHD.add(lblMaNV);
		
		JLabel lblTenNV = new JLabel("Tên Nhân Viên:");
		lblTenNV.setBounds(10, 135, 97, 14);
		panelHD.add(lblTenNV);
		
		JLabel lblNgayLapHD = new JLabel("Ngày Lập HĐ:");
		lblNgayLapHD.setBounds(10, 179, 97, 14);
		panelHD.add(lblNgayLapHD);
		
		JButton btnHuyHD = new JButton("Huỷ HD");
		btnHuyHD.setBounds(58, 230, 118, 35);
		panelHD.add(btnHuyHD);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setBounds(111, 87, 118, 20);
		panelHD.add(textFieldMaNV);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBounds(111, 132, 118, 20);
		panelHD.add(textFieldTenNV);
		
		textFieldNgayLapHD = new JTextField();
		textFieldNgayLapHD.setColumns(10);
		textFieldNgayLapHD.setBounds(111, 176, 118, 20);
		panelHD.add(textFieldNgayLapHD);
		
		JPanel panelRight = new JPanel();
		panelRight.setLayout(null);
		panelRight.setBounds(273, 0, 720, 629);
		panelTab1.add(panelRight);
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setLayout(null);
		panelSanPham.setBackground(new Color(255, 255, 204));
		panelSanPham.setBounds(0, 11, 710, 290);
		panelRight.add(panelSanPham);
		
		JLabel lblSanPham = new JLabel("SẢN PHẨM");
		lblSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSanPham.setBounds(10, 11, 104, 33);
		panelSanPham.add(lblSanPham);
		
		String row[] = {"Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Màu sắc", "Xuất sứ", "Giá bán", "Nhà Cung Cấp"};
		modelSanPham = new DefaultTableModel(row,0);
		String row1[] = {"SP001","Áo Thun Trắng","Áo Thun Trắng","Trắng","Việt Nam","1000","ELISE"};
		modelSanPham.addRow(row1);
		
		tableSanPham = new JTable(modelSanPham);
		
		JScrollPane scrollPaneSanPham = new JScrollPane(tableSanPham);
		scrollPaneSanPham.setBounds(10, 55, 573, 224);
		panelSanPham.add(scrollPaneSanPham);
		
		JLabel lblTimTen = new JLabel("Tìm theo tên:");
		lblTimTen.setBounds(148, 21, 88, 14);
		panelSanPham.add(lblTimTen);
		
		textFieldTimTheoTen = new JTextField();
		textFieldTimTheoTen.setColumns(10);
		textFieldTimTheoTen.setBounds(226, 18, 114, 20);
		panelSanPham.add(textFieldTimTheoTen);
		
		JLabel lblTimMa = new JLabel("Tìm theo mã:");
		lblTimMa.setBounds(371, 21, 88, 14);
		panelSanPham.add(lblTimMa);
		
		textFieldTimTheoMa = new JTextField();
		textFieldTimTheoMa.setColumns(10);
		textFieldTimTheoMa.setBounds(469, 18, 114, 20);
		panelSanPham.add(textFieldTimTheoMa);
		
		JLabel lblChiTiet = new JLabel("CHỌN CHI TIẾT");
		lblChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTiet.setBounds(593, 123, 107, 14);
		panelSanPham.add(lblChiTiet);
		
		JLabel lblKichThuoc = new JLabel("Kích thước");
		lblKichThuoc.setBounds(587, 162, 73, 14);
		panelSanPham.add(lblKichThuoc);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(587, 203, 54, 14);
		panelSanPham.add(lblSoLuong);
		
		JComboBox comboBoxKichThuoc = new JComboBox();
		comboBoxKichThuoc.setEditable(true);
		comboBoxKichThuoc.setBounds(651, 158, 54, 22);
		panelSanPham.add(comboBoxKichThuoc);
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(611, 243, 89, 36);
		panelSanPham.add(btnThemSP);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(651, 200, 54, 20);
		panelSanPham.add(textFieldSoLuong);
		
		JPanel panelIMGSP = new JPanel();
		ImageIcon imageSP = new ImageIcon(".\\IMG\\Áo-Polp-Nam.png");
		panelIMGSP.setBounds(593, 11, 107, 100);
		panelSanPham.add(panelIMGSP);
		
		JLabel labelIMGSP = new JLabel();
		labelIMGSP.setIcon(imageSP);
		panelIMGSP.add(labelIMGSP);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setLayout(null);
		panelHoaDon.setBackground(new Color(255, 255, 204));
		panelHoaDon.setBounds(0, 306, 710, 323);
		panelRight.add(panelHoaDon);
		
		JLabel lblThongTinHD = new JLabel("THÔNG TIN HOÁ ĐƠN");
		lblThongTinHD.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongTinHD.setBounds(10, 11, 185, 39);
		panelHoaDon.add(lblThongTinHD);
		
		String rowHD[] = {"Tên sản phẩm", "Màu sắc", "Đơn vị", "Giá bán", "Kích thước", "Số lượng", "Tiền VAT", "Thành Tiền"};
		modelHoaDon = new DefaultTableModel(rowHD,0);
		String rowHD1[] = {"Áo Thun Trắng","Trắng","Cái","147.000 VND","5","1","147.000 VND","147.000 VND"};
		modelHoaDon.addRow(rowHD1);
		
		tableHoaDon = new JTable(modelHoaDon);
		
		JScrollPane scrollPaneHD = new JScrollPane(tableHoaDon);
		scrollPaneHD.setBounds(10, 49, 690, 180);
		panelHoaDon.add(scrollPaneHD);
		
		JButton btnXoaSP = new JButton("Xoá");
		btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaSP.setBounds(205, 11, 79, 32);
		panelHoaDon.add(btnXoaSP);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setForeground(Color.BLUE);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongTien.setBounds(10, 254, 113, 39);
		panelHoaDon.add(lblTongTien);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(121, 265, 96, 23);
		panelHoaDon.add(textFieldTongTien);
		
		JLabel lblVND = new JLabel("VNĐ");
		lblVND.setHorizontalAlignment(SwingConstants.CENTER);
		lblVND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVND.setBounds(227, 265, 56, 24);
		panelHoaDon.add(lblVND);
		
		JButton btnCho = new JButton("Chờ");
		btnCho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCho.setBounds(314, 255, 89, 39);
		panelHoaDon.add(btnCho);
		
		JButton btnDanhSachCho = new JButton("Danh sách chờ");
		btnDanhSachCho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDanhSachCho.setBounds(413, 255, 135, 39);
		panelHoaDon.add(btnDanhSachCho);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhToan.setBounds(558, 255, 142, 39);
		panelHoaDon.add(btnThanhToan);
		
		JPanel panelTab2 = new JPanel();
		panelTab2.setLayout(null);
		tabbedPane.addTab("Hoá đơn đã lập", null, panelTab2, null);
		
		JPanel panelLeft2 = new JPanel();
		panelLeft2.setLayout(null);
		panelLeft2.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 102, 0)));
		panelLeft2.setBackground(new Color(255, 255, 204));
		panelLeft2.setBounds(0, 0, 264, 629);
		panelTab2.add(panelLeft2);
		
		JLabel lblChiTietHD = new JLabel("Chi tiết hoá đơn");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setForeground(Color.BLUE);
		lblChiTietHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiTietHD.setBounds(40, 11, 168, 56);
		panelLeft2.add(lblChiTietHD);
		
		JLabel lblMaHD = new JLabel("Mã hoá đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaHD.setBounds(10, 89, 81, 14);
		panelLeft2.add(lblMaHD);
		
		JLabel lblMaKH2 = new JLabel("Mã khách hàng");
		lblMaKH2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaKH2.setBounds(10, 127, 95, 14);
		panelLeft2.add(lblMaKH2);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng");
		lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenKH.setBounds(10, 165, 110, 14);
		panelLeft2.add(lblTenKH);
		
		JLabel lblNgaySinh2 = new JLabel("Ngày sinh");
		lblNgaySinh2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh2.setBounds(10, 203, 81, 14);
		panelLeft2.add(lblNgaySinh2);
		
		JLabel lblSDT2 = new JLabel("Số điện thoại");
		lblSDT2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT2.setBounds(10, 243, 95, 14);
		panelLeft2.add(lblSDT2);
		
		JLabel lblNV = new JLabel("Nhân viên");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNV.setBounds(10, 283, 81, 14);
		panelLeft2.add(lblNV);
		
		JLabel lblNgayLapHD2 = new JLabel("Ngày lập HĐ");
		lblNgayLapHD2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD2.setBounds(10, 323, 81, 14);
		panelLeft2.add(lblNgayLapHD2);
		
		JLabel lblTongTien2 = new JLabel("Tổng tiền");
		lblTongTien2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongTien2.setBounds(10, 362, 81, 14);
		panelLeft2.add(lblTongTien2);
		
		textField_MaHD = new JTextField();
		textField_MaHD.setEditable(false);
		textField_MaHD.setColumns(10);
		textField_MaHD.setBorder(null);
		textField_MaHD.setBackground(SystemColor.menu);
		textField_MaHD.setBounds(126, 87, 116, 20);
		panelLeft2.add(textField_MaHD);
		
		textField_MaKH = new JTextField();
		textField_MaKH.setEditable(false);
		textField_MaKH.setColumns(10);
		textField_MaKH.setBorder(null);
		textField_MaKH.setBackground(SystemColor.menu);
		textField_MaKH.setBounds(126, 125, 116, 20);
		panelLeft2.add(textField_MaKH);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setEditable(false);
		textField_TenKH.setColumns(10);
		textField_TenKH.setBorder(null);
		textField_TenKH.setBackground(SystemColor.menu);
		textField_TenKH.setBounds(126, 163, 116, 20);
		panelLeft2.add(textField_TenKH);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setEditable(false);
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBorder(null);
		textField_NgaySinh.setBackground(SystemColor.menu);
		textField_NgaySinh.setBounds(126, 201, 116, 20);
		panelLeft2.add(textField_NgaySinh);
		
		textField_SDT = new JTextField();
		textField_SDT.setEditable(false);
		textField_SDT.setColumns(10);
		textField_SDT.setBorder(null);
		textField_SDT.setBackground(SystemColor.menu);
		textField_SDT.setBounds(126, 241, 116, 20);
		panelLeft2.add(textField_SDT);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setEditable(false);
		textField_TenNV.setColumns(10);
		textField_TenNV.setBorder(null);
		textField_TenNV.setBackground(SystemColor.menu);
		textField_TenNV.setBounds(126, 281, 116, 20);
		panelLeft2.add(textField_TenNV);
		
		textField_NgayHD = new JTextField();
		textField_NgayHD.setEditable(false);
		textField_NgayHD.setColumns(10);
		textField_NgayHD.setBorder(null);
		textField_NgayHD.setBackground(SystemColor.menu);
		textField_NgayHD.setBounds(126, 321, 116, 20);
		panelLeft2.add(textField_NgayHD);
		
		textField_TongTien = new JTextField();
		textField_TongTien.setEditable(false);
		textField_TongTien.setColumns(10);
		textField_TongTien.setBorder(null);
		textField_TongTien.setBackground(SystemColor.menu);
		textField_TongTien.setBounds(126, 360, 116, 20);
		panelLeft2.add(textField_TongTien);
		
		JButton btnXoaHD = new JButton("Xoá");
		btnXoaHD.setBounds(10, 420, 87, 46);
		panelLeft2.add(btnXoaHD);
		
		final JButton btnInHD = new JButton("In hoá đơn");
		btnInHD.setBounds(147, 420, 95, 46);
		panelLeft2.add(btnInHD);
		
		JPanel panelRight2 = new JPanel();
		panelRight2.setLayout(null);
		panelRight2.setBackground(new Color(255, 255, 204));
		panelRight2.setBounds(264, 0, 729, 629);
		panelTab2.add(panelRight2);
		
		String rowHDDL[] = {"Mã hoá đơn","Mã khách hàng","Tên khách hàng", "Ngày sinh","Số điện thoại","Nhân viên", "Ngày lập HĐ","Tổng Tiền"};
		modelHDDaLap = new DefaultTableModel(rowHDDL,0);
		String rowHDDL1[] = {"HD202313130001","KH202302030001","Trương Văn Tuấn","17/03/1998","0385345330","Phạm Đức Tài","17/03/2023","147.000 VND"};
		for(int i =0; i<50;i++) {
			modelHDDaLap.addRow(rowHDDL1);
		}
		
		tableHDDaLap = new JTable(modelHDDaLap);
		
		JScrollPane scrollPaneHDDL = new JScrollPane(tableHDDaLap);
		scrollPaneHDDL.setBounds(0, 36, 719, 352);
		panelRight2.add(scrollPaneHDDL);
		
		JLabel lblSapXep = new JLabel("Sắp xếp theo");
		lblSapXep.setHorizontalAlignment(SwingConstants.CENTER);
		lblSapXep.setBounds(10, 11, 75, 14);
		panelRight2.add(lblSapXep);
		
		JComboBox comboBoxSapXep = new JComboBox();
		comboBoxSapXep.setBounds(84, 7, 121, 22);
		panelRight2.add(comboBoxSapXep);
		
		JLabel lblTmTheoTen = new JLabel("Tìm theo tên");
		lblTmTheoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTen.setBounds(226, 11, 78, 14);
		panelRight2.add(lblTmTheoTen);
		
		textField_TimTheoTen = new JTextField();
		textField_TimTheoTen.setColumns(10);
		textField_TimTheoTen.setBounds(303, 8, 113, 20);
		panelRight2.add(textField_TimTheoTen);
		
		JLabel lblTmTheoTenSDT = new JLabel("Tìm theo SDT");
		lblTmTheoTenSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTenSDT.setBounds(437, 11, 75, 14);
		panelRight2.add(lblTmTheoTenSDT);
		
		textField_TimTheoSDT = new JTextField();
		textField_TimTheoSDT.setColumns(10);
		textField_TimTheoSDT.setBounds(518, 8, 113, 20);
		panelRight2.add(textField_TimTheoSDT);
		
		JLabel lblCTHD = new JLabel("CHI TIẾT HOÁ ĐƠN");
		lblCTHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblCTHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCTHD.setBounds(275, 399, 132, 14);
		panelRight2.add(lblCTHD);
		
		String rowCTHD[] = {"Tên sản phẩm", "Màu sắc", "Đơn vị", "Giá bán", "Kích thước", "Số lượng", "Tiền VAT", "Thành Tiền"};
		modelChiTietHD = new DefaultTableModel(rowCTHD,0);
		String rowCTHD1[] = {"Áo Thun Trắng","Trắng","Cái","147.000 VND","5","1", "147.000 VND","147.000 VND"};
		modelChiTietHD.addRow(rowCTHD1);
		String rowCTHD2[] = {"Đồng hồ nam","Đen","Cái","1.547.000 VND","No","1","1.547.000 VND"};
		modelChiTietHD.addRow(rowCTHD2);
		
		tableChiTietHD = new JTable(modelChiTietHD);
		
		JScrollPane scrollPaneCTHD = new JScrollPane(tableChiTietHD);
		scrollPaneCTHD.setBounds(0, 424, 719, 205);
		panelRight2.add(scrollPaneCTHD);
		Color backgroundColorSapXep = new Color(226, 240, 222);
		
		// Code Tab3
		JPanel panelTab3 = new JPanel();
		tabbedPane.addTab("Thống Kê Doanh Thu", null, panelTab3, null);
		panelTab3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 983, 629);
		panelTab3.add(panel);
		panel.setLayout(null);
		
		JLabel lblThongKeTheo = new JLabel("Thống kê theo:");
		lblThongKeTheo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongKeTheo.setBounds(32, 11, 114, 22);
		panel.add(lblThongKeTheo);
		
		JComboBox comboBoxThongKe = new JComboBox();
		comboBoxThongKe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxThongKe.setModel(new DefaultComboBoxModel(new String[] {"Thống kê theo năm", "Thống kê theo quý", "Thống kê theo tháng"}));
		comboBoxThongKe.setSelectedIndex(0);
		comboBoxThongKe.setBounds(160, 12, 157, 22);
		panel.add(comboBoxThongKe);
		
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblThang.setBounds(32, 56, 46, 14);
		panel.add(lblThang);
		
		JComboBox comboBoxThang = new JComboBox();
		comboBoxThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxThang.setBounds(88, 53, 46, 22);
		panel.add(comboBoxThang);
		
		JLabel lblQuy = new JLabel("Quý:");
		lblQuy.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblQuy.setBounds(160, 57, 36, 14);
		panel.add(lblQuy);
		
		JComboBox comboBoxQuy = new JComboBox();
		comboBoxQuy.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxQuy.setBounds(200, 53, 46, 22);
		panel.add(comboBoxQuy);
		
		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNam.setBounds(270, 57, 36, 14);
		panel.add(lblNam);
		
		JComboBox comboBoxNam = new JComboBox();
		comboBoxNam.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBoxNam.setBounds(309, 53, 57, 22);
		panel.add(comboBoxNam);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThongKe.setBounds(424, 40, 105, 46);
		panel.add(btnThongKe);
		
		JPanel panelSoHD = new JPanel() {
	    	@Override
	    	protected void paintComponent(Graphics g) {
	    	setOpaque(false);
	        super.paintComponent(g);

	        int width = getWidth();
	        int height = getHeight();
	        // Tạo hình tròn
	        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
	        // Làm cho góc của hình tròn trở nên bo tròn
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(getBackground());
	        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, 20, 20));
	    	}
		};
		panelSoHD.setBackground(new Color(255, 204, 0));
		panelSoHD.setBounds(32, 124, 434, 224);
		panel.add(panelSoHD);
		panelSoHD.setLayout(null);
		
		JLabel lblSoHD = new JLabel("Số hoá đơn: ");
		lblSoHD.setForeground(new Color(255, 255, 255));
		lblSoHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoHD.setBounds(52, 96, 98, 29);
		panelSoHD.add(lblSoHD);
		
		textFieldSoHD = new JTextField();
		textFieldSoHD.setText("2 đơn");
		textFieldSoHD.setForeground(new Color(255, 255, 255));
		textFieldSoHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldSoHD.setEditable(false);
		textFieldSoHD.setBorder(null);
		textFieldSoHD.setOpaque(false);
		textFieldSoHD.setBackground(new Color(0, 0, 0, 0));
		textFieldSoHD.setBounds(147, 102, 54, 20);
		panelSoHD.add(textFieldSoHD);
		textFieldSoHD.setColumns(10);
		
		JPanel panelTongVAT = new JPanel() {
	    	@Override
	    	protected void paintComponent(Graphics g) {
	    	setOpaque(false);
	        super.paintComponent(g);

	        int width = getWidth();
	        int height = getHeight();
	        // Tạo hình tròn
	        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
	        // Làm cho góc của hình tròn trở nên bo tròn
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(getBackground());
	        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, 20, 20));
	    	}
		};
		panelTongVAT.setBackground(new Color(0, 204, 51));
		panelTongVAT.setBounds(32, 378, 434, 224);
		panel.add(panelTongVAT);
		panelTongVAT.setLayout(null);
		
		JLabel lblTongVat = new JLabel("Tổng VAT:");
		lblTongVat.setForeground(Color.WHITE);
		lblTongVat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongVat.setBounds(54, 93, 85, 29);
		panelTongVAT.add(lblTongVat);
		
		txtTongVat = new JTextField();
		txtTongVat.setText("70.000 VND");
		txtTongVat.setOpaque(false);
		txtTongVat.setForeground(Color.WHITE);
		txtTongVat.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTongVat.setEditable(false);
		txtTongVat.setColumns(10);
		txtTongVat.setBorder(null);
		txtTongVat.setBackground(new Color(0, 0, 0, 0));
		txtTongVat.setBounds(138, 98, 150, 20);
		panelTongVAT.add(txtTongVat);
		
		JPanel panelTongTien = new JPanel() {
	    	@Override
	    	protected void paintComponent(Graphics g) {
	    	setOpaque(false);
	        super.paintComponent(g);

	        int width = getWidth();
	        int height = getHeight();
	        // Tạo hình tròn
	        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
	        // Làm cho góc của hình tròn trở nên bo tròn
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(getBackground());
	        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, 20, 20));
	    	}
		};
		panelTongTien.setBackground(new Color(51, 0, 255));
		panelTongTien.setBounds(509, 124, 434, 224);
		panel.add(panelTongTien);
		panelTongTien.setLayout(null);
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setForeground(Color.WHITE);
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTngTin.setBounds(72, 93, 84, 29);
		panelTongTien.add(lblTngTin);
		
		txtn = new JTextField();
		txtn.setText("910.000 VND");
		txtn.setOpaque(false);
		txtn.setForeground(Color.WHITE);
		txtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtn.setEditable(false);
		txtn.setColumns(10);
		txtn.setBorder(null);
		txtn.setBackground(new Color(0, 0, 0, 0));
		txtn.setBounds(154, 98, 159, 20);
		panelTongTien.add(txtn);
		
		JPanel panelTongLoiNhuan = new JPanel() {
	    	@Override
	    	protected void paintComponent(Graphics g) {
	    	setOpaque(false);
	        super.paintComponent(g);

	        int width = getWidth();
	        int height = getHeight();
	        // Tạo hình tròn
	        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, width, height);
	        // Làm cho góc của hình tròn trở nên bo tròn
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(getBackground());
	        g2d.fill(new RoundRectangle2D.Float(0, 0, width, height, 20, 20));
	    	}
		};
		panelTongLoiNhuan.setBackground(new Color(255, 51, 102));
		panelTongLoiNhuan.setBounds(509, 378, 434, 224);
		panel.add(panelTongLoiNhuan);
		panelTongLoiNhuan.setLayout(null);
		
		JLabel lblTongLoiNhuan = new JLabel("Tổng lợi nhuận:");
		lblTongLoiNhuan.setForeground(Color.WHITE);
		lblTongLoiNhuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTongLoiNhuan.setBounds(75, 97, 114, 29);
		panelTongLoiNhuan.add(lblTongLoiNhuan);
		
		txtTongLoiNhuan = new JTextField();
		txtTongLoiNhuan.setText("210.000 VND");
		txtTongLoiNhuan.setOpaque(false);
		txtTongLoiNhuan.setForeground(Color.WHITE);
		txtTongLoiNhuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTongLoiNhuan.setEditable(false);
		txtTongLoiNhuan.setColumns(10);
		txtTongLoiNhuan.setBorder(null);
		txtTongLoiNhuan.setBackground(new Color(0, 0, 0, 0));
		txtTongLoiNhuan.setBounds(195, 102, 163, 20);
		panelTongLoiNhuan.add(txtTongLoiNhuan);
		
		// Code xu ly event
		btnInHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnInHD)) {
		    		ViewThanhToan viewTT = new ViewThanhToan();
		    		viewTT.setLocationRelativeTo(null);
		    		viewTT.setVisible(true);
		        }
			}
		});
		
		btnKhachHang.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnKhachHang)) {
		    		ViewKhachHang hd = new ViewKhachHang();
		            hd.setLocationRelativeTo(null);
		            hd.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
		
		btnNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnNhanVien)) {
		    		ViewNhanVien1 nv = new ViewNhanVien1();
		    		nv.setLocationRelativeTo(null);
		    		nv.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
		
		btnSanPham.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnSanPham)) {
		    		ViewSanPham sp = new ViewSanPham();
		    		sp.setLocationRelativeTo(null);
		    		sp.setVisible(true);
		            dispose();
		        }
		       
		    }
		});
	}
}

