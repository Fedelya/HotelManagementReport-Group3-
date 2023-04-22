package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Date;
import java.sql.PreparedStatement;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {

	private static KhachHang_DAO instance = new KhachHang_DAO();

	public static KhachHang_DAO getInstance() {
		return instance;
	}

	public ArrayList<KhachHang> getalltbKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();

			String sql = "Select * from dbo.KhachHang";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String qt = rs.getString(3);
				String cccd = rs.getString(4);
				Date ngayHH = rs.getDate(5);

				KhachHang kh = new KhachHang(maKH, tenKH, qt, cccd, ngayHH);
				dsKhachHang.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	public String getLatestID() {
		String id = "";
		ConnectDB.getInstance();
		Statement statement = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from dbo.KhachHang";
			statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = statement.executeQuery(sql);
			rs.last();
			id = rs.getString("MaKH");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public ArrayList<KhachHang> getListKhachHangByName(String name) {
		ArrayList<KhachHang> dataList = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		PreparedStatement statement = null;
		try {
			Connection con = ConnectDB.getConnection();
			String sql = "select * from dbo.KhachHang where TenKH like ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
//				String maKH = rs.getString(1);
//				String tenKH = rs.getString(2);
//				String qt = rs.getString(3);
//				String cccd = rs.getString(4);
//				Date ngayHH = rs.getDate(5);

				KhachHang kh = new KhachHang(rs);
				dataList.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public ArrayList<KhachHang> getKhachHangByMaKH(String id) {
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select * from dbo.KhachHang where MaKH = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String qt = rs.getString(3);
				String cccd = rs.getString(4);
				Date ngayHH = rs.getDate(5);

				KhachHang kh = new KhachHang(maKH, tenKH, qt, cccd, ngayHH);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public boolean insert(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "insert into dbo.KhachHang (MaKH, TenKH, QuocTich, CCCD, NgayHetHanCCCD)" + "values (?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getMaKhachHang());
			statement.setString(2, kh.getTenKhachHang());
			statement.setString(3, kh.getQuocTich());
			statement.setString(4, kh.getCCCD());
			statement.setDate(5, kh.getNgayHetHanCCCD());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "update dbo.KhachHang" + " set TenKH = ?, QuocTich = ?, CCCD = ?, NgayHetHanCCCD = ?"
					+ " where MaKH = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getTenKhachHang());
			statement.setString(2, kh.getQuocTich());
			statement.setString(3, kh.getCCCD());
			statement.setDate(4, kh.getNgayHetHanCCCD());
			statement.setString(5, kh.getMaKhachHang());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		int n = 0;
		try {
			String sql = "delete from dbo.KhachHang" + " where MaKH = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getMaKhachHang());
			n = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
