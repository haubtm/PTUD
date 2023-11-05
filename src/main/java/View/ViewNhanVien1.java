package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import DAO.Account_DAO;
import DAO.NhanVien_DAO;
import Entity.Account;
import Entity.NhanVien;

public class ViewNhanVien1 extends JFrame {
	private Color colorMenu = new Color(27, 64, 31);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtTimTen;
	private JTextField txtTimCC;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtCanCuoc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ViewNhanVien1 frame = new ViewNhanVien1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public ViewNhanVien1() {
		JDateChooser dateChooser = new JDateChooser();
		final NhanVien_DAO nhanVienDao = new NhanVien_DAO();
		List<NhanVien> nhanViens = nhanVienDao.getAllNhanVien();
		final Account_DAO acc_dao = new Account_DAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		panel_1.setBounds(0, 87, 199, 613);
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

		final JButton btnHoaDon = new JButton("Hoá Đơn");
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(0, 325, 199, 35);
		panel_1.add(btnHoaDon);
		btnHoaDon.setBackground(colorMenu);
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFocusPainted(false);

		JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhanVien.setBounds(0, 370, 199, 35);
		panel_1.add(btnNhanVien);
		btnNhanVien.setForeground(Color.BLACK);
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

		// tab menu khách hàng
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_khachHang = new JPanel();
		tabbedPane.addTab("Nhân Viên", null, panel_khachHang, null);

		// tab menu thống kê ------------------------------------------------------------------------------------
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_thongKe = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel_thongKe, null);
		panel_thongKe.setLayout(null);
	

		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBounds(46, 65, 121, 28);
		panel_thongKe.add(btnThongKe);
		JButton btnXuatThongKe = new JButton("Xuất thống kê");
		btnXuatThongKe.setBounds(810, 15, 121, 28);
		panel_thongKe.add(btnXuatThongKe);
		
		JPanel panel_ngay = new JPanel();
		panel_ngay.setBounds(531, 65, 141, 42);
		panel_thongKe.add(panel_ngay);
		panel_ngay.setLayout(null);
		
		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNam.setBounds(10, 4, 51, 24);
		panel_ngay.add(lblNam);
		
		// table thống kê
		String row[] = { "Mã Nhân Viên", "Tên Nhân Viên", "Hóa đơn đã lập","Giới tính" };
		model = new DefaultTableModel(row, 0);

		// xét màu cho hàng
		table = new JTable(model) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				return component;
			}
		};

		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 125, 432, 377);
		panel_thongKe.add(scrollPane);
		
		JComboBox cbxNam = new JComboBox();
		for (int i = 2000; i < 2024; i++) {
			cbxNam.addItem(i);
		}
		cbxNam.setBounds(60, 6, 81, 22);
		panel_ngay.add(cbxNam);
		
		JPanel panel_ngay_1 = new JPanel();
		panel_ngay_1.setLayout(null);
		panel_ngay_1.setBounds(372, 65, 141, 42);
		panel_thongKe.add(panel_ngay_1);
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThang.setBounds(10, 4, 51, 24);
		panel_ngay_1.add(lblThang);
		
		JComboBox cbxThang = new JComboBox();
		cbxThang.setBounds(60, 6, 81, 22);
		for (int i = 0; i < 13; i++) {
			cbxThang.addItem(i);
		}
		panel_ngay_1.add(cbxThang);
		panel_ngay_1.add(cbxThang);
		
		// ngày
		JPanel panelNgay = new JPanel();
		panelNgay.setLayout(null);
		panelNgay.setBounds(211, 65, 141, 42);
		panel_thongKe.add(panelNgay);
		
		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgay.setBounds(10, 4, 51, 24);
		panelNgay.add(lblNgay);
		
		JComboBox cbxNgay = new JComboBox();
		cbxNgay.setBounds(60, 6, 81, 22);
		for (int i = 0; i < 32; i++) {
			cbxNgay.addItem(i);
		}
		panelNgay.add(cbxNgay);
		
		// biểu đồ
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart("Biểu đồ Hình Khối", "Danh mục", "Phần trăm", dataset,
		        PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// Tạo trục Y và đặt giới hạn từ 0% đến 100% với khoảng cách 10%
		NumberAxis yAxis = new NumberAxis("Phần trăm");
		yAxis.setRange(0, 100);
		yAxis.setTickUnit(new NumberTickUnit(10));

		ChartPanel chartPanel = new ChartPanel(chart);
		
		// xuất theo năm
	
//		btnThongKe.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        int nam = (int) cbxNam.getSelectedItem();
//		        int thang = (int) cbxThang.getSelectedItem();
//		        int ngay = (int) cbxNgay.getSelectedItem();
//		        HoaDon_DAO hoaDonDAO = new HoaDon_DAO();
//		        List<NhanVien> danhSachNhanVien = new ArrayList<>();
//		        model.setRowCount(0); // Xóa dữ liệu cũ trong bảng
//		        dataset.clear(); // Xóa dữ liệu cũ trong dataset
//		        
//				int soLuongCucBo = 0;
//		        if(ngay != 0 && thang != 0 ) {
//		        	int soLuong = 0;
//		        	danhSachNhanVien = hoaDonDAO.getNhanVienNhieuHoaDonNhatTheoNgay(nam, thang, ngay);
//		            soLuongCucBo = soLuong;
//		            System.out.println("Tổng số hóa đơn theo ngày bên view trong if: " + soLuongCucBo);
//		            System.out.println("Giá trị ngay: " + ngay);
//		            System.out.println("Giá trị thang: " + thang);
//	            }
//		        
//		        for (NhanVien nhanVien : danhSachNhanVien) {
//		            String tenNhanVien = hoaDonDAO.getTenNhanVienFromMaNhanVien(nhanVien.getMaNhanVien());
//		            String chuyenDoiGT = "";
//		            if (nhanVien.isGioiTinh() == false) {
//		                chuyenDoiGT = "Nam";
//		            } else {
//		                chuyenDoiGT = "Nữ";
//		            }
//		            System.out.println("mã nhân viên: "+nhanVien.getMaNhanVien());
//		            System.out.println("tên nhân viên: "+tenNhanVien);
//		            System.out.println("số lượng cb: "+soLuongCucBo);
//		            System.out.println("chuyển đổi gt: "+chuyenDoiGT);
//		            model.addRow(new Object[] { nhanVien.getMaNhanVien(), tenNhanVien, soLuongCucBo, chuyenDoiGT });
//		        }
//
//		        for (NhanVien nhanVien : danhSachNhanVien) {
//		        	soLuongCucBo = hoaDonDAO.getSoLuongHoaDonTheoNam(nhanVien.getMaNhanVien(), nam);
//		            String tenNhanVien = hoaDonDAO.getTenNhanVienFromMaNhanVien(nhanVien.getMaNhanVien());
//		            double tyLePhanTram = ((double) soLuongCucBo / 1000) * 100;
//		            dataset.addValue(tyLePhanTram, "Nhân viên", tenNhanVien);
//		        }
//		        chartPanel.setChart(chart);
//		        chartPanel.repaint();
//		    }
//		});
		
	


		
		JPanel panel_Chart = new JPanel();
		panel_Chart.setBounds(516, 125, 439, 377);
		panel_thongKe.add(panel_Chart);
		panel_khachHang.setLayout(null);
        panel_Chart.removeAll(); // Xóa biểu đồ cũ trước khi thêm biểu đồ mới
        panel_Chart.add(chartPanel);
        panel_Chart.revalidate();
        panel_Chart.repaint();
		panel_Chart.add(chartPanel);

//				// title danh sách
				JLabel lblNewLabel_3 = new JLabel("Bảng danh sách hóa đơn đã lập");
				lblNewLabel_3.setForeground(new Color(220, 20, 60));
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_3.setBounds(137, 518, 202, 28);
				panel_thongKe.add(lblNewLabel_3);
				panel_khachHang.setLayout(null);
		
		
		
		////////////////////////////////////////////////////////////////////////-----------------------------------/////////////////

		// button them xoa sua
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(21, 19, 100, 30);
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 0));
		panel_khachHang.add(btnAdd);

		// chooose filter
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(224, 23, 154, 22);
		panel_khachHang.add(comboBox);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(172, 27, 38, 14);
		panel_khachHang.add(lblLoc);
		String[] filter = { "Lọc nhân viên", "Nhân viên quản lí", "Nhân viên part-time", "Nhân viên full-time" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}
		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setBounds(408, 26, 92, 14);
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_khachHang.add(lblFindName);

		txtTimTen = new JTextField();
		txtTimTen.setBounds(510, 25, 146, 20);
		txtTimTen.setColumns(10);

		txtTimTen.setBackground(null);
		Border border = txtTimTen.getBorder();
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		txtTimTen.setBorder(newBorder);
		panel_khachHang.add(txtTimTen);
		// label tìm mã
		JLabel lblFindSDT = new JLabel("Tìm theo CMND");
		lblFindSDT.setBounds(666, 26, 112, 14);
		lblFindSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_khachHang.add(lblFindSDT);

		txtTimCC = new JTextField();
		txtTimCC.setBounds(776, 29, 146, 20);
		txtTimCC.setColumns(10);
		txtTimCC.setBackground(null);
		Border border1 = txtTimCC.getBorder();
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		txtTimCC.setBorder(newBorder1);
		panel_khachHang.add(txtTimCC);

		JPanel panel_NhapTT = new JPanel();
		panel_NhapTT.setBounds(10, 75, 938, 127);
		panel_khachHang.add(panel_NhapTT);
		Border borderNV = BorderFactory.createLineBorder(java.awt.Color.BLACK, 3);
		panel_NhapTT.setBorder(borderNV);
		panel_NhapTT.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(827, 11, 89, 31);
		panel_NhapTT.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(827, 47, 89, 31);
		panel_NhapTT.add(btnXoa);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(827, 85, 89, 31);
		panel_NhapTT.add(btnSua);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên");
		lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNV.setBounds(30, 19, 116, 23);
		panel_NhapTT.add(lblMaNV);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(172, 16, 150, 20);
		panel_NhapTT.add(txtMaNV);
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaNV.setColumns(10);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên");
		lblTenNV.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNV.setBounds(30, 58, 116, 23);
		panel_NhapTT.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(172, 55, 150, 20);
		txtTenNV.setEditable(false);
		panel_NhapTT.add(txtTenNV);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setBounds(30, 93, 116, 23);
		panel_NhapTT.add(lblChucVu);

		final JComboBox chucVu = new JComboBox();
		chucVu.setBounds(172, 90, 150, 20);
		panel_NhapTT.add(chucVu);
		String[] cv = { "Nhân viên quản lí", "Nhân viên part-time", "Nhân viên full-time" };
		for (String choice : cv) {
			chucVu.addItem(choice);
		}
		chucVu.setEditable(false);
		chucVu.setEnabled(false);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(350, 19, 116, 23);
		panel_NhapTT.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(479, 16, 150, 20);
		txtDiaChi.setEditable(false);
		panel_NhapTT.add(txtDiaChi);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSDT.setBounds(350, 58, 116, 23);
		panel_NhapTT.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setEditable(false);
		txtSDT.setBounds(479, 52, 150, 20);
		panel_NhapTT.add(txtSDT);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioiTinh.setBounds(639, 50, 75, 23);
		panel_NhapTT.add(lblGioiTinh);

		final JRadioButton rdbNam = new JRadioButton("Nam");
		rdbNam.setBounds(715, 51, 55, 23);
		panel_NhapTT.add(rdbNam);

		final JRadioButton rdbNu = new JRadioButton("Nữ");
		rdbNu.setBounds(772, 51, 49, 23);
		panel_NhapTT.add(rdbNu);
		rdbNam.setEnabled(false);
		rdbNu.setEnabled(false);
		ButtonGroup gioiTinhNV = new ButtonGroup();
		gioiTinhNV.add(rdbNu);
		gioiTinhNV.add(rdbNam);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgaySinh.setBounds(639, 14, 75, 23);
		panel_NhapTT.add(lblNgaySinh);

		final JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(715, 22, 104, 20);
		dateChooser1.setEnabled(false);
		panel_NhapTT.add(dateChooser1);

		JLabel lblCanCuoc = new JLabel("Căn cước");
		lblCanCuoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCanCuoc.setBounds(350, 88, 81, 23);
		panel_NhapTT.add(lblCanCuoc);

		txtCanCuoc = new JTextField();
		txtCanCuoc.setColumns(10);
		txtCanCuoc.setBounds(479, 90, 150, 20);
		txtCanCuoc.setEditable(false);
		panel_NhapTT.add(txtCanCuoc);

		JButton btnTaoNV = new JButton("Tạo NV");
		btnTaoNV.setBounds(736, 85, 81, 31);
		panel_NhapTT.add(btnTaoNV);

		final JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBounds(639, 85, 81, 31);
		panel_NhapTT.add(btnXacNhan);

		// tạo nhân viên
		btnTaoNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taoMa = generateNhanVienID();
				txtMaNV.setText(taoMa);
				txtTenNV.setEditable(true);
				txtDiaChi.setEditable(true);
				txtSDT.setEditable(true);
				txtCanCuoc.setEditable(true);
				chucVu.setEditable(true);
				chucVu.setEnabled(true);
				rdbNam.setEnabled(true);
				rdbNu.setEnabled(true);
				dateChooser1.setEnabled(true);
				txtTenNV.setText("");
				txtSDT.setText("");
				txtDiaChi.setText("");
				txtCanCuoc.setText("");
			}
		});

		// phần bảng nhân viên
		table.setBounds(10, 152, 938, 270);
		
		JLabel lblTitle = new JLabel("Thống kê nhân viên xuất sắc");
		lblTitle.setForeground(new Color(0, 153, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(411, 15, 328, 35);
		panel_thongKe.add(lblTitle);
		
		String[] columnNames = { "Mã NV", "Tên NV", "Ngày sinh", "Giới tính", "Căn cước", "SDT", "Địa chỉ", "Chức vụ",
				"Hình ảnh" };
		final DefaultTableModel modelNV = new DefaultTableModel(columnNames, 0);
		table = new JTable(modelNV) {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				// Đặt màu nền cho các dòng (trừ header)
				if (!isRowSelected(row)) {
					component.setBackground(row % 2 == 1 ? Color.WHITE : Color.LIGHT_GRAY); // Màu nền xen kẽ
				}
				return component;
			}
		};

		for (NhanVien nhanVien : nhanViens) {
			boolean gioiTinhValue = nhanVien.isGioiTinh();
			String gioiTinh1;
			if (gioiTinhValue == true) {
				gioiTinh1 = "Nam";
			} else {
				gioiTinh1 = "Nữ";
			}
			String selectedChucVu = "";
			selectedChucVu = nhanVien.getChucVu();
			Date ngaySinh = nhanVien.getNgaySinh();
			dateChooser1.setDate(ngaySinh);
			modelNV.addRow(new Object[] { nhanVien.getMaNhanVien(), nhanVien.getTenNhanVien(), ngaySinh, gioiTinh1,
					nhanVien.getCanCuoc(), nhanVien.getSoDienThoai(), nhanVien.getDiaChi(), selectedChucVu });
		}
		JScrollPane newScrollPane = new JScrollPane(table);
		newScrollPane.setBounds(10, 255, 938, 299);
		panel_khachHang.add(newScrollPane);

		JButton btnXemAccount = new JButton("Account");
		btnXemAccount.setBounds(21, 213, 89, 31);
		panel_khachHang.add(btnXemAccount);

		table.setDefaultEditor(Object.class, null); // không cho phép chỉnh sửa trong bảng
		// click vào bảng cập nhật dữ liệu lên text
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow1 = table.getSelectedRow();
				if (selectedRow1 != -1) {
					String maNV = (String) table.getValueAt(selectedRow1, 0);
					String hoTen = (String) table.getValueAt(selectedRow1, 1);
					Date ngaySinh = (Date) table.getValueAt(selectedRow1, 2);
					String gioiTinh = (String) table.getValueAt(selectedRow1, 3);
					String canCuoc = (String) table.getValueAt(selectedRow1, 4);
					String sdt = (String) table.getValueAt(selectedRow1, 5);
					String diaChi = (String) table.getValueAt(selectedRow1, 6);
					String chucVu1 = (String) chucVu.getSelectedItem();
					txtMaNV.setText(maNV);
					txtTenNV.setText(hoTen);
					dateChooser1.setDate(ngaySinh);
					if (gioiTinh.equals("Nam")) {
						rdbNam.setSelected(true);
						rdbNu.setSelected(false);
					} else {
						rdbNam.setSelected(false);
						rdbNu.setSelected(true);
					}
					txtCanCuoc.setText(canCuoc);
					txtSDT.setText(sdt);
					txtDiaChi.setText(diaChi);
				}

				Object selectedChucVu = chucVu.getSelectedItem();
				if (selectedChucVu != null) {
					String chucVu = selectedChucVu.toString(); // Chuyển đối tượng đã chọn sang kiểu String
				}
			}
		});

		// thêm khách hàng
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maNhanVien = txtMaNV.getText();
				String hoTen = txtTenNV.getText();
				Date ngaySinh = dateChooser1.getDate();
				boolean gioiTinh = false;
				if (rdbNam.isSelected()) {
					gioiTinh = true;
				} else {
					gioiTinh = false;
				}

				String canCuoc = txtCanCuoc.getText();
				String sdt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				String chucVuValue = (String) chucVu.getSelectedItem();
				String hinhAnh = null;

				if (txtTenNV.getText().matches(".*[0-9\\W]+.*")) {
					JOptionPane.showMessageDialog(null, "Tên chỉ được chứa chữ cái.");
				}

				if (!txtCanCuoc.getText().matches("^[0-9]{8}$")) {
					JOptionPane.showMessageDialog(null, "Căn cước chỉ có 8 số.");
				}
				if (!txtSDT.getText().matches("^[0-9]{8}$")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại chỉ có 8 số.");
				}
				if (!txtDiaChi.getText().matches("^[a-zA-Z0-9 ]+$")) {
					JOptionPane.showMessageDialog(null, "Số điện thoại chỉ có 8 số.");
				}

				if (txtMaNV.getText().equals("") || txtTenNV.getText().equals("") || txtCanCuoc.getText().equals("")
						|| txtDiaChi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa nhập đủ dữ liệu");
				} else {
					NhanVien nv = new NhanVien(maNhanVien, hoTen, ngaySinh, gioiTinh, canCuoc, sdt, diaChi, chucVuValue,
							hinhAnh);
					nhanVienDao.addNhanVien(nv);
					modelNV.addRow(new Object[] { maNhanVien, hoTen, ngaySinh, gioiTinh ? "Nam" : "Nữ", canCuoc, sdt,
							diaChi, chucVu, hinhAnh });
					JOptionPane.showMessageDialog(scrollPane, "Thêm thành công");

					txtMaNV.setText("");
					txtTenNV.setText("");
					Date ngaySinh1 = null;
					if (rdbNam.isSelected()) {
						gioiTinh = true;
					}
					txtCanCuoc.setText("");
					txtSDT.setText("");
					txtDiaChi.setText("");
					chucVu.setSelectedIndex(0);
				}
				// lưu thông tin account
				String maTaiKhoan = generateAccountID();
				String userName = generateNameAccount();
				String password = "12345";
				String role = "nv";
				String maNV = maNhanVien;
				System.out.println("mã tài khoản" + maTaiKhoan);
				System.out.println("mã nhân viên" + maNV);
				Account acc = new Account(maTaiKhoan, userName, password, role, maNV);
				acc_dao.addAccount(acc);

			}
		});

		// xóa nhân viên
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?");
				if (confirm == JOptionPane.YES_OPTION) {
					String maNhanVien = txtMaNV.getText();
					// Xóa các bản ghi từ bảng TaiKhoan mà có maNhanVien tương ứng
					acc_dao.deleteAccountsByMaNhanVien(maNhanVien);
					// Sau khi xóa các tài khoản, bạn có thể tiếp tục xóa nhân viên
					nhanVienDao.deleteNhanVien(maNhanVien);
					DefaultTableModel modelNV = (DefaultTableModel) table.getModel();
					int rowIndex = table.getSelectedRow();
					if (rowIndex != -1) {
						modelNV.removeRow(rowIndex);
					}
				}
			}
		});

		// sửa nhân viên
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXacNhan.setEnabled(true);
				txtTenNV.setEditable(true);
				txtDiaChi.setEditable(true);
				txtSDT.setEditable(true);
				txtCanCuoc.setEditable(true);
				chucVu.setEditable(true);
				chucVu.setEnabled(true);
				rdbNam.setEnabled(true);
				rdbNu.setEnabled(true);
				dateChooser1.setEnabled(true);
			}
		});

		// Xác nhận sửa nhân viên
		btnXacNhan.setEnabled(false);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Kiểm tra nếu không có hàng nào được chọn thì không thực hiện sửa
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa.", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				String hoTen = txtTenNV.getText();
				Date ngaySinh = dateChooser1.getDate();
				boolean gioiTinh = rdbNam.isSelected();
				String canCuoc = txtCanCuoc.getText();
				String sdt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				String chucVu2 = chucVu.getSelectedItem().toString();
				String hinhAnh2 = null;
				String maNV = txtMaNV.getText();

				if (maNV.isEmpty() || hoTen.isEmpty() || ngaySinh == null || canCuoc.isEmpty() || sdt.isEmpty()
						|| diaChi.isEmpty() || chucVu.equals("Chức vụ")) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin nhân viên.", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				NhanVien nhanVien = new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, canCuoc, sdt, diaChi, chucVu2,
						hinhAnh2);
				nhanVienDao.updateNhanVien(nhanVien);
				DefaultTableModel modelNV = (DefaultTableModel) table.getModel();
				modelNV.setValueAt(hoTen, selectedRow, 1);
				modelNV.setValueAt(ngaySinh, selectedRow, 2);
				modelNV.setValueAt(gioiTinh ? "Nam" : "Nữ", selectedRow, 3);
				modelNV.setValueAt(canCuoc, selectedRow, 4);
				modelNV.setValueAt(sdt, selectedRow, 5);
				modelNV.setValueAt(diaChi, selectedRow, 6);
				modelNV.setValueAt(chucVu, selectedRow, 7);
				JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên thành công.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		// btn xem chi tiết account
		btnXemAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRowTableAccount = table.getSelectedRow();
				 if (selectedRowTableAccount != -1) {
			            String maNV = (String) table.getValueAt(selectedRowTableAccount, 0);
			            String hoTen = (String) table.getValueAt(selectedRowTableAccount, 1);
			            String role = chucVu.getSelectedItem().toString();
			            ViewAccount ac = new ViewAccount();
			            ac.setDataForAccount(maNV, hoTen,role); // Truyền dữ liệu từ nhân viên được chọn
			            ac.setLocationRelativeTo(null);
			            ac.setVisible(true);
			        }
			}
		});

		final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
		table.setRowSorter(sorter);

		/// search combobox
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFilter = (String) comboBox.getSelectedItem();

				if (selectedFilter != null && sorter != null) {

					if (selectedFilter.equals("Nhân viên quản lí")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nhân viên quản lí", 7));
					} else if (selectedFilter.equals("Nhân viên part-time")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nhân viên part-time", 7));
					} else if (selectedFilter.equals("Nhân viên full-time")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nhân viên full-time", 7));
					} else {
						sorter.setRowFilter(null); // Hủy bỏ bất kỳ bộ lọc nào
					}
				}
			}
		});

		// tìm theo căn cước nhân viên
		txtTimCC.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchCanCuoc();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchCanCuoc();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		// tìm theo tên khách hàng
		txtTimTen.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				searchByName();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				searchByName();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		// phần xử lí sự kiện
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnHoaDon)) {
					ViewHoaDon hd = new ViewHoaDon();
					hd.setLocationRelativeTo(null);
					hd.setVisible(true);
					dispose();
				}

			}
		});

		////
		btnSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnSanPham)) {
					ViewSanPham sp = new ViewSanPham();
					sp.setLocationRelativeTo(null);
					sp.setVisible(true);
					dispose();
				}

			}
		});

		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnKhachHang)) {
					ViewKhachHang sp = new ViewKhachHang();
					sp.setLocationRelativeTo(null);
					sp.setVisible(true);
					dispose();
				}

			}
		});
	}

	public static String generateNhanVienID() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String nhanVienID = "NV" + String.format("%04d", randomNumber);
		return nhanVienID;
	}

	private String generateNameAccount() {
		Random random = new Random();
		int randomInt = random.nextInt(1000); // Tạo số ngẫu nhiên từ 0 đến 999
		String accountID = "nv" + String.format("%03d", randomInt); // Đảm bảo rằng có 3 chữ số
		return accountID;
	}

	public static String generateAccountID() {
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);
		return String.valueOf(randomNumber);
	}

	// search của căn cước
	private void searchCanCuoc() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String textCanCuoc = txtTimCC.getText();
		if (textCanCuoc.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			rowSorter.setRowFilter(RowFilter.regexFilter(textCanCuoc, 4)); // Tìm kiếm trong cột "Mã Khách Hàng" (cột //
		}
	}

	// search của ten
	private void searchByName() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String nameToSearch = txtTimTen.getText();

		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 1)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}
}
