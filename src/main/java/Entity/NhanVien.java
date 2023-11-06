package Entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String canCuoc;
	private String soDienThoai;
	private String diaChi;
	private String chucVu;
	private String hinhAnh;
	
	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, boolean gioiTinh, String canCuoc,
			String soDienThoai, String diaChi, String chucVu, String hinhAnh) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.canCuoc = canCuoc;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.hinhAnh = hinhAnh;
	}
	
	

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCanCuoc() {
		return canCuoc;
	}

	public void setCanCuoc(String canCuoc) {
		this.canCuoc = canCuoc;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(canCuoc, chucVu, diaChi, gioiTinh, hinhAnh, maNhanVien, ngaySinh, soDienThoai, tenNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(canCuoc, other.canCuoc) && Objects.equals(chucVu, other.chucVu)
				&& Objects.equals(diaChi, other.diaChi) && gioiTinh == other.gioiTinh
				&& Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maNhanVien, other.maNhanVien)
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenNhanVien, other.tenNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", canCuoc=" + canCuoc + ", soDienThoai=" + soDienThoai + ", diaChi="
				+ diaChi + ", chucVu=" + chucVu + ", hinhAnh=" + hinhAnh + "]";
	}

}
