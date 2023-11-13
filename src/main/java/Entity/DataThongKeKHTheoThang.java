package Entity;

import java.util.List;

public class DataThongKeKHTheoThang {
	private List<KhachHang> danhSachKhachHang;
	public List<Integer> getDanhSachSoHoaDon() {
		return danhSachSoHoaDon;
	}
	public void setDanhSachSoHoaDon(List<Integer> danhSachSoHoaDon) {
		this.danhSachSoHoaDon = danhSachSoHoaDon;
	}
	private int tongSoHoaDon;
	private List<Integer> danhSachSoHoaDon;
	
	public List<KhachHang> getDanhSachKhachHang() {
		return danhSachKhachHang;
	}
	public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
		this.danhSachKhachHang = danhSachKhachHang;
	}
	public int getTongSoHoaDon() {
		return tongSoHoaDon;
	}
	public void setTongSoHoaDon(int tongSoHoaDon) {
		this.tongSoHoaDon = tongSoHoaDon;
	}
	public DataThongKeKHTheoThang(List<KhachHang> danhSachKhachHang, int tongSoHoaDon,List<Integer> danhSachSoHoaDon) {
		super();
		this.danhSachKhachHang = danhSachKhachHang;
		this.tongSoHoaDon = tongSoHoaDon;
		this.danhSachSoHoaDon = danhSachSoHoaDon;
	}
	@Override
	public String toString() {
		return "DataThongKeKHTheoNgay [danhSachKhachHang=" + danhSachKhachHang + ", tongSoHoaDon=" + tongSoHoaDon + "]";
	}
	
	// đánh index 
	public Integer getSoLuongHoaDon(int index) {
		  return danhSachSoHoaDon.get(index);
		}
}
