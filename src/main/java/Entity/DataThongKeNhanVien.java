package Entity;

import java.util.List;

public class DataThongKeNhanVien {
	private List<NhanVien> danhSachNhanVien;
	private int tongSoHoaDon;
	private List<Integer> danhSachSoHoaDon;
	public List<Integer> getDanhSachSoHoaDon() {
		return danhSachSoHoaDon;
	}

	public void setDanhSachSoHoaDon(List<Integer> danhSachSoHoaDon) {
		this.danhSachSoHoaDon = danhSachSoHoaDon;
	}

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

	public DataThongKeNhanVien(List<NhanVien> danhSachNhanVien, int tongSoHoaDon,List<Integer> danhSachSoHoaDon) {
		super();
		this.danhSachNhanVien = danhSachNhanVien;
		this.tongSoHoaDon = tongSoHoaDon;
		this.danhSachSoHoaDon = danhSachSoHoaDon;
	}

	@Override
	public String toString() {
		return "DataThongKeNhanVien [danhSachNhanVien=" + danhSachNhanVien + ", tongSoHoaDon=" + tongSoHoaDon + "]";
	}
	
	// đánh index 
	public Integer getSoLuongHoaDon(int index) {
		  return danhSachSoHoaDon.get(index);
		}
}
