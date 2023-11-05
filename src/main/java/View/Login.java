package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Login() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 335, 423);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		JLabel lblImg_Shop = new JLabel("img_shop");
		lblImg_Shop.setBounds(0, 0, 335, 423);
		panelLeft.add(lblImg_Shop);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(337, 0, 300, 413);
		contentPane.add(panelRight);
		panelRight.setLayout(null);

		JLabel lblTitle = new JLabel("Shop quần áo");
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(111, 51, 138, 32);
		panelRight.add(lblTitle);
		// text user
		txtUser = new JTextField();
		txtUser.setBounds(111, 150, 150, 20);
		panelRight.add(txtUser);

		txtUser.setBackground(null);
		// Lấy border mặc định
		Border border = txtUser.getBorder();
		// Tạo border chỉ có dưới
		Border newBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		// Set border mới
		txtUser.setBorder(newBorder);
		txtUser.setColumns(10);
		// pass field

		passwordField = new JPasswordField();
		passwordField.setBounds(111, 210, 150, 20);
		Border border1 = passwordField.getBorder();
		passwordField.setBackground(null);
		Border newBorder1 = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.green);
		passwordField.setBorder(newBorder1);
		panelRight.add(passwordField);

		// label user và lock
		JLabel lbl_user = new JLabel();
		lbl_user.setBounds(47, 144, 40, 37);
		panelRight.add(lbl_user);

		JLabel lbl_pass = new JLabel();
		lbl_pass.setBounds(47, 199, 40, 37);
		panelRight.add(lbl_pass);

		// Đọc ảnh từ tệp và đặt ảnh cho JLabel
		try {
			// Lấy kích thước của JLabel
			int labelWidth = lblImg_Shop.getWidth();
			int labelHeight = lblImg_Shop.getHeight();
			// Thay đổi kích thước của ảnh để vừa với JLabel
			BufferedImage image = ImageIO.read(new File(".\\IMG\\trang_login.jpg"));
			// Tạo đối tượng BufferedImage mới có kích thước bằng kích thước label, loại ảnh
			// giống ảnh gốc
			BufferedImage resizedImage = new BufferedImage(labelWidth, labelHeight, image.getType());
			// Lấy đối tượng Graphics2D để vẽ lên resizedImage
			Graphics2D g = resizedImage.createGraphics();
			// Vẽ ảnh gốc lên resizedImage với kích thước mới
			g.drawImage(image, 0, 0, labelWidth, labelHeight, null);
			// Giải phóng bộ nhớ của Graphics2D
			g.dispose();
			// Tạo ImageIcon sử dụng resizedImage đã có kích thước thực
			ImageIcon icon = new ImageIcon(resizedImage);
			// set icon cho label
			lblImg_Shop.setIcon(icon);

			// sét img user

			BufferedImage user = ImageIO.read(new File(".\\IMG\\user.png"));
			ImageIcon icon1 = new ImageIcon(user);
			lbl_user.setIcon(icon1);

			// sét img lock
			BufferedImage lock = ImageIO.read(new File(".\\IMG\\lock.png"));
			ImageIcon icon2 = new ImageIcon(lock);
			lbl_pass.setIcon(icon2);

		} catch (IOException e) {
			e.printStackTrace();
		}

		JButton btnForgetPass = new JButton("Quên mật khẩu");
		btnForgetPass.setBackground(new Color(220, 20, 60));
		btnForgetPass.setForeground(new Color(255, 255, 255));
		btnForgetPass.setBounds(98, 277, 125, 32);
		btnForgetPass.setBorder(null);
		btnForgetPass.setUI(new BasicButtonUI());

		panelRight.add(btnForgetPass);

		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(98, 321, 125, 32);
		btnLogin.setBorder(null);
		btnLogin.setUI(new BasicButtonUI());
		panelRight.add(btnLogin);

		// sử kiện login

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginInfo loginInfo = new LoginInfo();
				String loginRole;
				// Lấy dữ liệu từ các trường nhập liệu
				String username = txtUser.getText();
				String password = new String(passwordField.getPassword());
				// Kiểm tra dữ liệu đăng nhập
				// Ví dụ: kiểm tra username và password có hợp lệ hay không
				if (username.equals("admin") && password.equals("12345")) {
					loginInfo.setLoginRole("admin");
//					ViewKhachHang viewKH = new ViewKhachHang(loginInfo);
//					viewKH.setLocationRelativeTo(null);
//					viewKH.setVisible(true);
					ViewSanPham sp = new ViewSanPham();
		    		sp.setLocationRelativeTo(null);
		    		sp.setVisible(true);
				} else if (username.equals("nv") && password.equals("12345")) {
					loginInfo.setLoginRole("nv");
//					ViewKhachHang viewKH = new ViewKhachHang(loginInfo);
//					viewKH.setLocationRelativeTo(null);
//					viewKH.setVisible(true);
					ViewSanPham sp = new ViewSanPham();
		    		sp.setLocationRelativeTo(null);
		    		sp.setVisible(true);
				}
				if (!(username.equals("admin") && password.equals("12345"))
						&& !(username.equals("nv") && password.equals("12345"))) {
					JOptionPane.showMessageDialog(contentPane,
							"Tên đăng nhập hoặc mật khẩu không đúng hoặc bạn không có quyền truy cập.", "Lỗi đăng nhập",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
