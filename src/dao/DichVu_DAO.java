package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;

public class DichVu_DAO {
	private static DichVu_DAO instance = new DichVu_DAO();

	public static DichVu_DAO getInstance() {
		return instance;
	}
	public ArrayList<DichVu> getalltbDichVu(){
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int maDV = rs.getInt("MaDV");
				String tenDV = rs.getString("TenDV");
				double donG = rs.getDouble("DonGia");

				DichVu dv = new DichVu(maDV, tenDV, donG);
				
				dsDichVu.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}
		return dsDichVu;
	}
	public boolean insert(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into dbo.DichVu (MaDV, TenDV, DonGia)" + "values (?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, dv.getMaDichVu());
			statement.setString(2, dv.getTenDichVu());
			statement.setDouble(3, dv.getDonGia());
			
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(DichVu dv) {
		int n = 0;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "update dbo.DichVu set TenDV = ?, DonGia = ?" + " Where MaDV = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, dv.getTenDichVu());
			stmt.setDouble(2, dv.getDonGia());
			stmt.setInt(3, dv.getMaDichVu());
			

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean delete(int ma) {
		int n = 0;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "delete from dbo.DichVu where MaDV = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setInt(1, ma);

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public ArrayList<DichVu> getDichVuTheoMa(int madv) {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		PreparedStatement statement = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from DichVu where MaDV = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, madv);
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {
				int maDV = rs.getInt("MaDV");
				String tenDV = rs.getString("TenDV");
				double gia = rs.getDouble("DonGia");

				DichVu lp = new DichVu(maDV, tenDV, gia);
				dsdv.add(lp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return dsdv;

	}
	public int getCountPhongByMaDichVu(int maDV) {
		int count = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MaDV FROM dbo.DichVu dv where dv.maDV = ?";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, maDV);

			rs = stmt.executeQuery();
			rs.last();
			// đến số dòng được trả về
			count = rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
}
