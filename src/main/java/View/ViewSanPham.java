package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Entity.KhachHang;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import java.awt.Component;

public class ViewSanPham extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public ViewKhachHang viewKhachHang;
	private Color colorMenu = new Color(27, 64, 31);
	private KhachHang sanPham;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSanPham frame = new ViewSanPham();
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
	public ViewSanPham() {
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
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.ORANGE);
		pnlMenu.setBounds(0, 87, 199, 676);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnDangXuat.setBounds(10, 161, 85, 35);
		pnlMenu.add(btnDangXuat);
		btnDangXuat.setBackground(colorMenu);
		btnDangXuat.setFocusPainted(false);
		
		JButton btnCaNhan = new JButton("Cá Nhân");
		btnCaNhan.setForeground(Color.WHITE);
		btnCaNhan.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnCaNhan.setBounds(105, 161, 85, 35);
		btnCaNhan.setBackground(colorMenu);
		btnCaNhan.setFocusPainted(false);
		
		pnlMenu.add(btnCaNhan);
		
		JLabel lblHoTen = new JLabel("Hồ Vĩnh Duy");
		lblHoTen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoTen.setBounds(0, 206, 199, 25);
		pnlMenu.add(lblHoTen);
		
		JLabel lblChucVu = new JLabel("Quản Lý");
		lblChucVu.setForeground(Color.BLUE);
		lblChucVu.setBackground(Color.BLUE);
		lblChucVu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChucVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChucVu.setBounds(0, 241, 199, 21);
		pnlMenu.add(lblChucVu);
		
		final JButton btnHoaDon = new JButton("Hoá Đơn");
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(0, 325, 199, 35);
		pnlMenu.add(btnHoaDon);
		btnHoaDon.setBackground(colorMenu);
		btnHoaDon.setForeground(Color.WHITE);
		btnHoaDon.setFocusPainted(false);
		
		final JButton btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNhanVien.setBounds(0, 370, 199, 35);
		pnlMenu.add(btnNhanVien);
		btnNhanVien.setBackground(colorMenu);
		btnNhanVien.setForeground(Color.WHITE);
		btnNhanVien.setFocusPainted(false);
		
		final JButton btnKhachHang = new JButton("Khách Hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhachHang.setBounds(0, 415, 199, 35);
		pnlMenu.add(btnKhachHang);
		btnKhachHang.setBackground(colorMenu);
		btnKhachHang.setForeground(Color.WHITE);
		btnKhachHang.setFocusPainted(false);
		
		JButton btnSanPham = new JButton("Sản Phẩm");
		btnSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSanPham.setBounds(0, 460, 199, 35);
		pnlMenu.add(btnSanPham);
		btnSanPham.setForeground(Color.BLACK);
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
		pnlMenu.add(pnlanhdaidien);
		
		JTabbedPane tabbedNhanVien = new JTabbedPane(JTabbedPane.TOP);
		tabbedNhanVien.setBounds(201, 87, 985, 676);
		contentPane.add(tabbedNhanVien);
		
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setLayout(null);
		tabbedNhanVien.addTab("Nhân Viên", null, pnlSanPham, null);
		
		
		JPanel pnlSapXep = new JPanel();
		pnlSapXep.setLayout(null);
		pnlSapXep.setBackground(new Color(226, 240, 222));
		pnlSapXep.setBounds(0, 10, 987, 72);
		pnlSanPham.add(pnlSapXep);
		
		JButton btnThemSanPham = new JButton("Thêm");
		btnThemSanPham.setBounds(21, 10, 85, 52);
		pnlSapXep.add(btnThemSanPham);
		btnThemSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút được nhấn, tạo và hiển thị form mới (OtherFrame)
               ViewThemSanPham viewThemSanPham = new ViewThemSanPham();
               viewThemSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               viewThemSanPham.setLocationRelativeTo(null);
               viewThemSanPham.setResizable(false);
               viewThemSanPham.setVisible(true);
            }
        });
		
		JComboBox cboSapXep = new JComboBox();
		cboSapXep.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần giá", "Giảm dần giá", "Từ A->Z", "Từ Z->A"}));
		cboSapXep.setBounds(189, 26, 117, 21);
		pnlSapXep.add(cboSapXep);
		
		JComboBox cboLoc = new JComboBox();
		cboLoc.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Quần", "Áo", "Váy ", "Phụ Kiện"}));
		cboLoc.setBounds(380, 26, 85, 21);
		pnlSapXep.add(cboLoc);
		
		JLabel lblTimTheoTen = new JLabel("Tìm theo tên:");
		lblTimTheoTen.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTimTheoTen.setBounds(508, 30, 85, 13);
		pnlSapXep.add(lblTimTheoTen);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(588, 27, 96, 19);
		pnlSapXep.add(textField);
		
		JLabel lblTimTheoMa = new JLabel("Tìm theo mã:");
		lblTimTheoMa.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTimTheoMa.setBounds(709, 30, 85, 13);
		pnlSapXep.add(lblTimTheoMa);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(796, 27, 96, 19);
		pnlSapXep.add(textField_1);
		
		JLabel lblSapXep = new JLabel("Sắp Xếp");
		lblSapXep.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSapXep.setBounds(137, 30, 45, 13);
		pnlSapXep.add(lblSapXep);
		
		JLabel lblLoc = new JLabel("Lọc");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLoc.setBounds(346, 30, 45, 13);
		pnlSapXep.add(lblLoc);
		


		
		JPanel pnlDanhSachSanPham = new JPanel();
//		scrollPane.setColumnHeaderView(pnlDanhSachSanPham);
		pnlDanhSachSanPham.setLayout(new GridLayout(0, 5, 10, 10));
		Color backgroundColorSapXep = new Color(226, 240, 222);
		
		JScrollPane scrollPane = new JScrollPane(pnlDanhSachSanPham);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 112, 987, 537);
		pnlSanPham.add(scrollPane);
		
		JPanel panel = new JPanel();
		tabbedNhanVien.addTab("Thống kê", null, panel, null);
		
		
		 for (int i = 0; i < 20; i++) {
	            JPanel taoDanhSachSP = taoDanhSachSP("Product " + i, "Price " + (i * 1000), ".\\IMG\\ao trang.jpg");
	            pnlDanhSachSanPham.add(taoDanhSachSP);
	        }
	
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
        
    }

	public JPanel taoDanhSachSP(String productName, String price, String imagePath) {
		JPanel pnlSanPham = new JPanel();
		pnlSanPham.setLayout(new GridBagLayout());
		Color backgroundColorSapXep = new Color(226, 240, 222);
		pnlSanPham.setBackground(backgroundColorSapXep);
        GridBagConstraints gbc = new GridBagConstraints();

        // Tạo một JPanel để chứa hình ảnh và tên sản phẩm
        JPanel imageAndNamePanel = new JPanel();
        imageAndNamePanel.setLayout(new BoxLayout(imageAndNamePanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlSanPham.add(imageAndNamePanel, gbc);

        // Thêm hình ảnh vào JPanel
        JLabel lblhinhanhsanpham = new JLabel();
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        int width = 106;
        int height = 104;
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblhinhanhsanpham.setIcon(new ImageIcon(scaledImage));
        imageAndNamePanel.add(lblhinhanhsanpham);
//        pnlDanhSachSanPham_4.add(imageAndNamePanel);

        // Thêm tên sản phẩm vào JPanel
        JLabel lblTenSanPham = new JLabel(productName);
        gbc.gridy = 1;
        pnlSanPham.add(lblTenSanPham, gbc);
        lblTenSanPham.setHorizontalAlignment(SwingConstants.CENTER);
//        pnlDanhSachSanPham_4.add(lblTenSanPham);

        // Thêm giá sản phẩm vào JPanel
        JLabel lblGiaSanPham = new JLabel(price);
        gbc.gridy = 2;
        pnlSanPham.add(lblGiaSanPham, gbc);
        lblGiaSanPham.setHorizontalAlignment(SwingConstants.CENTER);
        lblGiaSanPham.setForeground(new Color(255, 51, 51));
//        pnlDanhSachSanPham_4.add(lblGiaSanPham);

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0); // Đặt khoảng cách giữa cột 1 và cột 2
        pnlSanPham.add(buttonPanel, gbc);
//        pnlDanhSachSanPham_4.add(buttonPanel);

        JButton btnXemSanPham = new JButton("Xem");
        buttonPanel.add(btnXemSanPham);
        btnXemSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnXemSanPham.setBackground(Color.GREEN);
        btnXemSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút được nhấn, tạo và hiển thị form mới (OtherFrame)
               ViewXemSanPham viewXemSanPham = new ViewXemSanPham();
               viewXemSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               viewXemSanPham.setLocationRelativeTo(null);
               viewXemSanPham.setResizable(false);
               viewXemSanPham.setVisible(true);
            }
        });

        // Thêm khoảng cách giữa các button
        buttonPanel.add(Box.createVerticalStrut(10));

        JButton btnSuaSanPham = new JButton("Sủa");
        buttonPanel.add(btnSuaSanPham);
        btnSuaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnSuaSanPham.setBackground(Color.YELLOW);
        btnSuaSanPham.setPreferredSize(btnXemSanPham.getPreferredSize());
        buttonPanel.add(Box.createVerticalStrut(10));
        btnSuaSanPham.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Khi nút được nhấn, tạo và hiển thị form mới (OtherFrame)
               ViewSuaSanPham viewSuaSanPham = new ViewSuaSanPham();
               viewSuaSanPham.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               viewSuaSanPham.setLocationRelativeTo(null);
               viewSuaSanPham.setResizable(false);
               viewSuaSanPham.setVisible(true);
            }
        });

        JButton btnXoaSanPham = new JButton("Xoá");
        buttonPanel.add(btnXoaSanPham);
        btnXoaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnXoaSanPham.setBackground(Color.RED);
        btnXoaSanPham.setPreferredSize(btnXemSanPham.getPreferredSize());
        
        buttonPanel.setVisible(false);
        buttonPanel.setBackground(backgroundColorSapXep);
        Dimension preferredSize = new Dimension(180, 150);
        pnlSanPham.setPreferredSize(preferredSize);
        

        pnlSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!buttonPanel.getBounds().contains(e.getPoint())) {
                    buttonPanel.setVisible(false);
                }
            }
        });
		
		return pnlSanPham;	
		
		
		}
}

