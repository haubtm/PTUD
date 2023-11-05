package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;

public class ViewSuaSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenSanPham;
	private JTextField txtMoTa;
	private JTextField txtMauSac;
	private JTextField txtXuatSu;
	private JTextField txtGiaNhap;
	private JTextField txtSizeS;
	private JTextField txtSizeM;
	private JTextField txtSizeL;
	private JTextField txtSizeXL;
	private JLabel lblhinhanhsanpham;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewThemSanPham frame = new ViewThemSanPham();
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
	public ViewSuaSanPham() {
		setTitle("Thêm Sản Phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaSanPham = new JLabel("SP202300001");
		lblMaSanPham.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaSanPham.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaSanPham.setBounds(10, 10, 617, 28);
		contentPane.add(lblMaSanPham);
		
		JPanel pnlhinhanhsanpham = new JPanel();
		pnlhinhanhsanpham.setBackground(Color.WHITE);
		pnlhinhanhsanpham.setBounds(26, 76, 163, 158);
		contentPane.add(pnlhinhanhsanpham);
		pnlhinhanhsanpham.setLayout(null);
		 
		final JLabel lblhinhanhsanpham = new JLabel("");
		lblhinhanhsanpham.setHorizontalAlignment(SwingConstants.CENTER);
		lblhinhanhsanpham.setBounds(0, 0, 163, 158);
		pnlhinhanhsanpham.add(lblhinhanhsanpham);
		
		JButton btnTaiLen = new JButton("Tải Lên");
		btnTaiLen.setBounds(67, 244, 85, 21);
		contentPane.add(btnTaiLen);
		btnTaiLen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage image = ImageIO.read(selectedFile);
                        Image scaledImage = image.getScaledInstance(lblhinhanhsanpham.getWidth(), lblhinhanhsanpham.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaledImage);
                        lblhinhanhsanpham.setIcon(icon);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm :");
		lblTenSanPham.setBounds(242, 48, 95, 13);
		contentPane.add(lblTenSanPham);
		
		txtTenSanPham = new JTextField();
		txtTenSanPham.setBounds(337, 45, 180, 19);
		contentPane.add(txtTenSanPham);
		txtTenSanPham.setColumns(10);
		
		JLabel lblMoTa = new JLabel("Mô Tả :");
		lblMoTa.setBounds(242, 73, 45, 13);
		contentPane.add(lblMoTa);
		
		txtMoTa = new JTextField();
		txtMoTa.setBounds(337, 70, 180, 19);
		contentPane.add(txtMoTa);
		txtMoTa.setColumns(10);
		
		JLabel lblMauSac = new JLabel("Màu Sắc :");
		lblMauSac.setBounds(242, 99, 71, 13);
		contentPane.add(lblMauSac);
		
		txtMauSac = new JTextField();
		txtMauSac.setBounds(337, 96, 180, 19);
		contentPane.add(txtMauSac);
		txtMauSac.setColumns(10);
		
		JLabel lblXuatSu = new JLabel("Xuất Sứ :  ");
		lblXuatSu.setBounds(242, 122, 71, 13);
		contentPane.add(lblXuatSu);
		
		txtXuatSu = new JTextField();
		txtXuatSu.setBounds(337, 119, 180, 19);
		contentPane.add(txtXuatSu);
		txtXuatSu.setColumns(10);
		
		JLabel lblLoaiSanPham = new JLabel("Loại Sản Phẩm :");
		lblLoaiSanPham.setBounds(242, 152, 95, 13);
		contentPane.add(lblLoaiSanPham);
		
		JComboBox cbxLoaiSanPham = new JComboBox();
		cbxLoaiSanPham.setModel(new DefaultComboBoxModel(new String[] {"Loại Sản Phẩm", "Áo ", "Quần", "Váy", "Phụ Kiện"}));
		cbxLoaiSanPham.setBounds(337, 148, 180, 21);
		contentPane.add(cbxLoaiSanPham);
		
		JLabel lblGiaNhap = new JLabel("Giá Nhập :");
		lblGiaNhap.setBounds(242, 182, 71, 13);
		contentPane.add(lblGiaNhap);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setBounds(337, 179, 180, 19);
		contentPane.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);
		
		JLabel lblNhaCungCap = new JLabel("Nhà Cung Cấp : ");
		lblNhaCungCap.setBounds(242, 211, 95, 13);
		contentPane.add(lblNhaCungCap);
		
		JComboBox cbxNhaCungCap = new JComboBox();
		cbxNhaCungCap.setModel(new DefaultComboBoxModel(new String[] {"Dior", "Louis Vuitton"}));
		cbxNhaCungCap.setBounds(337, 208, 180, 21);
		contentPane.add(cbxNhaCungCap);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoLuong.setBounds(242, 309, 95, 28);
		contentPane.add(lblSoLuong);
		
		JLabel lblSizeS = new JLabel("S :");
		lblSizeS.setBounds(337, 276, 45, 13);
		contentPane.add(lblSizeS);
		
		txtSizeS = new JTextField();
		txtSizeS.setText("");
		txtSizeS.setBounds(365, 273, 96, 19);
		contentPane.add(txtSizeS);
		txtSizeS.setColumns(10);
		
		JLabel lblSizeM = new JLabel("M :");
		lblSizeM.setBounds(337, 309, 45, 13);
		contentPane.add(lblSizeM);
		
		txtSizeM = new JTextField();
		txtSizeM.setBounds(365, 306, 96, 19);
		contentPane.add(txtSizeM);
		txtSizeM.setColumns(10);
		
		JLabel lblSizeL = new JLabel("L :");
		lblSizeL.setBounds(337, 335, 45, 13);
		contentPane.add(lblSizeL);
		
		txtSizeL = new JTextField();
		txtSizeL.setBounds(365, 332, 96, 19);
		contentPane.add(txtSizeL);
		txtSizeL.setColumns(10);
		
		JLabel lblSizeXL = new JLabel("XL :");
		lblSizeXL.setBounds(337, 361, 45, 13);
		contentPane.add(lblSizeXL);
		
		txtSizeXL = new JTextField();
		txtSizeXL.setText("");
		txtSizeXL.setBounds(365, 358, 96, 19);
		contentPane.add(txtSizeXL);
		txtSizeXL.setColumns(10);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnLuu.setBounds(242, 442, 85, 35);
		contentPane.add(btnLuu);
		
		JButton btnXoaTrang = new JButton("Xoá Trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoaTrang.setBounds(359, 442, 102, 35);
		contentPane.add(btnXoaTrang);
		

		

		
		
		
		
	}
}
