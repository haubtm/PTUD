package Entity;

import java.util.List;

public class DataThongKeNhanVienNam {

	private List<NhanVien> danhSachNhanVien;
	private int tongSoHoaDon;
	public List<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}
	public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
	public int getTongSoHoaDon() {
		return tongSoHoaDon;
	}
	public void setTongSoHoaDon(int tongSoHoaDon) {
		this.tongSoHoaDon = tongSoHoaDon;
	}
	public DataThongKeNhanVienNam(List<NhanVien> danhSachNhanVien, int tongSoHoaDon) {
		super();
		this.danhSachNhanVien = danhSachNhanVien;
		this.tongSoHoaDon = tongSoHoaDon;
	}
	public DataThongKeNhanVienNam() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DataThongKeNhanVienNam [danhSachNhanVien=" + danhSachNhanVien + ", tongSoHoaDon=" + tongSoHoaDon + "]";
	}
	
	
}
