package entity;

import java.sql.*;
import java.util.Objects;

public class HoaDonDichVu {
	private int maHoaDonDichVu;
	private int tinhTrang;
	private Date ngayGioDat;
	private KhachHang khachHang;

	public HoaDonDichVu() {
		super();
	}

	public HoaDonDichVu(int maHoaDonDichVu) {
		super();
		this.maHoaDonDichVu = maHoaDonDichVu;
	}

	public HoaDonDichVu(int maHoaDonDichVu, int tinhTrang, Date ngayGioDat, KhachHang khachHang) {
		super();
		this.maHoaDonDichVu = maHoaDonDichVu;
		this.tinhTrang = tinhTrang;
		this.ngayGioDat = ngayGioDat;
		this.khachHang = khachHang;
	}

	public int getMaHoaDonDichVu() {
		return maHoaDonDichVu;
	}

	public void setMaHoaDonDichVu(int maHoaDonDichVu) {
		this.maHoaDonDichVu = maHoaDonDichVu;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getNgayGioDat() {
		return ngayGioDat;
	}

	public void setNgayGioDat(Date ngayGioDat) {
		this.ngayGioDat = ngayGioDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public HoaDonDichVu(ResultSet rs) throws SQLException {
		this(rs.getInt("MaHDDV"), rs.getInt("TinhTrang"), rs.getDate("NgayGioDat"),
				new KhachHang(rs.getString("MaKH")));
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHoaDonDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonDichVu other = (HoaDonDichVu) obj;
		return maHoaDonDichVu == other.maHoaDonDichVu;
	}

	@Override
	public String toString() {
		return "HoaDonDichVu [maHoaDonDichVu=" + maHoaDonDichVu + ", tinhTrang=" + tinhTrang + ", ngayGioDat="
				+ ngayGioDat + ", khachHang=" + khachHang + "]";
	}

}
