package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ViewNhanVien1 extends JFrame {
	private Color colorMenu = new Color(27, 64, 31);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JTextField txtKh;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textAddress;
	private ButtonGroup gioiTinh;

	private JTextField textFieldName;
	private JTextField textFindId;
	private JTextField txtMaNV;
	private JTextField txtRole;
	private JTextField txtName;
	private JTextField txtSex;
	private JTextField txtPhone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
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

	public ViewNhanVien1(){

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

//		JMenuBar menuBar = new JMenuBar();
//		JMenu mnKhachHang = new JMenu("Khách hàng");
//		// Tạo menu Thống kê
//		JMenu mnThongKe = new JMenu("Thống kê");
//		// Thêm menu vào menu bar
//		menuBar.add(mnKhachHang);
//		menuBar.add(mnThongKe);
//		// Thêm menu bar vào frame
//		menuBar.setBounds(115, 11, 106, 23);
//		setJMenuBar(menuBar);
//		panel_2.add(menuBar);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 0));
		btnAdd.setBounds(208, 132, 100, 30);
		contentPane.add(btnAdd);

		// chooose filter
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(379, 136, 179, 22);
		contentPane.add(comboBox);

		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setBounds(331, 140, 38, 14);
		contentPane.add(lblLoc);
		String[] filter = { "Lọc Giới tính", "Nam", "Nữ" };
		for (String choice : filter) {
			comboBox.addItem(choice);
		}
		// label tìm tên
		JLabel lblFindName = new JLabel("Tìm theo tên");
		lblFindName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindName.setBounds(591, 139, 92, 14);
		contentPane.add(lblFindName);

		textFieldName = new JTextField();
		textFieldName.setBounds(693, 137, 168, 20);
		textFieldName.setColumns(10);
		
		textFieldName.setBackground(null);
		Border border = textFieldName.getBorder();
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		textFieldName.setBorder(newBorder);
		contentPane.add(textFieldName);
		// label tìm mã
		JLabel lblFindId = new JLabel("Tìm theo mã");
		lblFindId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFindId.setBounds(889, 139, 92, 14);
		contentPane.add(lblFindId);

		textFindId = new JTextField();
		textFindId.setColumns(10);
		textFindId.setBounds(991, 137, 185, 20);
		textFindId.setBackground(null);
		Border border1 = textFindId.getBorder();
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		textFindId.setBorder(newBorder1);
		contentPane.add(textFindId);
		
		//panel
		
		JPanel panel_nhanVien = new JPanel();
		panel_nhanVien.setBackground(new Color(224, 255, 255));
		panel_nhanVien.setBounds(194, 193, 982, 125);
		contentPane.add(panel_nhanVien);
		panel_nhanVien.setLayout(null);
		
		JLabel lblAvt = new JLabel("");
		lblAvt.setBounds(21, 11, 105, 101);
		panel_nhanVien.add(lblAvt);
		/// một nhân viên
		// chèn avatar
		try {
			int labelWidth = lblAvt.getWidth();
			int labelHeight = lblAvt.getHeight();
			BufferedImage image = ImageIO.read(new File(".\\IMG\\avatar.png"));
			BufferedImage resizedImage = new BufferedImage(labelWidth, labelHeight, image.getType());	
			Graphics2D g = resizedImage.createGraphics();	
			g.drawImage(image, 0, 0, labelWidth, labelHeight, null);
			g.dispose();	
			ImageIcon icon = new ImageIcon(resizedImage);
			// set icon cho label
			lblAvt.setIcon(icon);
			// mã nhân viên
			JLabel lblMaNV = new JLabel("Mã nhân viên");
			lblMaNV.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblMaNV.setBounds(157, 23, 96, 14);
			panel_nhanVien.add(lblMaNV);
			
			txtMaNV = new JTextField();
			txtMaNV.setBounds(272, 20, 162, 20);
			panel_nhanVien.add(txtMaNV);
			txtMaNV.setColumns(10);
			txtMaNV.setText("NV001");
			txtMaNV.setBackground(null);
			txtMaNV.setBorder(null);
			// họ tên
			JLabel lblName = new JLabel("Họ tên");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblName.setBounds(157, 54, 96, 14);
			panel_nhanVien.add(lblName);
			
			txtName = new JTextField();
			txtName.setColumns(10);
			txtName.setBounds(272, 48, 162, 20);
			panel_nhanVien.add(txtName);
			txtName.setText("Phan Mạnh Dũng");
			txtName.setBackground(null);
			txtName.setBorder(null);
			// chức vụ
			JLabel lblRole = new JLabel("Chức vụ");
			lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblRole.setBounds(157, 85, 96, 14);
			panel_nhanVien.add(lblRole);
			
			txtRole = new JTextField();
			txtRole.setColumns(10);
			txtRole.setBounds(272, 82, 162, 20);
			panel_nhanVien.add(txtRole);
			txtRole.setText("Nhân viên");
			txtRole.setBackground(null);
			txtRole.setBorder(null);
			// giới tính
			JLabel lblSex = new JLabel("Giới tính");
			lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSex.setBounds(524, 23, 96, 14);
			panel_nhanVien.add(lblSex);
			
			txtSex = new JTextField();
			txtSex.setColumns(10);
			txtSex.setBounds(630, 20, 162, 20);
			panel_nhanVien.add(txtSex);
			txtSex.setText("Nam");
			txtSex.setBackground(null);
			txtSex.setBorder(null);
			// phone
			JLabel lblPhone = new JLabel("Số điện thoại");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhone.setBounds(524, 54, 96, 14);
			panel_nhanVien.add(lblPhone);
			
			txtPhone = new JTextField();
			txtPhone.setColumns(10);
			txtPhone.setBounds(630, 51, 162, 20);
			panel_nhanVien.add(txtPhone);
			txtPhone.setText("0930930");
			txtPhone.setBackground(null);
			txtPhone.setBorder(null);
			// email
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEmail.setBounds(524, 85, 96, 14);
			panel_nhanVien.add(lblEmail);
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(630, 82, 162, 20);
			panel_nhanVien.add(txtEmail);
			txtEmail.setText("dung@gmail.com");
			txtEmail.setBackground(null);
			txtEmail.setBorder(null);
			// button sửa
			JButton btnFix = new JButton("Sửa");
			btnFix.setForeground(new Color(255, 255, 255));
			btnFix.setBackground(new Color(255, 165, 0));
			btnFix.setBounds(845, 11, 105, 29);
			panel_nhanVien.add(btnFix);
			// button xóa
			JButton btnDelete = new JButton("Xóa");
			btnDelete.setForeground(new Color(255, 255, 255));
			btnDelete.setBackground(new Color(255, 0, 0));
			btnDelete.setBounds(845, 47, 105, 29);
			panel_nhanVien.add(btnDelete);
			// button reset pass
			JButton btnReset = new JButton("Reset Pass");
			btnReset.setForeground(new Color(255, 255, 255));
			btnReset.setBackground(new Color(255, 69, 0));
			btnReset.setBounds(845, 83, 105, 29);
			panel_nhanVien.add(btnReset);
			
			// sự kiện add nhân viên 
//			btnAdd.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					ViewAddNhanVien viewNV = new ViewAddNhanVien();
//					viewNV.setLocationRelativeTo(null);
//					viewNV.setVisible(true);
//				}
//			});
			
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
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}