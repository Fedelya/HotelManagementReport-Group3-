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
import entity.LoaiPhong;
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
			while (rs.next()) {
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

	public ArrayList<HoaDonPhong> getListHDKHByDate(Date tuNgay, Date denNgay) {
		ArrayList<HoaDonPhong> dataList = new ArrayList<HoaDonPhong>();
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "EXEC Proc_LocHoaDonPhongTheoNgay ? , ? ";
			stmt = con.prepareStatement(sql);
			stmt.setDate(1, tuNgay);
			stmt.setDate(2, denNgay);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getInt("MaLoaiPhong"), rs.getString("TenLoaiPhong"),
						rs.getDouble("DonGia"));
				Phong p = new Phong(rs.getString("MaPhong"), rs.getString("ViTri"), rs.getInt("TinhTrangP"), loaiPhong);
				KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("QuocTich"),
						rs.getString("CCCD"), rs.getDate("NgayHetHanCCCD"));

				HoaDonPhong hdP = new HoaDonPhong(rs.getInt("MaHD"), rs.getInt("TinhTrangHD"), tuNgay, denNgay, p, kh);
//				HoaDonPhong hdP = new HoaDonPhong(rs);
				dataList.add(hdP);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataList;
	}

	public boolean themHDP(HoaDonPhong hdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "insert into HoaDonPhong values(?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, hdp.getKhachHang().getMaKhachHang());
			stmt.setString(2, hdp.getPhong().getMaPhong());
			stmt.setInt(3, hdp.getTinhTrang());
			stmt.setDate(4, hdp.getNgayGioNhan());
			stmt.setDate(5, hdp.getNgayGioTra());
			n = stmt.executeUpdate();
		} catch (Exception e) {
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

	public boolean updateHDP(HoaDonPhong hdp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "update dbo.HoaDonPhong set MaKH=?,MaPhong=?,TinhTrang=?,NgayGioNhan=?,NgayGioTra=?"
					+ "where MaHD=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, hdp.getMaHoaDon());
			stmt.setString(2, hdp.getKhachHang().getMaKhachHang());
			stmt.setString(3, hdp.getPhong().getMaPhong());
			stmt.setInt(4, hdp.getTinhTrang());
			stmt.setDate(5, hdp.getNgayGioNhan());
			stmt.setDate(6, hdp.getNgayGioTra());
			n = stmt.executeUpdate();
		} catch (Exception e) {
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

	public boolean deleteHDP(int id) {
		int n = 0;
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
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public int getLatestID() {
        int id = 0;
        ConnectDB.getInstance();
        Statement stmt = null;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM dbo.HoaDonPhong";
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = stmt.executeQuery(sql);
            rs.last();
            id = rs.getInt("MaHD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
}
