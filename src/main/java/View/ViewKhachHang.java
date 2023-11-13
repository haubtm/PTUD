package View;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import connectDB.ConnectDB;
import DAO.KhachHang_DAO;
import DAO.ThongKeKhachHang_DAO;
import Entity.DataThongKeKHTheoNam;
import Entity.DataThongKeKHTheoNgay;
import Entity.DataThongKeKHTheoThang;
import Entity.DataThongKeNhanVienNam;
import Entity.DataThongKeNhanVienThang;
import Entity.KhachHang;
import Entity.NhanVien;

public class ViewKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color colorMenu = new Color(27, 64, 31);
	private JTextField textFieldName;
	private JTextField textFindId;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTable table;
	private DefaultTableModel model;
	private JTable tableTK;
	private DefaultTableModel modelTK;
	private static int count = 1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectDB.getConnection();
					ViewKhachHang frame = new ViewKhachHang();
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
	public ViewKhachHang() {
		final KhachHang_DAO khachHangDAO = new KhachHang_DAO();
		List<KhachHang> khachHangs = khachHangDAO.getAllKhachHang();

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
		// tiêu đề trên
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
		// các button bên trái
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

		final JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhanVien.setBounds(0, 370, 199, 35);
		panel_1.add(btnNhanVien);
		btnNhanVien.setBackground(colorMenu);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFocusPainted(false);

		JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(0, 415, 199, 35);
		panel_1.add(btnKhachHang);
		btnKhachHang.setForeground(Color.BLACK);
		btnKhachHang.setFocusPainted(false);

		final JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSanPham.setBounds(0, 460, 199, 35);
		panel_1.add(btnSanPham);
		btnSanPham.setBackground(colorMenu);
		btnSanPham.setForeground(Color.WHITE);
		btnSanPham.setFocusPainted(false);

		// phần ảnh ảnh dại diện
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
		JPanel panel = new JPanel();
		tabbedPane.addTab("Khách Hàng ", null, panel, null);
		panel.setLayout(null);

		// tab menu thống kê
		// //////////////////////////////////////////////////////////////////
		JTabbedPane tabbedPane2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		JPanel panel_thongKe = new JPanel();
		tabbedPane.addTab("Thống kê", null, panel_thongKe, null);
		panel_thongKe.setLayout(null);

		JLabel lblSoLuongKH = new JLabel("Chọn số lượng cần lọc: ");
		lblSoLuongKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoLuongKH.setBounds(34, 75, 182, 22);
		panel_thongKe.add(lblSoLuongKH);

		final JComboBox cbxChoose = new JComboBox();
		cbxChoose.setBounds(221, 77, 56, 20);
		for (int i = 1; i < 11; i++) {
			cbxChoose.addItem(i);
		}
		panel_thongKe.add(cbxChoose);

		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setBackground(new Color(0, 255, 0));
		btnThongKe.setBounds(429, 76, 89, 23);
		panel_thongKe.add(btnThongKe);

		JButton btnXuatTK = new JButton("Xuất thống kê");
		btnXuatTK.setBackground(Color.GREEN);
		btnXuatTK.setBounds(813, 24, 127, 32);
		panel_thongKe.add(btnXuatTK);

		// table thống kê khách hàng
		String rowTK[] = { "Mã Khách Hàng", "Tên Khách Hàng ", "Sản phẩm đã mua", "Giới tính"};
		modelTK = new DefaultTableModel(rowTK, 0);
		// xét màu cho hàng
		tableTK = new JTable(modelTK) {
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

		JScrollPane scrollPane1 = new JScrollPane(tableTK);
		scrollPane1.setBounds(10, 110, 442, 426);
		panel_thongKe.add(scrollPane1);

		JLabel lblNewLabel_3 = new JLabel("Danh sách khách hàng có nhiều hóa đơn nhất");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(95, 540, 357, 22);
		panel_thongKe.add(lblNewLabel_3);

		JLabel txtThongKe = new JLabel("Thống kê theo");
		txtThongKe.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtThongKe.setBounds(34, 31, 110, 19);
		panel_thongKe.add(txtThongKe);

		JLabel lblNgay = new JLabel("Ngày");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgay.setBounds(177, 30, 42, 19);
		panel_thongKe.add(lblNgay);

		final JComboBox cbxNgay = new JComboBox();
		for (int i = 0; i < 32; i++) {
			cbxNgay.addItem(i);
		}
		cbxNgay.setBounds(221, 30, 56, 20);
		panel_thongKe.add(cbxNgay);

		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThang.setBounds(283, 30, 56, 19);
		panel_thongKe.add(lblThang);

		final JComboBox cbxThang = new JComboBox();
		for (int i = 0; i < 13; i++) {
			cbxThang.addItem(i);
		}
		cbxThang.setBounds(338, 30, 56, 20);
		panel_thongKe.add(cbxThang);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNam.setBounds(404, 30, 42, 19);
		panel_thongKe.add(lblNam);

		final JComboBox cbxNam = new JComboBox();
		for (int i = 2000; i < 2025; i++) {
			cbxNam.addItem(i);
		}
		cbxNam.setBounds(450, 30, 68, 20);
		panel_thongKe.add(cbxNam);

		// biểu đồ
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		final JFreeChart chart = ChartFactory.createBarChart("Biểu đồ Hình Khối", "Danh mục", "Phần trăm", dataset,
				PlotOrientation.VERTICAL, true, true, false);
		final ChartPanel chartPanel = new ChartPanel(chart);
		
		chartPanel.setBounds(455, 110, 513, 426);
		panel_thongKe.add(chartPanel);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 370));


		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nam = (int) cbxNam.getSelectedItem();
				int thang = (int) cbxThang.getSelectedItem();
				int ngay = (int) cbxNgay.getSelectedItem();
				int luaChon = (int) cbxChoose.getSelectedItem();
				ThongKeKhachHang_DAO thongKe = new ThongKeKhachHang_DAO();
				modelTK.setRowCount(0);
				dataset.clear(); // Xóa dữ liệu cũ trong dataset
				int soLuongCucBo = 0;
				if (ngay != 0 && thang != 0 && luaChon != 0) {
					
					DataThongKeKHTheoNgay thongTinNgay = thongKe.getKhachHangNhieuHoaDonNhatTheoNgay(nam, thang, ngay,
							soLuongCucBo,luaChon);
					List<KhachHang> danhSachKhachHang1 = thongTinNgay.getDanhSachKhachHang();
					for (KhachHang khachHang : danhSachKhachHang1) {
						int index = danhSachKhachHang1.indexOf(khachHang);
						int soLuongHoaDon = thongTinNgay.getSoLuongHoaDon(index);
						String tenKhachHang = thongKe.getTenKhachHangFromMaKhachHang(khachHang.getMaKhachHang());
						String chuyenDoiGT = "";
						if (khachHang.isGioiTinh() == false) {
							chuyenDoiGT = "Nam";
						} else {
							chuyenDoiGT = "Nữ";
						}
						modelTK.addRow(
								new Object[] { khachHang.getMaKhachHang(), tenKhachHang, soLuongHoaDon, chuyenDoiGT });
						
						double tyLePhanTram = ((double) soLuongHoaDon / 1000) * 100;
						dataset.addValue(tyLePhanTram, "Khách hàng", tenKhachHang);
					}
					chartPanel.setChart(chart);
					chartPanel.repaint();
					chart.fireChartChanged();
				} else if (ngay == 0 && thang != 0 && luaChon != 0) {
					DataThongKeKHTheoThang thongTinThang = thongKe.getKhachHangNhieuHoaDonNhatTheoThang(nam, thang,
							soLuongCucBo,luaChon);
					List<KhachHang> danhSachKhachHang1 = thongTinThang.getDanhSachKhachHang();

					for (KhachHang khachHang : danhSachKhachHang1) {
						int index = danhSachKhachHang1.indexOf(khachHang);
						int soLuongHoaDon = thongTinThang.getSoLuongHoaDon(index);
						String tenKhachHang = thongKe.getTenKhachHangFromMaKhachHang(khachHang.getMaKhachHang());
						String chuyenDoiGT = "";
						if (khachHang.isGioiTinh() == false) {
							chuyenDoiGT = "Nam";
						} else {
							chuyenDoiGT = "Nữ";
						}
						modelTK.addRow(
								new Object[] { khachHang.getMaKhachHang(), tenKhachHang, soLuongHoaDon, chuyenDoiGT });						
						double tyLePhanTram = ((double) soLuongHoaDon / 1000) * 100;
						dataset.addValue(tyLePhanTram, "Khách hàng", tenKhachHang);
					}
					chartPanel.setChart(chart);
					chartPanel.repaint();
					chart.fireChartChanged();
				} else if (ngay == 0 && thang == 0 && luaChon != 0) {
					DataThongKeKHTheoNam thongTinNam = thongKe.getSoLuongHoaDonKhachHangTheoNam(nam, soLuongCucBo,luaChon);
					List<KhachHang> danhSachKhachHang1 = thongTinNam.getDanhSachKhachHang();
					
					for (KhachHang khachHang : danhSachKhachHang1) {
						int index = danhSachKhachHang1.indexOf(khachHang);
						int soLuongHoaDon = thongTinNam.getSoLuongHoaDon(index);
						String tenKhachHang = thongKe.getTenKhachHangFromMaKhachHang(khachHang.getMaKhachHang());
						String chuyenDoiGT = "";
						if (khachHang.isGioiTinh() == false) {
							chuyenDoiGT = "Nam";
						} else {
							chuyenDoiGT = "Nữ";
						}
						modelTK.addRow(
								new Object[] { khachHang.getMaKhachHang(), tenKhachHang, soLuongHoaDon, chuyenDoiGT });
						
						String tenKhachHangTK = thongKe.getTenKhachHangFromMaKhachHang(khachHang.getMaKhachHang());
						
						   // Vẽ biểu đồ ngay sau khi thêm dữ liệu vào bảng
					    double tyLePhanTram = ((double) soLuongHoaDon / 1000) * 100;
					    dataset.addValue(tyLePhanTram, "Khách hàng", tenKhachHangTK);
					}
					chartPanel.setChart(chart);
					chartPanel.repaint();
					chart.fireChartChanged();
				} else {
					JOptionPane.showMessageDialog(null, "RỖng");
				}
			}
		});

		/////////////////////////////////////////////////////////////////////

		/// các filter lọc củ khách hàng
		JLabel lblFilter = new JLabel("Lọc");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilter.setBounds(10, 38, 49, 14);
		panel.add(lblFilter);

		// chooose filter
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(51, 35, 179, 22);
		panel.add(comboBox);
		String[] filter = { "Lọc Giới tính", "Nam", "Nữ" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}

		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindName.setBounds(270, 38, 92, 14);
		panel.add(lblFindName);

		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBackground((Color) null);
		// Lấy border mặc định
		Border border1 = textFieldName.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFieldName.setBorder(newBorder1);
		textFieldName.setBounds(372, 38, 168, 20);
		panel.add(textFieldName);

		JLabel lblFindId = new JLabel("Tìm theo mã");
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindId.setBounds(577, 38, 92, 14);
		panel.add(lblFindId);

		textFindId = new JTextField();
		textFindId.setColumns(10);
		textFindId.setBackground((Color) null);
		// Lấy border mặc định
		Border border = textFindId.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		textFindId.setBorder(newBorder);
		textFindId.setBounds(691, 36, 185, 20);
		panel.add(textFindId);

		// phần add khách hàng
		JPanel panel_KH = new JPanel();
		panel_KH.setLayout(null);
		panel_KH.setBounds(604, 86, 364, 454);
		Border borderKH = BorderFactory.createLineBorder(java.awt.Color.BLACK, 3);
		panel_KH.setBorder(borderKH);
		panel.add(panel_KH);

		JLabel lblMaKhachHang = new JLabel("Mã Khách Hàng");
		lblMaKhachHang.setBounds(31, 91, 99, 17);
		panel_KH.add(lblMaKhachHang);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtMaKhachHang.setEditable(false);
		txtMaKhachHang.setBounds(131, 85, 204, 20);
		panel_KH.add(txtMaKhachHang);

		JLabel lblName = new JLabel("Họ Tên");
		lblName.setBounds(31, 119, 89, 14);
		panel_KH.add(lblName);

		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setEditable(false);
		txtName.setBounds(131, 116, 204, 20);
		panel_KH.add(txtName);

		// giới tính
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setBounds(31, 193, 89, 14);
		panel_KH.add(lblSex);

		final JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(145, 189, 66, 23);
		panel_KH.add(rdbtnMale);

		final JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(269, 189, 66, 23);
		panel_KH.add(rdbtnFemale);
		rdbtnMale.setEnabled(false);
		rdbtnFemale.setEnabled(false);

		ButtonGroup gioiTinh = new ButtonGroup();
		gioiTinh.add(rdbtnMale);
		gioiTinh.add(rdbtnFemale);

		// so điên thoại
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setBounds(31, 156, 89, 14);
		panel_KH.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setEditable(false);
		txtPhone.setBounds(131, 153, 204, 20);
		panel_KH.add(txtPhone);

		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setBounds(31, 227, 89, 14);
		panel_KH.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setEditable(false);
		txtAddress.setBounds(131, 224, 204, 20);
		panel_KH.add(txtAddress);

		final JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(new Color(255, 255, 255));
//		btnSua.setContentAreaFilled(false);
		btnSua.setBackground(new Color(255, 105, 180));
		btnSua.setBounds(145, 365, 99, 40);
		panel_KH.add(btnSua);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(0, 128, 128));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(145, 301, 99, 40);
		panel_KH.add(btnAdd);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(new Color(199, 21, 133));
		btnHuy.setForeground(new Color(255, 255, 255));
		btnHuy.setBounds(254, 365, 99, 40);
		panel_KH.add(btnHuy);

		JButton btnDelete = new JButton("Xóa");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setBounds(254, 301, 99, 40);
		panel_KH.add(btnDelete);

		JButton btnTaoKH = new JButton("Tạo KH");
		btnTaoKH.setBackground(new Color(152, 251, 152));
		btnTaoKH.setForeground(Color.WHITE);
		btnTaoKH.setBounds(41, 301, 99, 40);
		panel_KH.add(btnTaoKH);

		final JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBackground(new Color(102, 205, 170));
		btnXacNhan.setForeground(Color.WHITE);
		btnXacNhan.setBounds(41, 365, 99, 40);
		panel_KH.add(btnXacNhan);
		// table
		String row[] = { "Mã Khách Hàng", "Họ Tên", "SDT", "Địa chỉ", "Giới tính" ,"Email"};
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

		for (KhachHang khachHang : khachHangs) {
			boolean gioiTinhValue = khachHang.isGioiTinh();
			String gioiTinh1;
			if (gioiTinhValue == true) {
				gioiTinh1 = "Nam";
			} else {
				gioiTinh1 = "Nữ";
			}

			model.addRow(new Object[] { khachHang.getMaKhachHang(), khachHang.getHoTen(), khachHang.getSoDienThoai(),
					khachHang.getDiaChi(), gioiTinh1, });
		}

		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 594, 454);
		panel.add(scrollPane);

		// click vào bảng cập nhật dữ liệu lên text
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			private boolean isRowSelected = false;

			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow != -1) { // Đảm bảo đã chọn một dòng
					isRowSelected = true;
					String maKh = (String) table.getValueAt(selectedRow, 0);
					String hoTen = (String) table.getValueAt(selectedRow, 1);
					String sdt = (String) table.getValueAt(selectedRow, 2);
					String diaChi = (String) table.getValueAt(selectedRow, 3);
					String gioiTinh = (String) table.getValueAt(selectedRow, 4);

					// Hiển thị dữ liệu lên các trường nhập và radio button
					txtMaKhachHang.setText(maKh);
					txtName.setText(hoTen);
					txtPhone.setText(sdt);
					txtAddress.setText(diaChi);
					if (gioiTinh.equals("Nam")) {
						rdbtnMale.setSelected(true);
					} else if (gioiTinh.equals("Nữ")) {
						rdbtnFemale.setSelected(true);
					}
					  btnSua.setEnabled(true);
				} else if (!isRowSelected) {
					table.clearSelection();
					// Xóa dữ liệu từ các trường nhập và radio button
					txtMaKhachHang.setText("");
					txtName.setText("");
					txtPhone.setText("");
					txtAddress.setText("");
					rdbtnMale.setSelected(false);
					rdbtnFemale.setSelected(false);
				}
			}
		});

		// thêm khách hàng
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKhachHang = txtMaKhachHang.getText();
				String hoTen = txtName.getText().trim();
				String soDienThoai = txtPhone.getText();
				boolean gioiTinh = false;
				if (rdbtnMale.isSelected()) {
					gioiTinh = true;
				} else {
					gioiTinh = false;
				}
				String diaChi = txtAddress.getText().trim();
				if (txtMaKhachHang.getText().equalsIgnoreCase("") || txtName.getText().equalsIgnoreCase("")
						|| txtPhone.getText().equalsIgnoreCase("") || txtAddress.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Chưa nhập đủ dữ liệu");
				} else {
					// Kiểm tra regex cho tên
					if (!soDienThoai.matches("^[0-9]+$")) {
						JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được chứa số.");
					}
					if (!diaChi.matches("^[a-zA-Z0-9 ]+$")) {
						JOptionPane.showMessageDialog(null, "Địa chỉ chỉ được chứa chữ cái và số.");
					}
					if (hoTen.matches("^[a-zA-Z]+$")) {
						KhachHang newKhachHang = new KhachHang(maKhachHang, hoTen, soDienThoai, gioiTinh, diaChi);
						khachHangDAO.addKhachHang(newKhachHang);
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.addRow(new Object[] { maKhachHang, hoTen, soDienThoai, diaChi, gioiTinh ? "Nam" : "Nữ" });
						txtMaKhachHang.setText("");
						txtName.setText("");
						txtPhone.setText("");
						txtAddress.setText("");
						JOptionPane.showMessageDialog(scrollPane, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Tên chỉ được chứa chữ.");
					}
				}
			}
		});

		// xóa khách hàng
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?");
				if (confirm == JOptionPane.YES_OPTION) {
					String maKhachHangDelete = txtMaKhachHang.getText();
					khachHangDAO.deleteKhachHang(maKhachHangDelete);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					System.out.println("mã khách hàng 1: " + maKhachHangDelete);
					int rowIndex = table.getSelectedRow();
					if (rowIndex != -1) {
						model.removeRow(rowIndex);
					}
				}
			}
		});

		// nút hủy
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaKhachHang.setText("");
				txtName.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
			}
		});

		// nút sửa
		btnSua.setEnabled(false); 
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    btnXacNhan.setEnabled(true);
				btnXacNhan.setEnabled(true);
				txtName.setEditable(true);
				txtPhone.setEditable(true);
				txtAddress.setEditable(true);
				rdbtnMale.setEnabled(true);
				rdbtnFemale.setEnabled(true);
			}
		});

		// nút xác nhận sửa khách hàng
		btnXacNhan.setEnabled(false);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(31, 258, 89, 14);
		panel_KH.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 255, 204, 20);
		panel_KH.add(txtEmail);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ các trường trên giao diện
				String maKhachHang = txtMaKhachHang.getText();
				String hoTen = txtName.getText();
				String soDienThoai = txtPhone.getText();
				boolean gioiTinh = rdbtnMale.isSelected(); // Nếu "Nam" được chọn thì true, ngược lại là false
				String diaChi = txtAddress.getText();
				// Tạo đối tượng KhachHang mới với các thông tin đã cập nhật
				KhachHang updatedKhachHang = new KhachHang(maKhachHang, hoTen, soDienThoai, gioiTinh, diaChi);
				// Gọi phương thức updateKhachHang để cập nhật thông tin trong cơ sở dữ liệu
				khachHangDAO.updateKhachHang(updatedKhachHang);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// Xác định rowIndex của bản ghi bạn muốn cập nhật
				int rowIndex = table.getSelectedRow();
				// Thay đổi dữ liệu trong model theo rowIndex
				model.setValueAt(updatedKhachHang.getMaKhachHang(), rowIndex, 0);
				model.setValueAt(updatedKhachHang.getHoTen(), rowIndex, 1);
				model.setValueAt(updatedKhachHang.getSoDienThoai(), rowIndex, 2);
				model.setValueAt(updatedKhachHang.getDiaChi(), rowIndex, 3);
				model.setValueAt(updatedKhachHang.isGioiTinh() ? "Nam" : "Nữ", rowIndex, 4);
				// Thông báo hoặc cập nhật lại giao diện nếu cần
				JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công!");
			}
		});

		// tạo khách hàng
		btnTaoKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maKH = generateKhachHangID();
				txtMaKhachHang.setText(maKH);
				txtName.setEditable(true);
				txtPhone.setEditable(true);
				txtAddress.setEditable(true);
				rdbtnFemale.setEnabled(true);
				rdbtnMale.setEnabled(true);
				txtName.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		});

		// ---------------------------------

		// filter dữ liệu
		// sorter đang null thiết lập RowSorter để sắp xếp và lọc dữ liệu trong JTable
		final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) table.getModel());
		table.setRowSorter(sorter);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFilter = (String) comboBox.getSelectedItem();

				if (selectedFilter != null && sorter != null) {

					if (selectedFilter.equals("Nam")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nam", 4)); // Lọc theo cột "Giới tính"
					} else if (selectedFilter.equals("Nữ")) {
						sorter.setRowFilter(RowFilter.regexFilter("Nữ", 4)); // Lọc theo cột "Giới tính"
					} else {
						sorter.setRowFilter(null); // Hủy bỏ bất kỳ bộ lọc nào
					}
				}
			}
		});

		// tìm theo mã khách hàng
		textFindId.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});

		// tìm theo tên khách hàng
		textFieldName.getDocument().addDocumentListener(new DocumentListener() {
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

		// Code xu ly su kien
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

		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnNhanVien)) {
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
				if (o.equals(btnSanPham)) {
					ViewSanPham sp = new ViewSanPham();
					sp.setLocationRelativeTo(null);
					sp.setVisible(true);
					dispose();
				}

			}
		});
	}

	private JTextField txtSoLuongKH;
	private JTable table_1;
	private JTextField txtMaKhachHang;
	private JTextField txtNgay;
	private JTextField txtThang;
	private JTextField txtNam;
	private JTextField txtEmail;

	static String hamTang() {
		for (int i = 1; i <= 1000; i++) {
			count++;
		}
		return Integer.toString(count);
	}

	// search của mã
	private void search() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String textToSearch = textFindId.getText();

		if (textToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(textToSearch, 0)); // Tìm kiếm trong cột "Mã Khách Hàng" (cột
																			// 0)
		}
	}

	// search của ten
	private void searchByName() {
		DefaultRowSorter<DefaultTableModel, Integer> sorter = (DefaultRowSorter<DefaultTableModel, Integer>) table
				.getRowSorter();
		TableRowSorter<? extends TableModel> rowSorter = (TableRowSorter<? extends TableModel>) sorter;
		String nameToSearch = textFieldName.getText();

		if (nameToSearch.trim().length() == 0) {
			rowSorter.setRowFilter(null); // Hủy bỏ bộ lọc nếu trường tìm kiếm rỗng
		} else {
			// Lọc dựa trên nội dung của trường tìm kiếm và chỉ hiển thị các dòng thỏa mãn
			rowSorter.setRowFilter(RowFilter.regexFilter(nameToSearch, 1)); // Tìm kiếm trong cột "Họ Tên" (cột 1)
		}
	}

	// lấy mã
	public String generateRandomMaNhanVien() {
		// Số lượng chữ số trong mã
		int length = 8;
		// Chuỗi chứa các chữ số duy nhất
		String digits = "0123456789";
		StringBuilder sb = new StringBuilder();

		Random random = new Random();
		while (sb.length() < length) {
			int index = random.nextInt(digits.length());
			char digit = digits.charAt(index);
			if (sb.length() == 0 || sb.charAt(sb.length() - 1) != digit) {
				sb.append(digit);
			}
		}
		return sb.toString();
	}

	public static String generateKhachHangID() {
		Random random = new Random();
		int randomNumber = random.nextInt(10000);
		String nhanVienID = "KH" + String.format("%04d", randomNumber);
		return nhanVienID;
	}
}
