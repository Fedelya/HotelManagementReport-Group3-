package entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import dao.ChiTietDichVu_DAO;

public class HoaDonDichVu {
	private int maHoaDonDichVu;
	private int tinhTrang;
	private Date ngayGioDat;
	private KhachHang khachHang;
	private ChiTietDichVu_DAO ctdv_dao;

	public HoaDonDichVu() {
		super();
	}

	public HoaDonDichVu(int maHoaDonDichVu) {
		super();
		this.maHoaDonDichVu = maHoaDonDichVu;
	}
	
	public HoaDonDichVu(int maHoaDonDichVu, Date ngayGioDat, KhachHang khachHang) {
		this.maHoaDonDichVu = maHoaDonDichVu;
		this.ngayGioDat = ngayGioDat;
		this.khachHang = khachHang;
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
	public ArrayList<ChiTietDichVu> getCTDV(){
		ctdv_dao = new ChiTietDichVu_DAO();
		return ctdv_dao.getChiTietDVByMaHDDV(this.maHoaDonDichVu);
	}
	public double tinhTong() {
		ArrayList<ChiTietDichVu> listCTDV = getCTDV();
		double tong =0;
		for(int i=0;i<listCTDV.size();i++) {
			DichVu dv = listCTDV.get(i).getDichVu();
			tong += dv.getDonGia()*listCTDV.get(i).getSoLuong();
		}
		return tong;
	}
}
