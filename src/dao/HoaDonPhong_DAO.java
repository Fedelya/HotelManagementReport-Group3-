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
import entity.HoaDonPhong;
import entity.KhachHang;
import entity.Phong;

public class HoaDonPhong_DAO {
	
	private static HoaDonPhong_DAO instance = new HoaDonPhong_DAO();

    public static HoaDonPhong_DAO getInstance() {
        return instance;
    }
	public ArrayList<HoaDonPhong> getalltbHoaDonPhong() {
		ArrayList<HoaDonPhong> dsHoaDonPhong = new ArrayList<HoaDonPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from dbo.HoaDonPhong";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while(rs.next()) {
				int MaHD = rs.getInt(1);
				KhachHang kh = new KhachHang(rs.getString("MaKH"));
				Phong maPhong = new Phong(rs.getString(3));
				int tinhTrang = rs.getInt(4);
				Date NgayGioNhan = rs.getDate(5);
				Date NgayGioTra = rs.getDate(6);
				
				HoaDonPhong phong = new HoaDonPhong(MaHD, tinhTrang, NgayGioNhan, NgayGioTra, maPhong, kh);
				dsHoaDonPhong.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDonPhong;
	}
	public boolean themHDP(HoaDonPhong hdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			String sql = "insert into dbo.HoaDonPhong (MaHD,MaKH,MaPhong,TinhTrang, NgayGioNhan,NgayGioTra)"+" values (?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, hdp.getMaHoaDon());
			stmt.setString(2, hdp.getKhachHang().getMaKhachHang());
			stmt.setString(3,hdp.getPhong().getMaPhong());
			stmt.setInt(4,hdp.getTinhTrang());
			stmt.setDate(5, hdp.getNgayGioNhan());
			stmt.setDate(6, hdp.getNgayGioTra());
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
	public boolean updateHDP(HoaDonPhong hdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			String sql = "update dbo.HoaDonPhong set MaKH=?,MaPhong=?,TinhTrang=?,NgayGioNhan=?,NgayGioTra=?" + "where MaHD=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, hdp.getMaHoaDon());
			stmt.setString(2, hdp.getKhachHang().getMaKhachHang());
			stmt.setString(3,hdp.getPhong().getMaPhong());
			stmt.setInt(4,hdp.getTinhTrang());
			stmt.setDate(5, hdp.getNgayGioNhan());
			stmt.setDate(6, hdp.getNgayGioTra());
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
	public boolean deleteHDP(int id) {
		int n=0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		String sql = "delete from dbo.HoaDonPhong where MaHD=?";
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



















