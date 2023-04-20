package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class Phong_DAO {
	public ArrayList<Phong> getallPhong() {
		ArrayList<Phong> dsLP = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from dbo.Phong";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while (rs.next()) {
				String maPhong = rs.getString("MaPhong");
				String viTri = rs.getString("ViTri");
				int tinhTrang = rs.getInt("TinhTrang");
				LoaiPhong maLP = new LoaiPhong(rs.getInt("MaLoaiPhong"));

				Phong p = new Phong(maPhong, viTri, tinhTrang, maLP);
				dsLP.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLP;
	}
}
