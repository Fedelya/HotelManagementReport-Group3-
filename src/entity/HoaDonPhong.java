package entity;

import java.sql.*;

public class HoaDonPhong {
	private int maHoaDon;
	private int tinhTrang;
	private Date ngayGioNhan;
	private Date ngayGioTra;
	
	private Phong phong;
	private KhachHang khachHang;
	public HoaDonPhong() {
		super();
	}
	public HoaDonPhong(int maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	
	
	
	public HoaDonPhong(int tinhTrang, Date ngayGioNhan, Date ngayGioTra, Phong phong, KhachHang khachHang) {
		super();
		this.tinhTrang = tinhTrang;
		this.ngayGioNhan = ngayGioNhan;
		this.ngayGioTra = ngayGioTra;
		this.phong = phong;
		this.khachHang = khachHang;
	}
	public HoaDonPhong(int maHoaDon, int tinhTrang, Date ngayGioNhan, Date ngayGioTra, Phong phong,
			KhachHang khachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.tinhTrang = tinhTrang;
		this.ngayGioNhan = ngayGioNhan;
		this.ngayGioTra = ngayGioTra;
		this.phong = phong;
		this.khachHang = khachHang;
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public Date getNgayGioNhan() {
		return ngayGioNhan;
	}
	public void setNgayGioNhan(Date ngayGioNhan) {
		this.ngayGioNhan = ngayGioNhan;
	}
	public Date getNgayGioTra() {
		return ngayGioTra;
	}
	public void setNgayGioTra(Date ngayGioTra) {
		this.ngayGioTra = ngayGioTra;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	public int compareDate(Date d1, Date d2) {
        if (d1.toString().equals(d2.toString()))
            return 0;

        if (d1.before(d2))
            return -1;

        return 1;
    }
	
	public HoaDonPhong(ResultSet rs) throws SQLException {
        LoaiPhong loaiPhong = new LoaiPhong(rs.getInt("MaLoaiPhong"), rs.getString("TenLoaiPhong"),
                rs.getDouble("DonGia"));
        Phong phong = new Phong(rs.getString("MaPhong"),
                rs.getString("ViTri"), rs.getInt("TinhTrangP"), loaiPhong);
        KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("QuocTich"),rs.getString("CCCD"), rs.getDate("NgayHetHanCCCD"));

        this.maHoaDon = rs.getInt("MaHD");
        this.tinhTrang = rs.getInt("TinhTrangHD");
        this.ngayGioNhan = rs.getDate("NgayGioNhan");
        this.ngayGioTra = rs.getDate("NgayGioTra");
        this.phong = phong;
        this.khachHang = kh;
    }
}
