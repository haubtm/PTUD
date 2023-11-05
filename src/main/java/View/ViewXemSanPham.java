package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewXemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewXemSanPham frame = new ViewXemSanPham();
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
	public ViewXemSanPham() {
		setTitle("Xem Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTenSanPham = new JLabel("Áo Sơ Mi");
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenSanPham.setBounds(0, 10, 637, 19);
		contentPane.add(lblTenSanPham);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 81, 166, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblhinhanhsanpham = new JLabel("");
		lblhinhanhsanpham.setIcon(new ImageIcon(".\\IMG\\ao trang.jpg"));
		lblhinhanhsanpham.setBounds(0, 0, 166, 235);
		panel.add(lblhinhanhsanpham);
		
		JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm :");
		lblMaSanPham.setBounds(237, 81, 93, 13);
		contentPane.add(lblMaSanPham);
		
		JLabel lblthongtinmasp = new JLabel("SP202300001");
		lblthongtinmasp.setBounds(340, 81, 104, 13);
		contentPane.add(lblthongtinmasp);
		
		JLabel lblMota = new JLabel("Mô tả:");
		lblMota.setBounds(237, 104, 81, 13);
		contentPane.add(lblMota);
		
		JLabel lblThongtinmota = new JLabel("Chất Lượng");
		lblThongtinmota.setBounds(340, 104, 89, 13);
		contentPane.add(lblThongtinmota);
		
		JLabel lblMauSac = new JLabel("Màu Sắc :");
		lblMauSac.setBounds(237, 127, 81, 13);
		contentPane.add(lblMauSac);
		
		JLabel lblnoidungmausac = new JLabel("Xanh");
		lblnoidungmausac.setBounds(340, 127, 45, 13);
		contentPane.add(lblnoidungmausac);
		
		JLabel lblXuatSu = new JLabel("Xuất Sứ :");
		lblXuatSu.setBounds(237, 150, 81, 13);
		contentPane.add(lblXuatSu);
		
		JLabel lblnoidungxuatsu = new JLabel("Việt Nam");
		lblnoidungxuatsu.setBounds(340, 150, 89, 13);
		contentPane.add(lblnoidungxuatsu);
		
		JLabel lblLoaiSanPham = new JLabel("Loại Sản Phẩm :");
		lblLoaiSanPham.setBounds(237, 173, 93, 13);
		contentPane.add(lblLoaiSanPham);
		
		JLabel lblNoiDungLoaiSP = new JLabel("Quần ");
		lblNoiDungLoaiSP.setBounds(340, 173, 45, 13);
		contentPane.add(lblNoiDungLoaiSP);
		
		JLabel lblGiaNhap = new JLabel("Giá Nhập :");
		lblGiaNhap.setBounds(237, 196, 81, 13);
		contentPane.add(lblGiaNhap);
		
		JLabel lblNoiDungGiaNhap = new JLabel("100.000 vnđ");
		lblNoiDungGiaNhap.setBounds(340, 196, 89, 13);
		contentPane.add(lblNoiDungGiaNhap);
		
		JLabel lblGiaBan = new JLabel("Giá Bán :");
		lblGiaBan.setBounds(237, 219, 81, 13);
		contentPane.add(lblGiaBan);
		
		JLabel lblNoiDungGiaBan = new JLabel("150.000 vnđ");
		lblNoiDungGiaBan.setBounds(340, 219, 89, 13);
		contentPane.add(lblNoiDungGiaBan);
		
		JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp :");
		lblNhaCungCap.setBounds(237, 242, 93, 13);
		contentPane.add(lblNhaCungCap);
		
		JLabel lblNoiDungNCC = new JLabel("Dior");
		lblNoiDungNCC.setBounds(340, 242, 45, 13);
		contentPane.add(lblNoiDungNCC);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSize.setBounds(446, 127, 45, 24);
		contentPane.add(lblSize);
		
		JLabel lblSizeS = new JLabel("S");
		lblSizeS.setBounds(446, 173, 45, 13);
		contentPane.add(lblSizeS);
		
		JLabel lblSizeM = new JLabel("M");
		lblSizeM.setBounds(446, 196, 45, 13);
		contentPane.add(lblSizeM);
		
		JLabel lblSizeL = new JLabel("L");
		lblSizeL.setBounds(446, 219, 45, 13);
		contentPane.add(lblSizeL);
		
		JLabel lblSizeXL = new JLabel("XL");
		lblSizeXL.setBounds(446, 242, 45, 13);
		contentPane.add(lblSizeXL);
		
		JLabel lblSoLuong = new JLabel("Số Lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuong.setBounds(517, 127, 96, 24);
		contentPane.add(lblSoLuong);
		
		JLabel lblSoLuongSizeS = new JLabel("5");
		lblSoLuongSizeS.setBounds(517, 173, 45, 13);
		contentPane.add(lblSoLuongSizeS);
		
		JLabel lblSoLuongSizeM = new JLabel("5");
		lblSoLuongSizeM.setBounds(517, 196, 45, 13);
		contentPane.add(lblSoLuongSizeM);
		
		JLabel lblSoLuongSizeL = new JLabel("5");
		lblSoLuongSizeL.setBounds(517, 219, 45, 13);
		contentPane.add(lblSoLuongSizeL);
		
		JLabel lblSoLuongSizeXl = new JLabel("5");
		lblSoLuongSizeXl.setBounds(517, 242, 45, 13);
		contentPane.add(lblSoLuongSizeXl);
		
		JButton btnĐóng = new JButton("Đóng");
		btnĐóng.setBackground(Color.RED);
		btnĐóng.setBounds(237, 420, 85, 21);
		contentPane.add(btnĐóng);
	}

}
