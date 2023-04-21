package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDonDichVu;
import entity.KhachHang;
import entity.LoaiPhong;

public class ChiTietDichVu_DAO {
	
	public ArrayList<ChiTietDichVu> getallChiTietDichVu() {
		ArrayList<ChiTietDichVu> dsCTDV = new ArrayList<ChiTietDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.ChiTietDichVu";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				DichVu maDichVu = new DichVu(rs.getInt("MaDV"));
				HoaDonDichVu maHDDV= new HoaDonDichVu(rs.getInt("MaHDDV"));
				
				int soluong = rs.getInt("SoLuong");
				Date ngayDat = rs.getDate("NgayGioDat");

				ChiTietDichVu ctdv = new ChiTietDichVu(maDichVu, maHDDV, soluong, ngayDat);
				dsCTDV.add(ctdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsCTDV;
		
	}
	public boolean insert(ChiTietDichVu ctdv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into dbo.ChiTietDichVu (MaHDDV, MaDV, SoLuong, NgayGioDat" + "values (?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, ctdv.getHoaDonDichVu().getMaHoaDonDichVu());
			statement.setInt(2, ctdv.getDichVu().getMaDichVu());
			statement.setInt(3, ctdv.getSoLuong());
			statement.setDate(4, ctdv.getNgayGioDat());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

//	public boolean update(ChiTietDichVu ctdv) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		int n = 0;
//		try {
//			String sql = "update dbo.ChiTietDichVu" + " set MaHDDV = ?, MaDV = ?, SoLuong = ?, NgayGioDat = ?"
//					+ " where MaKH = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, kh.getTenKhachHang());
//			statement.setString(2, kh.getQuocTich());
//			statement.setString(3, kh.getCCCD());
//			statement.setDate(4, kh.getNgayHetHanCCCD());
//			statement.setString(5, kh.getMaKhachHang());
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
//
//	public boolean delete(KhachHang kh) {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		int n = 0;
//		try {
//			String sql = "delete from dbo.KhachHang" + " where MaKH = ?";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, kh.getMaKhachHang());
//			n = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
//}
	
	

}
