package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> getalltbNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = new ConnectDB().getConnection();

			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			// Thực thi câu lệnh SQL trả về đối tượng ResultSet
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt trên kết quả trả về
			while(rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				String qt = rs.getString(3);
				String cccd = rs.getString(4);
				Date ngayHH = rs.getDate(5);
				
				NhanVien nv = new NhanVien(maNV, tenNV, qt, cccd, ngayHH);
				dsNhanVien.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
}
