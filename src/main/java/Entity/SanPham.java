package Entity;

import java.util.Objects;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private double giaNhap;
	private double giaBan;
	private String mauSac;
	private String xuatXu;
	private String moTa;
	private String hinhAnh;
    private LoaiSanPham loaiSanPham;
    private NhaCungCap nhaCungCap;
    
	
	
	public SanPham() {
		
	}


	public SanPham(String maSanPham) {
		
		this.maSanPham = maSanPham;
	}


	public SanPham(String maSanPham, String tenSanPham, double giaNhap, double giaBan, String mauSac, String xuatXu,
			String moTa, String hinhAnh, LoaiSanPham loaiSanPham, NhaCungCap nhaCungCap) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.mauSac = mauSac;
		this.xuatXu = xuatXu;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.loaiSanPham = loaiSanPham;
		this.nhaCungCap = nhaCungCap;
	}


	public String getMaSanPham() {
		return maSanPham;
	}


	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}


	public String getTenSanPham() {
		return tenSanPham;
	}


	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}


	public double getGiaNhap() {
		return giaNhap;
	}


	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}


	public double getGiaBan() {
		return giaBan;
	}


	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}


	public String getMauSac() {
		return mauSac;
	}


	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}


	public String getXuatXu() {
		return xuatXu;
	}


	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}


	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}


    


	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}


	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}


	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaNhap=" + giaNhap + ", giaBan="
				+ giaBan + ", mauSac=" + mauSac + ", xuatSu=" + xuatXu + ", moTa=" + moTa + ", hinhAnh=" + hinhAnh
				+ ", loaiSanPham=" + loaiSanPham + ", nhaCungCap=" + nhaCungCap + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(maSanPham);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPham, other.maSanPham);
	}
}