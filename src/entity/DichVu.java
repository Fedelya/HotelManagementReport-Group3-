package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class DichVu {
	private int maDichVu;
	private String tenDichVu;
	private double donGia;
	
	public DichVu() {
	
	}
	public DichVu(int maDichVu) {
		
		this.maDichVu = maDichVu;
	}
	public DichVu(int maDichVu, String tenDichVu,  double donGia) {
		
		setMaDichVu(maDichVu);
		setTenDichVu(tenDichVu);
		
		setDonGia(donGia);
	}
	public int getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(int maDichVu) {
		if(maDichVu > 0) {
			this.maDichVu = maDichVu;
		}
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		if(!tenDichVu.trim().equals("")) {
			this.tenDichVu = tenDichVu;
		}else {
			this.tenDichVu = "Chưa cập nhật";
		}
	}
	
	
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		if(donGia > 0) {
			this.donGia = donGia;
		}else {
			this.donGia = 0.0;
		}
	}
	
	public DichVu(ResultSet rs) throws SQLException {
		this(rs.getInt("MaDV"), rs.getString("TenDV"), rs.getDouble("DonGia"));
	}
	
	
	
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ",  donGia="
				+ donGia + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu, tenDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return maDichVu == other.maDichVu && Objects.equals(tenDichVu, other.tenDichVu);
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(maDichVu);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		DichVu other = (DichVu) obj;
//		return maDichVu == other.maDichVu;
//	}
	
}
