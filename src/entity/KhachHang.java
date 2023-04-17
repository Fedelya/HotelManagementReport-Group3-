package entity;

import java.util.Date;
import java.util.Objects;

public class KhachHang {
	private String maKhachHang, tenKhachHang;
	private String quocTich;
	private String CCCD;
	private Date ngayHetHanCCCD;
	public KhachHang() {
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public KhachHang(String maKhachHang, String tenKhachHang, String quocTich, String cCCD, Date ngayHetHanCCCD) {
		super();
		setMaKhachHang(maKhachHang);
		setTenKhachHang(tenKhachHang);
		setQuocTich(quocTich);
		setCCCD(cCCD);
		setNgayHetHanCCCD(ngayHetHanCCCD);
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		if(!maKhachHang.trim().equals("")) {
			this.maKhachHang = maKhachHang;
		}else {
			this.maKhachHang = "Un-known";
		}
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		if(!tenKhachHang.trim().equals("")) {
			this.tenKhachHang = tenKhachHang;
		}else {
			this.tenKhachHang = "Un-known";
		}
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		if(!quocTich.trim().equals("")) {
			this.quocTich = quocTich;
		}else {
			this.quocTich = "Un-known";
		}
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		if(!cCCD.trim().equals("")) {
			this.CCCD = cCCD;
		}else {
			this.CCCD = "Un-known";
		}
	}
	public Date getNgayHetHanCCCD() {
		return ngayHetHanCCCD;
	}
	public void setNgayHetHanCCCD(Date ngayHetHanCCCD) {
		this.ngayHetHanCCCD = ngayHetHanCCCD;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
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
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", quocTich=" + quocTich
				+ ", CCCD=" + CCCD + ", ngayHetHanCCCD=" + ngayHetHanCCCD + "]";
	}
	
	
}
