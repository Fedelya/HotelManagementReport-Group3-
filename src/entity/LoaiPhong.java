package entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoaiPhong {
	private int maLoaiPhong;
	private String tenLoaiPhong;
	private double donGia;

	public LoaiPhong() {
		super();
	}

	public LoaiPhong(int maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}

	public LoaiPhong(int maLoaiPhong, String tenLoaiPhong, double donGia) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		setDonGia(donGia);
	}

	public int getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(int maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}

	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
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

	public LoaiPhong(ResultSet rs) throws SQLException {
		this(rs.getInt("MaLoaiPhong"), rs.getString("TenLoaiPhong"), rs.getDouble("DonGia"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenLoaiPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(tenLoaiPhong, other.tenLoaiPhong);
	}
	
	
}
