package Entity;

import java.util.Date;
import java.util.Objects;

public class HoaDon {
    private String maHoaDon;
    private Date ngayLapHoaDon;
    private float thue;
    private KhachHang khachHang;
    private NhanVien nhanVien;

	public HoaDon(String maHoaDon, Date ngayLapHoaDon, float thue, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.thue = thue;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public float getThue() {
		return thue;
	}

	public void setThue(float thue) {
		this.thue = thue;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(khachHang, maHoaDon, ngayLapHoaDon, nhanVien, thue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(khachHang, other.khachHang) && Objects.equals(maHoaDon, other.maHoaDon)
				&& Objects.equals(ngayLapHoaDon, other.ngayLapHoaDon) && Objects.equals(nhanVien, other.nhanVien)
				&& Float.floatToIntBits(thue) == Float.floatToIntBits(other.thue);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", thue=" + thue + ", khachHang="
				+ khachHang + ", nhanVien=" + nhanVien + "]";
	}
    
    
}
