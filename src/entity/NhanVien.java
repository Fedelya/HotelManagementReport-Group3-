package entity;

import java.util.Date;
import java.util.Objects;

public class NhanVien {
	private String maNhanVien, tenNhanVien;
	private String quocTich;
	private String CCCD;
	private Date ngayHetHanCCCD;
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String quocTich, String cCCD, Date ngayHetHanCCCD) {
		super();
		setMaNhanVien(maNhanVien);
		setTenNhanVien(tenNhanVien);
		setQuocTich(quocTich);
		setCCCD(cCCD);
		setNgayHetHanCCCD(ngayHetHanCCCD);
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		if(!maNhanVien.trim().equals("")) {
			this.maNhanVien = maNhanVien;
		}else {
			this.maNhanVien = "Un-known";
		}
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		if(!tenNhanVien.trim().equals("")) {
			this.tenNhanVien = tenNhanVien;
		}else {
			this.tenNhanVien = "Un-known";
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
		return Objects.hash(maNhanVien);
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
		return Objects.equals(maNhanVien, other.maNhanVien);
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", quocTich=" + quocTich
				+ ", CCCD=" + CCCD + ", ngayHetHanCCCD=" + ngayHetHanCCCD + "]";
	}
	
	
}
