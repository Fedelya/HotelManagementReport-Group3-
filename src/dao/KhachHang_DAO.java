package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getalltbKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = new ConnectDB().getConnection();

			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while(rs.next()) {
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
}
