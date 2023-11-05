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
import javax.swing.DefaultRowSorter;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.BadLocationException;

import DAO.ChiTietHoaDon_Dao;
import DAO.HoaDon_Dao;
import DAO.KhachHang_DAO;
import DAO.NhaCungCap_Dao;
import DAO.NhanVien_DAO;
import DAO.SanPham_Dao;
import DAO.SanPham_SizeS_Dao;
import DAO.Sizes_Dao;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhaCungCap;
import Entity.SanPham;
import Entity.SanPham_Sizes;
import connectDB.ConnectDB;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.SystemColor;

public class ViewHoaDon extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color colorMenu = new Color(27, 64, 31);
	private JTextField textFieldMaKH;
	private JTextField textFieldHoTen;
	private JTextField textFieldGioiTinh;
	private JTextField textFieldDiaChi;
	private JTextField textFieldMaHD;
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldNgayLapHD;
	private JTextField textFieldTimTheoTen;
	private JTextField textFieldSoLuong;
	private JTextField textFieldTongTien;
	private JTextField textField_MaHD;
	private JTextField textField_MaKH;
	private JTextField textField_TenKH;
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
	private JTextField txtTongTien;
	private JTextField txtTongLoiNhuan;
	private JComboBox comboBoxSDT;
	ArrayList<ChiTietHoaDon> ls_cthd = new ArrayList<>();
	private JTextField textFieldTimTheoMa;
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
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
		panelThongTinKH.setBounds(0, 0, 268, 303);
		panelLeft.add(panelThongTinKH);
		
		final JButton btnThemKH = new JButton("Thêm mới KH ");
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnThemKH.setBounds(10, 5, 106, 35);
		panelThongTinKH.add(btnThemKH);
		
		JLabel lblThongTinKH = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThongTinKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThongTinKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinKH.setBounds(10, 51, 193, 39);
		panelThongTinKH.add(lblThongTinKH);
		
		final JButton btnTaoHD = new JButton("Tạo Hoá Đơn");
		btnTaoHD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnTaoHD.setBounds(133, 5, 106, 35);
		panelThongTinKH.add(btnTaoHD);
		
		JLabel lblSDT = new JLabel("Số Điện Thoại:");
		lblSDT.setBounds(10, 101, 97, 14);
		panelThongTinKH.add(lblSDT);
		
		comboBoxSDT = new JComboBox();
		comboBoxSDT.setEditable(true);
		KhachHang_DAO kh_dao = new KhachHang_DAO();
		for (KhachHang kh : kh_dao.getAllKhachHang()) {
			comboBoxSDT.addItem(kh.getSoDienThoai());;
		}
		comboBoxSDT.setSelectedItem(null);
		comboBoxSDT.setBounds(93, 97, 106, 22);
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
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(10, 232, 97, 14);
		panelThongTinKH.add(lblDiaChi);
		
		textFieldMaKH = new JTextField();
		textFieldMaKH.setEditable(false);
		textFieldMaKH.setColumns(10);
		textFieldMaKH.setBorder(null);
		textFieldMaKH.setOpaque(false);
		textFieldMaKH.setBackground(new Color(0, 0, 0, 0));
		textFieldMaKH.setBounds(93, 133, 118, 20);
		panelThongTinKH.add(textFieldMaKH);
		
		textFieldHoTen = new JTextField();
		textFieldHoTen.setEditable(false);
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBorder(null);
		textFieldHoTen.setOpaque(false);
		textFieldHoTen.setBackground(new Color(0, 0, 0, 0));
		textFieldHoTen.setBounds(93, 164, 118, 20);
		panelThongTinKH.add(textFieldHoTen);
		
		textFieldGioiTinh = new JTextField();
		textFieldGioiTinh.setEditable(false);
		textFieldGioiTinh.setColumns(10);
		textFieldGioiTinh.setBorder(null);
		textFieldGioiTinh.setOpaque(false);
		textFieldGioiTinh.setBackground(new Color(0, 0, 0, 0));
		textFieldGioiTinh.setBounds(93, 195, 118, 20);
		panelThongTinKH.add(textFieldGioiTinh);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldDiaChi.setEditable(false);
		textFieldDiaChi.setColumns(30);
		textFieldDiaChi.setBorder(null);
		textFieldDiaChi.setOpaque(false);
		textFieldDiaChi.setBackground(new Color(0, 0, 0, 0));
		textFieldDiaChi.setBounds(93, 229, 118, 20);
		panelThongTinKH.add(textFieldDiaChi);
		
		final JButton btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnLoc.setBounds(205, 97, 53, 23);
		panelThongTinKH.add(btnLoc);
		
		final JButton btnHuyLoc = new JButton("Huỷ");
		btnHuyLoc.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnHuyLoc.setBounds(205, 61, 53, 23);
		panelThongTinKH.add(btnHuyLoc);
		
		JPanel panelHD = new JPanel();
		panelHD.setLayout(null);
		panelHD.setBackground(new Color(255, 255, 204));
		panelHD.setBounds(0, 307, 268, 322);
		panelLeft.add(panelHD);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldMaHD.setEditable(false);
		textFieldMaHD.setText("");
		textFieldMaHD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaHD.setColumns(10);		
		textFieldMaHD.setBorder(null);
		textFieldMaHD.setOpaque(false);
		textFieldMaHD.setBackground(new Color(0, 0, 0, 0));
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
		
		final JButton btnHuyHD = new JButton("Huỷ HD");
		btnHuyHD.setBounds(58, 230, 118, 35);
		btnHuyHD.setEnabled(false);
		panelHD.add(btnHuyHD);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setEditable(false);
		textFieldMaNV.setColumns(10);		
		textFieldMaNV.setBorder(null);
		textFieldMaNV.setOpaque(false);
		textFieldMaNV.setBackground(new Color(0, 0, 0, 0));
		textFieldMaNV.setBounds(111, 87, 118, 20);
		panelHD.add(textFieldMaNV);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setEditable(false);
		textFieldTenNV.setColumns(10);		
		textFieldTenNV.setBorder(null);
		textFieldTenNV.setOpaque(false);
		textFieldTenNV.setBackground(new Color(0, 0, 0, 0));
		textFieldTenNV.setBounds(111, 132, 118, 20);
		panelHD.add(textFieldTenNV);
		
		textFieldNgayLapHD = new JTextField();
		textFieldNgayLapHD.setEditable(false);
		textFieldNgayLapHD.setColumns(10);		
		textFieldNgayLapHD.setBorder(null);
		textFieldNgayLapHD.setOpaque(false);
		textFieldNgayLapHD.setBackground(new Color(0, 0, 0, 0));
		textFieldNgayLapHD.setBounds(111, 176, 118, 20);
		panelHD.add(textFieldNgayLapHD);
		
		JPanel panelRight = new JPanel();
		panelRight.setLayout(null);
		panelRight.setBounds(273, 0, 720, 629);
		panelTab1.add(panelRight);
		
		JPanel panelSanPham = new JPanel();
		panelSanPham.setLayout(null);
		panelSanPham.setBackground(new Color(255, 255, 204));
		panelSanPham.setBounds(0, 0, 710, 301);
		panelRight.add(panelSanPham);
		
		JLabel lblSanPham = new JLabel("SẢN PHẨM");
		lblSanPham.setHorizontalAlignment(SwingConstants.LEFT);
		lblSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSanPham.setBounds(10, 3, 104, 33);
		panelSanPham.add(lblSanPham);
		
		
		JLabel lblTimTen = new JLabel("Tìm theo tên:");
		lblTimTen.setBounds(132, 14, 88, 14);
		panelSanPham.add(lblTimTen);
		
		textFieldTimTheoTen = new JTextField();
		textFieldTimTheoTen.setEnabled(false);
		textFieldTimTheoTen.setEditable(false);
		textFieldTimTheoTen.setColumns(10);
		textFieldTimTheoTen.setBounds(210, 11, 114, 20);
		
		panelSanPham.add(textFieldTimTheoTen);
		
		JLabel lblChiTiet = new JLabel("CHỌN CHI TIẾT");
		lblChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTiet.setBounds(593, 169, 95, 14);
		panelSanPham.add(lblChiTiet);
		
		JLabel lblKichThuoc = new JLabel("Kích thước");
		lblKichThuoc.setBounds(572, 198, 73, 14);
		panelSanPham.add(lblKichThuoc);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setBounds(572, 226, 54, 14);
		panelSanPham.add(lblSoLuong);
		
		final JComboBox comboBoxKichThuoc = new JComboBox();
		comboBoxKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxKichThuoc.setEnabled(false);
		comboBoxKichThuoc.setBounds(637, 194, 73, 22);
		panelSanPham.add(comboBoxKichThuoc);
		
		final JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setEnabled(false);
		btnThemSP.setBounds(611, 254, 89, 36);
		panelSanPham.add(btnThemSP);
		
		textFieldSoLuong = new JTextField();
		textFieldSoLuong.setEditable(false);
		textFieldSoLuong.setEnabled(false);
		textFieldSoLuong.setColumns(10);
		textFieldSoLuong.setBounds(636, 223, 74, 20);
		panelSanPham.add(textFieldSoLuong);
		
		JPanel panelIMGSP = new JPanel();
		panelIMGSP.setBounds(593, 0, 117, 168);
		panelSanPham.add(panelIMGSP);
		
		
		final JLabel labelIMGSP = new JLabel();
		panelIMGSP.add(labelIMGSP);
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		String row[] = {"Mã Sản Phẩm", "Tên sản phẩm", "Mô tả", "Màu sắc", "Xuất sứ", "Giá bán", "Nhà Cung Cấp"};
		modelSanPham = new DefaultTableModel(row,0){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		// xét màu cho hàng
		tableSanPham = new JTable(modelSanPham) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				// căn giữa nội dung table
//				DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//				center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//				for (int i = 0; i < modelSanPham.getColumnCount(); i++) {
//					tableSanPham.getColumnModel().getColumn(i).setCellRenderer(center);
//				}
				return component;
			}
		};
		
		TableRowSorter<DefaultTableModel> sorterSanPham = new TableRowSorter<>((DefaultTableModel) tableSanPham.getModel());
		tableSanPham.setRowSorter(sorterSanPham);
		
		tableSanPham.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tableSanPham.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				int row = tableSanPham.getSelectedRow();
				ImageIcon imageSP = new ImageIcon(gethinhAnh(modelSanPham.getValueAt(row, 0).toString()));
				labelIMGSP.setIcon(imageSP);
				
				comboBoxKichThuoc.removeAllItems();
				SanPham_SizeS_Dao sps_dao = new SanPham_SizeS_Dao();
				
				for (SanPham_Sizes sps : sps_dao.getAllSanPham_SizesByIdSP(modelSanPham.getValueAt(row, 0).toString())) {
					comboBoxKichThuoc.addItem(sps.getSizes().getTenSize());
				}
			}
		});
		
		JScrollPane scrollPaneSanPham = new JScrollPane(tableSanPham);
		scrollPaneSanPham.setBounds(10, 55, 557, 235);
		panelSanPham.add(scrollPaneSanPham);
		
		JLabel lblTimTheoMa = new JLabel("Tìm theo mã:");
		lblTimTheoMa.setBounds(359, 14, 88, 14);
		panelSanPham.add(lblTimTheoMa);
		
		textFieldTimTheoMa = new JTextField();
		textFieldTimTheoMa.setEnabled(false);
		textFieldTimTheoMa.setEditable(false);
		textFieldTimTheoMa.setColumns(10);
		textFieldTimTheoMa.setBounds(430, 11, 114, 20);
		panelSanPham.add(textFieldTimTheoMa);
		
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
		
		String rowHD[] = {"Tên sản phẩm", "Màu sắc", "Giá bán", "Kích thước", "Số lượng", "Tiền VAT", "Thành Tiền"};
		modelHoaDon = new DefaultTableModel(rowHD,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Thiết lập cột 1 (index 0) không cho phép chỉnh sửa
            	return false;
            }
		};
		
		tableHoaDon = new JTable(modelHoaDon){
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				// căn giữa nội dung table
//				DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//				center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//				for (int i = 0; i < modelSanPham.getColumnCount(); i++) {
//					tableSanPham.getColumnModel().getColumn(i).setCellRenderer(center);
//				}
				return component;
			}
		};
		tableHoaDon.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		tableHoaDon.getColumnModel().getColumn(3).setCellRenderer(center);
		tableHoaDon.getColumnModel().getColumn(4).setCellRenderer(center);
		tableHoaDon.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		tableHoaDon.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		
		modelHoaDon.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.DELETE) {
                	int rowCount = tableHoaDon.getRowCount();
                	Double tongTien = 0.0 ;
			        Locale locale = new Locale("vi", "VN");
			        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
                	if(rowCount > 0) {
                		for (int i = 0; i < rowCount; i++) {
                			String s = modelHoaDon.getValueAt(i, 6).toString();
                			String result = s.substring(0, s.length() - 2).replaceAll("\\.", "");
                            tongTien += Double.parseDouble(result);
							
						}
                	}
                	textFieldTongTien.setText(currencyFormat.format(tongTien));
                }		
			}
		});
		
		JScrollPane scrollPaneHD = new JScrollPane(tableHoaDon);
		scrollPaneHD.setBounds(10, 49, 690, 180);
		panelHoaDon.add(scrollPaneHD);
		
		final JButton btnXoaSP = new JButton("Xoá");
		btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaSP.setBounds(205, 11, 79, 32);
		btnXoaSP.setEnabled(false);
		panelHoaDon.add(btnXoaSP);
		
		JLabel lblTongTien = new JLabel("Tổng Tiền:");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setForeground(Color.BLUE);
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongTien.setBounds(10, 254, 113, 39);
		panelHoaDon.add(lblTongTien);
		
		textFieldTongTien = new JTextField();
		textFieldTongTien.setFont(new Font("Tahoma", Font.BOLD, 20));
		textFieldTongTien.setBorder(null);
		textFieldTongTien.setOpaque(false);
		textFieldTongTien.setBackground(new Color(0, 0, 0, 0));
		textFieldTongTien.setColumns(10);
		textFieldTongTien.setBounds(121, 261, 214, 23);
		panelHoaDon.add(textFieldTongTien);
		
		final JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setEnabled(false);
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
		
		JLabel lblSDT2 = new JLabel("Số điện thoại");
		lblSDT2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT2.setBounds(10, 207, 95, 14);
		panelLeft2.add(lblSDT2);
		
		JLabel lblNV = new JLabel("Nhân viên");
		lblNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNV.setBounds(10, 247, 81, 14);
		panelLeft2.add(lblNV);
		
		JLabel lblNgayLapHD2 = new JLabel("Ngày lập HĐ");
		lblNgayLapHD2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgayLapHD2.setBounds(10, 287, 81, 14);
		panelLeft2.add(lblNgayLapHD2);
		
		JLabel lblTongTien2 = new JLabel("Tổng tiền");
		lblTongTien2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTongTien2.setBounds(10, 326, 81, 14);
		panelLeft2.add(lblTongTien2);
		
		textField_MaHD = new JTextField();
		textField_MaHD.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaHD.setEditable(false);
		textField_MaHD.setColumns(10);
		textField_MaHD.setBorder(null);
		textField_MaHD.setOpaque(false);
		textField_MaHD.setBackground(new Color(0, 0, 0, 0));
		textField_MaHD.setBounds(126, 87, 116, 20);
		panelLeft2.add(textField_MaHD);
		
		textField_MaKH = new JTextField();
		textField_MaKH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaKH.setEditable(false);
		textField_MaKH.setColumns(10);
		textField_MaKH.setBorder(null);
		textField_MaKH.setOpaque(false);
		textField_MaKH.setBackground(new Color(0, 0, 0, 0));
		textField_MaKH.setBounds(126, 125, 116, 20);
		panelLeft2.add(textField_MaKH);
		
		textField_TenKH = new JTextField();
		textField_TenKH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TenKH.setEditable(false);
		textField_TenKH.setColumns(10);
		textField_TenKH.setBorder(null);
		textField_TenKH.setOpaque(false);
		textField_TenKH.setBackground(new Color(0, 0, 0, 0));
		textField_TenKH.setBounds(126, 163, 128, 20);
		panelLeft2.add(textField_TenKH);
		
		textField_SDT = new JTextField();
		textField_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		textField_SDT.setEditable(false);
		textField_SDT.setColumns(10);
		textField_SDT.setBorder(null);
		textField_SDT.setOpaque(false);
		textField_SDT.setBackground(new Color(0, 0, 0, 0));
		textField_SDT.setBounds(126, 205, 116, 20);
		panelLeft2.add(textField_SDT);
		
		textField_TenNV = new JTextField();
		textField_TenNV.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TenNV.setEditable(false);
		textField_TenNV.setColumns(10);
		textField_TenNV.setBorder(null);
		textField_TenNV.setOpaque(false);
		textField_TenNV.setBackground(new Color(0, 0, 0, 0));
		textField_TenNV.setBounds(126, 245, 116, 20);
		panelLeft2.add(textField_TenNV);
		
		textField_NgayHD = new JTextField();
		textField_NgayHD.setHorizontalAlignment(SwingConstants.LEFT);
		textField_NgayHD.setEditable(false);
		textField_NgayHD.setColumns(10);
		textField_NgayHD.setBorder(null);
		textField_NgayHD.setOpaque(false);
		textField_NgayHD.setBackground(new Color(0, 0, 0, 0));
		textField_NgayHD.setBounds(126, 285, 116, 20);
		panelLeft2.add(textField_NgayHD);
		
		textField_TongTien = new JTextField();
		textField_TongTien.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TongTien.setEditable(false);
		textField_TongTien.setColumns(10);
		textField_TongTien.setBorder(null);
		textField_TongTien.setOpaque(false);
		textField_TongTien.setBackground(new Color(0, 0, 0, 0));
		textField_TongTien.setBounds(126, 324, 116, 20);
		panelLeft2.add(textField_TongTien);
		
		final JButton btnXoaHD = new JButton("Xoá");
		btnXoaHD.setBounds(10, 384, 87, 46);
		panelLeft2.add(btnXoaHD);
		
		final JButton btnInHD = new JButton("In hoá đơn");
		btnInHD.setBounds(147, 384, 95, 46);
		panelLeft2.add(btnInHD);
		
		JPanel panelRight2 = new JPanel();
		panelRight2.setLayout(null);
		panelRight2.setBackground(new Color(255, 255, 204));
		panelRight2.setBounds(264, 0, 729, 629);
		panelTab2.add(panelRight2);
		
		String rowHDDL[] = {"Mã hoá đơn", "Mã khách hàng","Tên khách hàng","Số điện thoại","Nhân viên", "Ngày lập HĐ","Tổng Tiền"};
		modelHDDaLap = new DefaultTableModel(rowHDDL,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Thiết lập cột 1 (index 0) không cho phép chỉnh sửa
            	return false;
            }
		};
		dataHoaDon();
		
		tableHDDaLap = new JTable(modelHDDaLap){
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				// căn giữa nội dung table
//				DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//				center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//				for (int i = 0; i < modelSanPham.getColumnCount(); i++) {
//					tableSanPham.getColumnModel().getColumn(i).setCellRenderer(center);
//				}
				return component;
			}
		};
		
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) tableHDDaLap.getModel());
		tableHDDaLap.setRowSorter(sorter);
		
		tableHDDaLap.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableHDDaLap.getSelectedRow();
				String maHD = modelHDDaLap.getValueAt(row, 0).toString().trim();
				textField_MaHD.setText(maHD);
				textField_MaKH.setText(modelHDDaLap.getValueAt(row, 1).toString());
				textField_TenKH.setText(modelHDDaLap.getValueAt(row, 2).toString());
				textField_SDT.setText(modelHDDaLap.getValueAt(row, 3).toString());
				textField_TenNV.setText(modelHDDaLap.getValueAt(row, 4).toString());
				textField_NgayHD.setText(modelHDDaLap.getValueAt(row, 5).toString());
				textField_TongTien.setText(modelHDDaLap.getValueAt(row, 6).toString());
				
				ChiTietHoaDon_Dao cthd_dao = new ChiTietHoaDon_Dao();
				int rowCount = tableChiTietHD.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					modelChiTietHD.removeRow(0);
				}
		        Locale locale = new Locale("vi", "VN");
		        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
				for (ChiTietHoaDon cthd : cthd_dao.getAllChiTietHDByIdHD(maHD)) {
					SanPham_Dao sp_dao = new SanPham_Dao();
					SanPham sp = sp_dao.getSanPhamById(cthd.getMaSanPham());
					String thanhTien = String.format("%.0f", (cthd.getDonGia()*0.1 + cthd.getDonGia()) * cthd.getSoLuong() );
					String rowCTHD[] = {sp.getTenSanPham(), sp.getMauSac(), currencyFormat.format(cthd.getDonGia()), cthd.getKichThuoc(),
							cthd.getSoLuong() + "", currencyFormat.format(cthd.getDonGia() * 0.1), currencyFormat.format(Double.parseDouble(thanhTien))};
					modelChiTietHD.addRow(rowCTHD);
				}
			}
		});
		
		JScrollPane scrollPaneHDDL = new JScrollPane(tableHDDaLap);
		scrollPaneHDDL.setBounds(0, 36, 719, 352);
		panelRight2.add(scrollPaneHDDL);
		
		JLabel lblSapXep = new JLabel("Sắp xếp theo");
		lblSapXep.setHorizontalAlignment(SwingConstants.CENTER);
		lblSapXep.setBounds(10, 11, 75, 14);
		panelRight2.add(lblSapXep);
		
		final JComboBox comboBoxSapXep = new JComboBox();
		comboBoxSapXep.setModel(new DefaultComboBoxModel(new String[] {"ngày lập hoá đơn tăng", "ngày lập hoá đơn giảm", "tổng tiền tăng", "tổng tiền giảm"}));
		comboBoxSapXep.setBounds(95, 7, 157, 22);
		comboBoxSapXep.setSelectedItem(null);
		panelRight2.add(comboBoxSapXep);
		
		JLabel lblTmTheoTen = new JLabel("Tìm theo tên");
		lblTmTheoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTen.setBounds(289, 10, 78, 14);
		panelRight2.add(lblTmTheoTen);
		
		textField_TimTheoTen = new JTextField();
		textField_TimTheoTen.setColumns(10);
		textField_TimTheoTen.setBounds(366, 7, 113, 20);
		panelRight2.add(textField_TimTheoTen);
		
		JLabel lblTmTheoTenSDT = new JLabel("Tìm theo SDT");
		lblTmTheoTenSDT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmTheoTenSDT.setBounds(500, 10, 75, 14);
		panelRight2.add(lblTmTheoTenSDT);
		
		textField_TimTheoSDT = new JTextField();
		textField_TimTheoSDT.setColumns(10);
		textField_TimTheoSDT.setBounds(581, 7, 113, 20);
		panelRight2.add(textField_TimTheoSDT);
		
		JLabel lblCTHD = new JLabel("CHI TIẾT HOÁ ĐƠN");
		lblCTHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblCTHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCTHD.setBounds(275, 399, 132, 14);
		panelRight2.add(lblCTHD);
		
		String rowCTHD[] = {"Tên sản phẩm", "Màu sắc", "Đơn giá", "Kích thước", "Số lượng", "Tiền VAT", "Thành Tiền"};
		modelChiTietHD = new DefaultTableModel(rowCTHD,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Thiết lập cột 1 (index 0) không cho phép chỉnh sửa
            	return false;
            }
		};
//		// xét màu cho hàng
//		table = new JTable(model) {
//			@Override
//			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
//				Component component = super.prepareRenderer(renderer, row, column);
//				// Đặt màu nền cho các dòng (trừ header)
//				if (!isRowSelected(row)) {
//					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
//				}
//				if (!isRowSelected(row)) { // căn giữa nội dung table
//					((DefaultTableCellRenderer) component).setHorizontalAlignment(SwingConstants.CENTER);
//				}
//				return component;
//			}
//		};
		
		tableChiTietHD = new JTable(modelChiTietHD){
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				// căn giữa nội dung table
//				DefaultTableCellRenderer center = new DefaultTableCellRenderer();
//				center.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
//				for (int i = 0; i < modelSanPham.getColumnCount(); i++) {
//					tableSanPham.getColumnModel().getColumn(i).setCellRenderer(center);
//				}
				return component;
			}
		};
		
		JScrollPane scrollPaneCTHD = new JScrollPane(tableChiTietHD);
		scrollPaneCTHD.setBounds(0, 442, 719, 205);
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
		
		final JComboBox comboBoxThongKe = new JComboBox();
		comboBoxThongKe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxThongKe.setModel(new DefaultComboBoxModel(new String[] {"Thống kê theo năm", "Thống kê theo quý", "Thống kê theo tháng"}));
		comboBoxThongKe.setSelectedIndex(0);
		comboBoxThongKe.setBounds(160, 12, 157, 22);
		panel.add(comboBoxThongKe);
		
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblThang.setBounds(32, 56, 46, 14);
		panel.add(lblThang);
		
		final JComboBox comboBoxThang = new JComboBox();
		comboBoxThang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxThang.setSelectedIndex(0);
		comboBoxThang.setBounds(88, 53, 46, 22);
		comboBoxThang.setSelectedItem(null);
		panel.add(comboBoxThang);
		
		JLabel lblQuy = new JLabel("Quý:");
		lblQuy.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblQuy.setBounds(160, 57, 36, 14);
		panel.add(lblQuy);
		
		final JComboBox comboBoxQuy = new JComboBox();
		comboBoxQuy.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBoxQuy.setBounds(200, 53, 46, 22);
		comboBoxQuy.setSelectedItem(null);
		panel.add(comboBoxQuy);
		
		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNam.setBounds(270, 57, 36, 14);
		panel.add(lblNam);
		
		final JComboBox comboBoxNam = new JComboBox();
		comboBoxNam.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBoxNam.setBounds(309, 53, 57, 22);
		comboBoxNam.setSelectedItem(null);
		panel.add(comboBoxNam);
		
		final JButton btnThongKe = new JButton("Thống kê");
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
		txtTongVat.setText("0");
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
		
		txtTongTien = new JTextField();
		txtTongTien.setText("0");
		txtTongTien.setOpaque(false);
		txtTongTien.setForeground(Color.WHITE);
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTongTien.setEditable(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBorder(null);
		txtTongTien.setBackground(new Color(0, 0, 0, 0));
		txtTongTien.setBounds(154, 98, 159, 20);
		panelTongTien.add(txtTongTien);
		
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
		txtTongLoiNhuan.setText("0");
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
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnInHD)) {
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
		
		btnThemKH.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnThemKH)) {
		    		ViewThemKhachHang kh = new ViewThemKhachHang();
		    		kh.setLocationRelativeTo(null);
		    		kh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    		kh.setVisible(true);
		    		kh.setResizable(false);
		        }	
			}
		});
		
		final JTextField textField = (JTextField) comboBoxSDT.getEditor().getEditorComponent();
	    textField.getDocument().addDocumentListener(new DocumentListener() {
	    	@Override
	    	public void insertUpdate(DocumentEvent e) {
	        }

	            @Override
	            public void removeUpdate(DocumentEvent e) {
	            }

	            @Override
	            public void changedUpdate(DocumentEvent e) {
	            }
	    });
	    
	    btnLoc.addActionListener(new ActionListener() {
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {			
	    		Object o = e.getSource();
	    		if(o.equals(btnLoc)) {
	    			searchAndFilterItems(textField.getText());
	    		}
	    	}
	    });
		
		btnHuyLoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object o = e.getSource();
		    	if(o.equals(btnHuyLoc)) {
		    		comboBoxSDT.removeAllItems();
		    		KhachHang_DAO kh_dao = new KhachHang_DAO();
		    		for (KhachHang kh : kh_dao.getAllKhachHang()) {
		    			comboBoxSDT.addItem(kh.getSoDienThoai());
		    		}		    		
					textFieldMaKH.setText("");
					textFieldHoTen.setText("");
					textFieldGioiTinh.setText("");
					textFieldDiaChi.setText("");	
					comboBoxSDT.setSelectedItem(null);
		    	}
			}
		});
		
		btnTaoHD.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnTaoHD)) {
		    		dataSanPham();
		        	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		        	Date date = new Date();
		        	textFieldNgayLapHD.setText(dateFormat.format(date));
		        	textFieldTenNV.setText("Hồ Vĩnh Duy");
		        	textFieldMaNV.setText("NV213131310001");
		    		textFieldMaHD.setText(taoMaHoaDonMoi());
		    		textFieldTimTheoTen.setEnabled(true);
		    		textFieldTimTheoTen.setEditable(true);
		    		comboBoxKichThuoc.setEnabled(true);
		    		textFieldSoLuong.setEnabled(true);
		    		textFieldSoLuong.setEditable(true);
		    		textFieldTimTheoMa.setEnabled(true);
		    		textFieldTimTheoMa.setEditable(true);
		    		btnThemSP.setEnabled(true);
		    		btnXoaSP.setEnabled(true);
		    		btnThanhToan.setEnabled(true);
		    		btnHuyHD.setEnabled(true);
		    		btnTaoHD.setEnabled(false);
		        }	
			}
		});
		
		btnHuyHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnHuyHD)) {
		    		int r = tableSanPham.getRowCount();
		    		for (int i = 0; i < r; i++) {
						modelSanPham.removeRow(0);
					}
		    		int r1 = tableHoaDon.getRowCount();
		    		for (int i = 0; i < r1; i++) {
						modelHoaDon.removeRow(0);
					}
		        	textFieldNgayLapHD.setText("");
		        	textFieldTenNV.setText("");
		        	textFieldMaNV.setText("");
		    		textFieldMaHD.setText("");
		    		textFieldTimTheoTen.setEnabled(false);
		    		textFieldTimTheoTen.setEditable(false);
		    		comboBoxKichThuoc.setEnabled(false);
		    		textFieldSoLuong.setEnabled(false);
		    		textFieldSoLuong.setEditable(false);
		    		textFieldTimTheoMa.setEnabled(false);
		    		textFieldTimTheoMa.setEditable(false);
		    		textFieldTongTien.setText("");
		    		btnThemSP.setEnabled(false);		    		
		    		btnXoaSP.setEnabled(false);
		    		btnThanhToan.setEnabled(false);
		    		btnHuyHD.setEnabled(false);
		    		btnTaoHD.setEnabled(true);
		        }	
				
			}
		});
		
		comboBoxKichThuoc.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					SanPham_SizeS_Dao sps_dao = new SanPham_SizeS_Dao();
					int row = tableSanPham.getSelectedRow();
					String maSP = modelSanPham.getValueAt(row, 0).toString();
					for (SanPham_Sizes sps : sps_dao.getAllSanPham_SizesByIdSP(maSP)) {
						if(comboBoxKichThuoc.getSelectedItem().toString().equalsIgnoreCase(sps.getSizes().getTenSize())) {
							textFieldSoLuong.setText(sps.getSoLuong() + "");
						}
					}
				}
				
			}
		});
		
		comboBoxSapXep.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String selectedItem = comboBoxSapXep.getSelectedItem().toString();
					final HoaDon_Dao hd_dao = new HoaDon_Dao();
					ArrayList<HoaDon> ls = hd_dao.getAllHoaDon();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					int row = tableHDDaLap.getRowCount();
					for (int i = 0; i < row; i++) {
						modelHDDaLap.removeRow(0);
					}
					switch (selectedItem) {
						case "ngày lập hoá đơn tăng":
							Collections.sort(ls, new Comparator<HoaDon>() {
							    public int compare(HoaDon o1, HoaDon o2) {
							        return (o1.getNgayLapHoaDon().compareTo(o2.getNgayLapHoaDon()));
							    }
							});
							break;
						case "ngày lập hoá đơn giảm":
							Collections.sort(ls, new Comparator<HoaDon>() {
							    public int compare(HoaDon o1, HoaDon o2) {
							        return (o2.getNgayLapHoaDon().compareTo(o1.getNgayLapHoaDon()));
							    }
							});
							break;
						case "tổng tiền tăng":
							Collections.sort(ls, new Comparator<HoaDon>() {
							    public int compare(HoaDon o1, HoaDon o2) {
							        return hd_dao.getTongTienHDByIdHD(o1.getMaHoaDon()).compareTo(hd_dao.getTongTienHDByIdHD(o2.getMaHoaDon()));
							    }
							});
							break;
						case "tổng tiền giảm":
							Collections.sort(ls, new Comparator<HoaDon>() {
							    public int compare(HoaDon o1, HoaDon o2) {
							        return hd_dao.getTongTienHDByIdHD(o2.getMaHoaDon()).compareTo(hd_dao.getTongTienHDByIdHD(o1.getMaHoaDon()));
							    }
							});
							break;
						default:
							
							break;
					}
					
					for(HoaDon hd: ls) {
						Double tongTien = hd_dao.getTongTienHDByIdHD(hd.getMaHoaDon());
						String rowData[] = {
								hd.getMaHoaDon(), hd.getKhachHang().getMaKhachHang(), hd.getKhachHang().getHoTen(), hd.getKhachHang().getSoDienThoai(), 
								hd.getNhanVien().getTenNhanVien(),dateFormat.format(hd.getNgayLapHoaDon()), tongTien+""};
						modelHDDaLap.addRow(rowData);
					}
				}
			}
		});
		
		btnThemSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnThemSP)) {
		    		int soLuongChon = Integer.parseInt(textFieldSoLuong.getText());
					int row = tableSanPham.getSelectedRow();
					SanPham_SizeS_Dao sps_dao = new SanPham_SizeS_Dao();
					SanPham_Sizes sp_s = null;
					String size = comboBoxKichThuoc.getSelectedItem().toString();
					String maSP = modelSanPham.getValueAt(row, 0).toString();
					for (SanPham_Sizes sps : sps_dao.getAllSanPham_SizesByIdSP(maSP)) {
						if(size.equalsIgnoreCase(sps.getSizes().getTenSize())) {
							sp_s = new SanPham_Sizes(sps.getSizes(), sps.getSanPham(), sps.getSoLuong());
						}
					}
					
					
					if(soLuongChon > sp_s.getSoLuong() || soLuongChon <= 0) {
						JOptionPane.showMessageDialog(null, "Không đủ số lượng");
					}else {
						double giaBan = sp_s.getSanPham().getGiaBan();
						double vat = giaBan * 0.1;
						double tongTien = (vat + giaBan) * soLuongChon;
						String formatted = String.format("%.0f", tongTien );
				        Locale locale = new Locale("vi", "VN");
				        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//				        currencyFormat.format()
						ChiTietHoaDon cthd = new ChiTietHoaDon(textFieldMaHD.getText(), maSP, soLuongChon, sp_s.getSizes().getTenSize(), sp_s.getSanPham().getGiaBan());
						ls_cthd.add(cthd);
						String dataRow[] = {sp_s.getSanPham().getTenSanPham(), sp_s.getSanPham().getMauSac(), currencyFormat.format(giaBan)+"",
								sp_s.getSizes().getTenSize(), soLuongChon + "", currencyFormat.format(vat) + "", currencyFormat.format(Double.parseDouble(formatted)) + ""};
						modelHoaDon.addRow(dataRow);
					}
		        }	
			}
		});
		
		
		
		btnThanhToan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnThanhToan)) {
		    		KhachHang_DAO kh_dao = new KhachHang_DAO();	
		    		if(comboBoxSDT.getSelectedItem() != null) {
		    			if(ls_cthd.size() > 0) {
		    				ViewThanhToan viewTT = new ViewThanhToan(textFieldMaHD.getText(), ls_cthd , kh_dao.getKhachHangById(textFieldMaKH.getText()), textFieldTongTien.getText());
		    				viewTT.setLocationRelativeTo(null);
		    				viewTT.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    				viewTT.setVisible(true);
		    				viewTT.setResizable(false);		    					    				
		    			}else {
		    				JOptionPane.showConfirmDialog(null, "Chưa chọn sản phẩm nào");
		    			}
		    		}else 
		    			JOptionPane.showConfirmDialog(null, "Chưa chọn khách hàng");
		        }
			}
		});
		
		btnXoaSP.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnXoaSP)) {
		    		int r = tableHoaDon.getSelectedRow();
		    		if(r >= 0 ) {
		    			ls_cthd.remove(r);
		    			modelHoaDon.removeRow(r);
		    		}else
		    			JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xoá");
		        }
			}
		});
		
		textField_TimTheoSDT.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchBySDTKH();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchBySDTKH();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		textField_TimTheoTen.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchByNameKH();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchByNameKH();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		textFieldTimTheoTen.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchByNameSP();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchByNameSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		textFieldTimTheoMa.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchByIDSP();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchByIDSP();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		comboBoxSDT.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String sdt = comboBoxSDT.getSelectedItem().toString();
					if(sdt.length() == 10) {
						KhachHang_DAO kh_dao = new KhachHang_DAO();
						KhachHang kh = kh_dao.getKhachHangBySDT(sdt);
						textFieldMaKH.setText(kh.getMaKhachHang());
						textFieldHoTen.setText(kh.getHoTen());
						if(kh.isGioiTinh() == true) 
							textFieldGioiTinh.setText("Nam");
						else
							textFieldGioiTinh.setText("Nữ");
						textFieldDiaChi.setText(kh.getDiaChi());						
					}

				}
				
			}
		});
	 	
		btnXoaHD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnXoaHD)) {
		    		int row = tableHDDaLap.getSelectedRow(); 
					if(row >= 0) {	
						String maHD = modelHDDaLap.getValueAt(row, 0).toString();
			    		HoaDon_Dao hd_dao = new HoaDon_Dao();
			    		hd_dao.deleteHoaDon(maHD);
			    		modelHDDaLap.removeRow(row);
					}else {
						JOptionPane.showConfirmDialog(null, "Chưa chọn dòng để xoá");
					}
		    	}
			}
		});
		
		btnThongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
		    	if(o.equals(btnThongKe)) {
    				HoaDon_Dao hd_dao = new HoaDon_Dao();
    				int soHoaDon = 0;
    				Double tongTien = 0.0;
    				Double tongVat = 0.0;
    				Double tongLoiNhuan = 0.0;
    		        Locale locale = new Locale("vi", "VN");
    		        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		    		if(comboBoxThongKe.getSelectedItem().toString().equalsIgnoreCase("Thống kê theo năm")) {		
		    			if(comboBoxNam.getSelectedItem() != null) {
		    				int year = Integer.parseInt(comboBoxNam.getSelectedItem().toString());
		    				for (HoaDon hd : hd_dao.getAllHoaDonByYear(year)) {
		    					Double tongTien1 = hd_dao.getTongTienHDByIdHD(hd.getMaHoaDon());
								soHoaDon += 1;
								tongTien += tongTien1;
								tongVat += tongTien1 * 0.112;
								tongLoiNhuan += tongTien1 * 0.232;
							}
		    			}else {
		    				JOptionPane.showMessageDialog(null, "Chọn năm cần thống kê");
		    			}
		    		}else if(comboBoxThongKe.getSelectedItem().toString().equalsIgnoreCase("Thống kê theo quý")) {
		    			if(comboBoxNam.getSelectedItem() != null && comboBoxQuy.getSelectedItem() != null) {
		    				int year = Integer.parseInt(comboBoxNam.getSelectedItem().toString());
		    				int quy = Integer.parseInt(comboBoxQuy.getSelectedItem().toString());
		    				for (HoaDon hd : hd_dao.getAllHoaDonByQuarterAndYear(quy, year)) {
		    					Double tongTien1 = hd_dao.getTongTienHDByIdHD(hd.getMaHoaDon());
								soHoaDon += 1;
								tongTien += tongTien1;
								tongVat += tongTien1 * 0.112;
								tongLoiNhuan += tongTien1 * 0.232;
							}
		    			}else {
		    				JOptionPane.showMessageDialog(null, "Chọn quý và năm cần thống kê");
		    			}
		    		}else {
		    			if(comboBoxNam.getSelectedItem() != null && comboBoxThang.getSelectedItem() != null) {
		    				int year = Integer.parseInt(comboBoxNam.getSelectedItem().toString());
		    				int thang = Integer.parseInt(comboBoxThang.getSelectedItem().toString());
		    				for (HoaDon hd : hd_dao.getAllHoaDonByMonthAndYear(thang, year)) {
		    					Double tongTien1 = hd_dao.getTongTienHDByIdHD(hd.getMaHoaDon());
								soHoaDon += 1;
								tongTien += tongTien1;
								tongVat += tongTien1 * 0.112;
								tongLoiNhuan += tongTien1 * 0.232;
							}
		    			}else {
		    				JOptionPane.showMessageDialog(null, "Chọn tháng và năm cần thống kê");
		    			}
		    		}
		    		textFieldSoHD.setText(soHoaDon+" đơn");
		    		txtTongTien.setText(currencyFormat.format(tongTien));
		    		txtTongLoiNhuan.setText(currencyFormat.format(tongLoiNhuan));
		    		txtTongVat.setText(currencyFormat.format(tongVat));
		        }
				
			}
		});
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabbedPane.getSelectedIndex();
				if(selectedIndex == 1) {
					int rowCount = tableHDDaLap.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						modelHDDaLap.removeRow(0);
					}
					dataHoaDon();
				}
			}
		});
	}
	
	public void dataSanPham() {
		SanPham_Dao sp_dao = new SanPham_Dao();
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		for (SanPham sp : sp_dao.getAllSanPham()) {
			String row[] = {sp.getMaSanPham(), sp.getTenSanPham(), sp.getMoTa(), sp.getMauSac(), sp.getXuatXu(), currencyFormat.format(sp.getGiaBan()), 
					sp.getNhaCungCap().getTenNhaCungCap()};
			
			modelSanPham.addRow(row);
		}
	}
	
	public void dataHoaDon() {
		HoaDon_Dao hd_dao = new HoaDon_Dao();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for(HoaDon hd: hd_dao.getAllHoaDon()) {
			Double tongTien = hd_dao.getTongTienHDByIdHD(hd.getMaHoaDon());
			String row[] = {
					hd.getMaHoaDon(), hd.getKhachHang().getMaKhachHang(), hd.getKhachHang().getHoTen(), hd.getKhachHang().getSoDienThoai(), 
					hd.getNhanVien().getTenNhanVien(),dateFormat.format(hd.getNgayLapHoaDon()), tongTien+""};
			modelHDDaLap.addRow(row);
		}
	}
	
	private void loadDataByName(String ten) {
		SanPham_Dao sp_dao = new SanPham_Dao();
        Locale locale = new Locale("vi", "VN");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        for (SanPham sp : sp_dao.getAllSanPham()) {
            if (sp.getTenSanPham().toLowerCase().contains(ten.toLowerCase())) {
    			String row[] = {sp.getMaSanPham(), sp.getTenSanPham(), sp.getMoTa(), sp.getMauSac(), sp.getXuatXu(), currencyFormat.format(sp.getGiaBan()), 
    					sp.getNhaCungCap().getTenNhaCungCap()};
    			modelSanPham.addRow(row);
            }
        }
	}
	
	private KhachHang getKhachHangBySDT(String sdt) {
		KhachHang_DAO kh_dao = new KhachHang_DAO();
		for (KhachHang kh : kh_dao.getAllKhachHang()) {
			if(kh.getSoDienThoai().equalsIgnoreCase(sdt)) {
				return kh;
			}
		}
		return null; 
	}
	
	private String gethinhAnh(String maSP) {
		SanPham_Dao sp_dao = new SanPham_Dao();
		for (SanPham sp : sp_dao.getAllSanPham()) {
			if(sp.getMaSanPham().equalsIgnoreCase(maSP))
				return sp.getHinhAnh();
		}
		return null;
	}
	
    public static String maTuDong(int countHDInDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String timestamp = dateFormat.format(date);
        countHDInDay++;
        String invoiceNumber = "HD" + timestamp + String.format("%04d", countHDInDay);
        return invoiceNumber;
    }
    
    public static String taoMaHoaDonMoi() {
    	Date date = new Date();
    	HoaDon_Dao hd_dao = new HoaDon_Dao();
    	int soHD = hd_dao.getAllHoaDonByDate(date).size();
    	return maTuDong(soHD);
    }
    
	private void searchByNameKH() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) tableHDDaLap
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String nameToSearch = textField_TimTheoTen.getText();

		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 2)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}
	
	private void searchBySDTKH() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) tableHDDaLap
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String nameToSearch = textField_TimTheoSDT.getText();

		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 3)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}
	
    private void searchAndFilterItems(String searchText) {
    	boolean check = false;
    	comboBoxSDT.removeAllItems();
    	KhachHang_DAO kh_dao = new KhachHang_DAO();
        if (searchText.trim().isEmpty()) {
            for (KhachHang kh : kh_dao.getAllKhachHang()) {
            	comboBoxSDT.addItem(kh.getSoDienThoai());
            }
        } else {
            for (KhachHang kh : kh_dao.getAllKhachHang()) {
                if (kh.getSoDienThoai().toLowerCase().startsWith(searchText.toLowerCase())) {
                	comboBoxSDT.addItem(kh.getSoDienThoai());
                	check = true;
                }
            }
            if(check == false) {
            	comboBoxSDT.setSelectedItem(searchText);
            }
        }
    }
    
	private void searchByNameSP() {
		DefaultRowSorter<DefaultTableModel, Integer> sorterSanPham = (DefaultRowSorter<DefaultTableModel, Integer>) tableSanPham
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorterSanPham;
		String nameToSearch = textFieldTimTheoTen.getText();
		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 1)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}
	
	private void searchByIDSP() {
		DefaultRowSorter<DefaultTableModel, Integer> sorterSanPham = (DefaultRowSorter<DefaultTableModel, Integer>) tableSanPham
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorterSanPham;
		String nameToSearch = textFieldTimTheoMa.getText();
		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 0)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}
}

