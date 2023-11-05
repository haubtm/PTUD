package Entity;

import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String hoTen;
	private String soDienThoai;
	private boolean gioiTinh;
	private String diaChi;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public KhachHang(String maKhachHang, String hoTen, String soDienThoai, boolean gioiTinh, String diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(diaChi, gioiTinh, hoTen, maKhachHang, soDienThoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(diaChi, other.diaChi) && gioiTinh == other.gioiTinh && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(maKhachHang, other.maKhachHang) && Objects.equals(soDienThoai, other.soDienThoai);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}
	
	
}
