package dao;

import java.sql.Connection;
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
}
