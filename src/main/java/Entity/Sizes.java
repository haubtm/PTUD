package Entity;

import java.util.Objects;

public class Sizes {
	private String maSize;
	private String tenSize;
	
	public Sizes() {
	}

	public Sizes(String maSize) {
		this.maSize = maSize;
	}

	public Sizes(String maSize, String tenSize) {
		this.maSize = maSize;
		this.tenSize = tenSize;
	}

	public String getMaSize() {
		return maSize;
	}

	public void setMaSize(String maSize) {
		this.maSize = maSize;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

	@Override
	public String toString() {
		return "Sizes [maSize=" + maSize + ", tenSize=" + tenSize + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sizes other = (Sizes) obj;
		return Objects.equals(maSize, other.maSize);
	}
	
	
	
	

}
