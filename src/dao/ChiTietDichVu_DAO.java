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
import entity.ChiTietDichVu;
import entity.DichVu;
import entity.HoaDonDichVu;
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
	
	public ArrayList<ChiTietDichVu> getChiTietDVByMaHDDV(int maHDDV) {
		ArrayList<ChiTietDichVu> dataList = new ArrayList<ChiTietDichVu>();
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql ="select * from ChiTietDichVu join DichVu on chiTietDichVu.MaDV = DichVu.MaDV where MaHDDV = ?";
					//"select * from ChiTietDV join DichVu on chiTietDV.maDV = DichVu.maDV where maHDDV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, maHDDV);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int soLuong = rs.getInt("SoLuong");
				int maDV = rs.getInt("MaDV");
				String tenDV = rs.getString("TenDV");
				double donGia = rs.getDouble("DonGia");
				DichVu dv = new DichVu(maDV, tenDV, donGia);
				Date date = rs.getDate("NgayGioDat");
				int maHD = rs.getInt("MaHDDV");
				HoaDonDichVu hddv = new HoaDonDichVu(maHD);
				ChiTietDichVu ctdv = new ChiTietDichVu(dv,hddv,soLuong, date);
				dataList.add(ctdv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public ArrayList<ChiTietDichVu> getListCTDVByDate(Date tuNgay, Date denNgay){
		ArrayList<ChiTietDichVu> dataList = new ArrayList<ChiTietDichVu>();
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "EXEC Proc_LocChiTietHoaDonTheoNgay ?, ?";
			statement = con.prepareStatement(sql);
			statement.setDate(1, tuNgay);
			statement.setDate(2, denNgay);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				ChiTietDichVu chiTietDichVu = new ChiTietDichVu(rs);
				dataList.add(chiTietDichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}
	
}
