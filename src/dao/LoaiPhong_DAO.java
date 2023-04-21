package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Phong;

import entity.LoaiPhong;

public class LoaiPhong_DAO {
	public LoaiPhong_DAO() {

	}

	public ArrayList<LoaiPhong> getallLoaiPhong() {
		ArrayList<LoaiPhong> dsLP = new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.LoaiPhong";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				int maPhong = rs.getInt("MaLoaiPhong");
				String tenLPhong = rs.getString("TenLoaiPhong");
				double gia = rs.getDouble("DonGia");

				LoaiPhong p = new LoaiPhong(maPhong, tenLPhong, gia);
				dsLP.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLP;
	}

	public ArrayList<LoaiPhong> getLoaiPhongTheoMa(int idlp) {
		ArrayList<LoaiPhong> dsnv = new ArrayList<LoaiPhong>();
		PreparedStatement statement = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from LoaiPhong where MaLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, idlp);
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery();
			// Duyệt kết quả trả về
			while (rs.next()) {
				int maPhong = rs.getInt("MaLoaiPhong");
				String tenLPhong = rs.getString("TenLoaiPhong");
				double gia = rs.getDouble("DonGia");

				LoaiPhong lp = new LoaiPhong(maPhong, tenLPhong, gia);
				dsnv.add(lp);
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

		return dsnv;

	}

	public boolean insert(LoaiPhong lp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into dbo.LoaiPhong (MaLoaiPhong, TenLoaiPhong, DonGia)" + "values (?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setInt(1, lp.getMaLoaiPhong());
			statement.setString(2, lp.getTenLoaiPhong());
			statement.setDouble(3, lp.getDonGia());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(LoaiPhong lp) {
		int n = 0;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "update dbo.LoaiPhong set TenLoaiPhong = ?, DonGia = ?" + " Where MaLoaiPhong = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, lp.getTenLoaiPhong());
			stmt.setDouble(2, lp.getDonGia());
			stmt.setInt(3, lp.getMaLoaiPhong());

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
		String query = "delete from dbo.LoaiPhong where maLoaiPhong = ?";
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

	public int getCountPhongByMaLoaiPhong(int maLoaiPhong) {
		int count = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MaLoaiPhong FROM dbo.Phong p where p.maLoaiPhong = ?";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setInt(1, maLoaiPhong);

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
