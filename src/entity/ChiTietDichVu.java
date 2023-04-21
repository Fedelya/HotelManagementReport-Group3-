package entity;

import java.sql.*;

public class ChiTietDichVu {
	private DichVu dichVu;
	private HoaDonDichVu hoaDonDichVu;
	private int soLuong;
	private Date ngayGioDat;

	public Date getNgayGioDat() {
		return ngayGioDat;
	}

	public void setNgayGioDat(Date ngayGioDat) {
		this.ngayGioDat = ngayGioDat;
	}

	public ChiTietDichVu() {
		super();
	}

	public ChiTietDichVu(DichVu dichVu, HoaDonDichVu hoaDonDichVu, int soLuong, Date ngayGioDat) {
		super();
		this.dichVu = dichVu;
		this.hoaDonDichVu = hoaDonDichVu;
		setSoLuong(soLuong);
		this.ngayGioDat = ngayGioDat;
	}

	public ChiTietDichVu(DichVu dichVu, HoaDonDichVu hoaDonDichVu, int soLuong) {
		super();
		this.dichVu = dichVu;
		this.hoaDonDichVu = hoaDonDichVu;
		this.soLuong = soLuong;
	}

	public ChiTietDichVu(DichVu dichVu, int soLuong) {
		super();
		this.dichVu = dichVu;
		this.soLuong = soLuong;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public HoaDonDichVu getHoaDonDichVu() {
		return hoaDonDichVu;
	}

	public void setHoaDonDichVu(HoaDonDichVu hoaDonDichVu) {
		this.hoaDonDichVu = hoaDonDichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong > 0) {
			this.soLuong = soLuong;
		} else {
			this.soLuong = 0;
		}
	}

	public ChiTietDichVu(ResultSet rs) throws SQLException {
		KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("QuocTich"),rs.getString("CCCD"), rs.getDate("NgayHetHanCCCD"));
		HoaDonDichVu hoaDonDichVu = new HoaDonDichVu(rs.getInt("MaHDDV"), rs.getInt("SoLuong"), rs.getDate("NgayGioDat"), kh);
		DichVu dv = new DichVu(rs.getInt("MaDV"), rs.getString("TenDV"), rs.getDouble("DonGia"));

		setSoLuong(rs.getInt("SoLuong"));
		this.ngayGioDat = rs.getDate("NgayGioDat");
		this.hoaDonDichVu = hoaDonDichVu;
		this.dichVu = dv;
	}
}
