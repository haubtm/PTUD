package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.table.TableCellRenderer;


import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ViewKhachHang extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color colorMenu = new Color(27, 64, 31);
	private JTextField textFieldName;
	private JTextField textFindId;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		tabbedPane.setBounds(201, 91, 983, 658);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Khách Hàng", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFilter = new JLabel("Lọc");
		lblFilter.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilter.setBounds(10, 38, 49, 14);
		panel.add(lblFilter);
		
		// chooose filter
		JComboBox comboBox = new JComboBox();
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
		panel_KH.setBounds(604, 86, 364, 533);
		panel.add(panel_KH);
		
		JLabel lblName = new JLabel("Họ Tên");
		lblName.setBounds(31, 119, 89, 14);
		panel_KH.add(lblName);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(131, 116, 204, 20);
		panel_KH.add(textName);
		
		// giới tính
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setBounds(31, 193, 89, 14);
		panel_KH.add(lblSex);
		
		final JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBounds(131, 189, 66, 23);
		panel_KH.add(rdbtnMale);
		
		final JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBounds(206, 189, 66, 23);
		panel_KH.add(rdbtnFemale);
		
		final ButtonGroup gioiTinh = new ButtonGroup();
		gioiTinh.add(rdbtnMale);
		gioiTinh.add(rdbtnFemale); 
		
		// so điên thoại
		JLabel lblPhone = new JLabel("Số điện thoại");
		lblPhone.setBounds(31, 156, 89, 14);
		panel_KH.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(131, 153, 204, 20);
		panel_KH.add(textPhone);
		
		JLabel lblAddress = new JLabel("Địa chỉ");
		lblAddress.setBounds(31, 227, 89, 14);
		panel_KH.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(131, 224, 204, 20);
		panel_KH.add(textAddress);
		
		JButton btnConfirm = new JButton("Xác nhận");
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBackground(Color.GREEN);
		btnConfirm.setBounds(131, 291, 99, 40);
		panel_KH.add(btnConfirm);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.setBounds(10, 369, 99, 40);
		panel_KH.add(btnAdd);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(131, 369, 99, 40);
		panel_KH.add(btnCancel);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(255, 369, 99, 40);
		panel_KH.add(btnDelete);
		
		String row[] = { "Mã Khách Hàng", "Họ Tên", "SDT", "Địa chỉ", "Giới tính" };

		model = new DefaultTableModel(row, 0);
		model.addRow(row);
		String row1[] = { "KH001", "Dũng", "034343", "12-QuangTrung", "Nữ" };
		model.addRow(row1);
		String row2[] = { "KH001", "Dũng", "034343", "12-QuangTrung", "Nam" };
		model.addRow(row2);
		String row3[] = { "KH002", "Hoang", "034343", "12-QuangTrung", "Nam" };
		model.addRow(row3);
		String row4[] = { "KH001", "Thái", "034343", "12-QuangTrung", "Nữ" };
		model.addRow(row4);
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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 86, 594, 533);
		panel.add(scrollPane);
		
		// thêm data vào bảng table
//		btnAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// Lấy thông tin từ các trường nhập
//				String maKH = "KH" + ViewKhachHang.hamTang(); // Điền mã KH theo logic của bạn
//				String hoTen = textName.getText();
//				String sdt = textPhone.getText();
//				String diaChi = textAddress.getText();
//				String gioiTinh = rdbtnMale.isSelected() ? "Nam" : "Nữ";
//				// Tạo một mảng chứa thông tin mới
//				String newRow[] = { maKH, hoTen, sdt, diaChi, gioiTinh };
//				// Thêm hàng mới vào bảng
//				model.addRow(newRow);
//				// Xóa nội dung các trường nhập
//				textName.setText("");
//				textPhone.setText("");
//				textAddress.setText("");
//			}
//		});
		// sửa dữ liệu trong bảng table
		btnConfirm.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Lấy dòng được chọn trong bảng
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String hoTen = textName.getText();
					String sdt = textPhone.getText();
					String diaChi = textAddress.getText();
					String gioiTinh = rdbtnMale.isSelected() ? "Nam" : (rdbtnFemale.isSelected() ? "Nữ" : "");
					// Cập nhật dữ liệu trong bảng
					table.setValueAt(hoTen, selectedRow, 1);
					table.setValueAt(sdt, selectedRow, 2);
					table.setValueAt(diaChi, selectedRow, 3);
					table.setValueAt(gioiTinh, selectedRow, 4);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để sửa.", "Lỗi", selectedRow);
				}
			}
		}));
		// xóa khách hàng
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int confirm = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc chắn xóa");
					if (confirm == JOptionPane.YES_OPTION) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.removeRow(selectedRow);
						// xóa trong text
						textName.setText("");
						textPhone.setText("");
						textAddress.setText("");
						gioiTinh.clearSelection();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một dòng để xóa.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// Code xu ly su kien
		btnHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Object o = e.getSource();
		    	if(o.equals(btnHoaDon)) {
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

