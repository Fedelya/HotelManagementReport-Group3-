package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
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
			this.maKhachHang = "Chưa cập nhật";
		}
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		if(!tenKhachHang.trim().equals("")) {
			this.tenKhachHang = tenKhachHang;
		}else {
			this.tenKhachHang = "Chưa cập nhật";
		}
	}
	public String getQuocTich() {
		return quocTich;
	}
	public void setQuocTich(String quocTich) {
		if((quocTich.equalsIgnoreCase("Việt Nam" )) || (quocTich.equalsIgnoreCase("Nước ngoài"))) {
			this.quocTich = quocTich;
		}else {
			this.quocTich = "Việt Nam";
		}
	}
	public String getCCCD() {
		return CCCD;
	}
	public void setCCCD(String cCCD) {
		if(!cCCD.trim().equals("")) {
			this.CCCD = cCCD;
		}else {
			this.CCCD = "Chưa cập nhật";
		}
	}
	public Date getNgayHetHanCCCD() {
		return ngayHetHanCCCD;
	}
	public void setNgayHetHanCCCD(Date ngayHetHanCCCD) {
		this.ngayHetHanCCCD = ngayHetHanCCCD;
	}
	
	public KhachHang(ResultSet rs) throws SQLException {
		this(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("QuocTich"),rs.getString("CCCD"), rs.getDate("NgayHetHanCCCD"));
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
