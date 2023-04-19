package entity;

import java.sql.*;
import java.util.Objects;

public class Phong {
	private String maPhong;
	private String viTri;
	private int tinhTrang;
	private LoaiPhong loaiPhong;
	public Phong() {
		super();
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	public Phong(String maPhong, String viTri, int tinhTrang, LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.viTri = viTri;
		this.tinhTrang = tinhTrang;
		this.loaiPhong = loaiPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTrinhTrang(int trinhTrang) {
		this.tinhTrang = trinhTrang;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	
	public Phong(ResultSet rs) throws SQLException {
        this.maPhong = rs.getString("MaPhong");
        this.viTri = rs.getString("ViTri");
        this.tinhTrang = rs.getInt("TinhTrang");
        this.loaiPhong = new LoaiPhong(rs.getInt("MaLoaiPhong"));
    }
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", viTri=" + viTri + ", tinhTrang=" + tinhTrang + ", loaiPhong="
				+ loaiPhong + "]";
	}
	
	
}
