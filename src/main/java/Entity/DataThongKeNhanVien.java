package Entity;

import java.util.List;

public class DataThongKeNhanVien {
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

	public DataThongKeNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataThongKeNhanVien(List<NhanVien> danhSachNhanVien, int tongSoHoaDon) {
		super();
		this.danhSachNhanVien = danhSachNhanVien;
		this.tongSoHoaDon = tongSoHoaDon;
	}

	@Override
	public String toString() {
		return "DataThongKeNhanVien [danhSachNhanVien=" + danhSachNhanVien + ", tongSoHoaDon=" + tongSoHoaDon + "]";
	}
}
