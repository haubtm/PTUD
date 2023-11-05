package Entity;

public class SanPham_Sizes {
	private Sizes sizes;
	private SanPham sanPham;
	private int soLuong;
	
	public SanPham_Sizes() {
	}
    
	public SanPham_Sizes(Sizes sizes) {
		this.sizes = sizes;
	}
	

	public SanPham_Sizes(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public SanPham_Sizes(Sizes sizes, SanPham sanPham) {
		this.sizes = sizes;
		this.sanPham = sanPham;
	}

	public SanPham_Sizes(Sizes sizes, SanPham sanPham, int soLuong) {
		this.sizes = sizes;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public Sizes getSizes() {
		return sizes;
	}

	public void setSizes(Sizes sizes) {
		this.sizes = sizes;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "SanPham_Sizes [sizes=" + sizes + ", sanPham=" + sanPham + ", soLuong=" + soLuong + "]";
	}
	
	
	
	
	

}
