package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Date;
import java.sql.PreparedStatement;

import connectDB.ConnectDB;
import entity.HoaDonDichVu;
import entity.KhachHang;

public class HoaDonDichVu_DAO {
	
	private static HoaDonDichVu_DAO instance = new HoaDonDichVu_DAO();

    public static HoaDonDichVu_DAO getInstance() {
        return instance;
    }
	public ArrayList<HoaDonDichVu> getalltbHoaDonDichVu() {
		ArrayList<HoaDonDichVu> dsHoaDonDichVu = new ArrayList<HoaDonDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from dbo.HoaDonDichVu";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while(rs.next()) {
				int MaHDDV = rs.getInt(1);
				int tinhTrang = rs.getInt(2);
				Date NgayGioDat = rs.getDate(3);
				KhachHang maKH = new KhachHang(rs.getString(4));
				
				HoaDonDichVu kh = new HoaDonDichVu(MaHDDV, tinhTrang, NgayGioDat, maKH);
				dsHoaDonDichVu.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDonDichVu;
	}
	public boolean themHoaDonDichVu(HoaDonDichVu hddv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			String sql = "insert into dbo.HoaDonDichVu (MaHDDV,TinhTrang,NgayGioDat,MaKH)"+" values (?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, hddv.getMaHoaDonDichVu());
			stmt.setInt(2, hddv.getTinhTrang());
			stmt.setDate(3,hddv.getNgayGioDat());
			stmt.setString(4,hddv.getKhachHang().getMaKhachHang());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean updateHDDV(HoaDonDichVu hddv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			String sql = "update dbo.HoaDonDichVu set TinhTrang=?, NgayGioDat=?,MaKH=?" + "where MaHDDV=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, hddv.getMaHoaDonDichVu());
			stmt.setInt(1, hddv.getMaHoaDonDichVu());
			stmt.setInt(2, hddv.getTinhTrang());
			stmt.setDate(3,hddv.getNgayGioDat());
			stmt.setString(4,hddv.getKhachHang().getMaKhachHang());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	public boolean deleteHDDV(int id) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from dbo.HoaDonDichVu where MaHDDV=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
}
