package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public ArrayList<Phong> getListPhongByID(String ma) {
		ArrayList<Phong> listP = new ArrayList<Phong>();
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "Select * from dbo.Phong where MaPhong like ?";
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, ma);

			rs = stmt.executeQuery();
			while (rs.next()) {
				Phong loaiPhong = new Phong(rs);
				listP.add(loaiPhong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listP;
	}

//	    public ArrayList<Phong> getListPhong() {
//	        ArrayList<Phong> dataList = new ArrayList<Phong>();
//	        ConnectDB.getInstance();
//	        Statement stmt = null;
//	        ResultSet rs = null;
//	        String query = "SELECT * FROM dbo.Phong";
//	        Connection con = ConnectDB.getConnection();
//	        try {
//	            stmt = con.createStatement();
//	            rs = stmt.executeQuery(query);
//	            while (rs.next()) {
//	                Phong phong = new Phong(rs);
//	                dataList.add(phong);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                stmt.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return dataList;
//	    }
//
//	    public ArrayList<Phong> getListPhongByMa(String ID) {
//	        ArrayList<Phong> dataList = new ArrayList<Phong>();
//	        PreparedStatement stmt = null;
//	        ConnectDB.getInstance();
//	        Connection con = ConnectDB.getConnection();
//	        String query = "Select * from dbo.Phong where MaPhong like ?";
//	        ResultSet rs = null;
//	        try {
//	            stmt = con.prepareStatement(query);
//	            stmt.setString(1, "%" + ID + "%");
//
//	            rs = stmt.executeQuery();
//	            while (rs.next()) {
//	                Phong loaiPhong = new Phong(rs);
//	                dataList.add(loaiPhong);
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                stmt.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//	        return dataList;
//	    }

	public ArrayList<Phong> getPhongByMaLoaiPhong(int maLoaiPhong) {
		ArrayList<Phong> dsp = new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection conn = ConnectDB.getConnection();

			String sql = "Select * from Phong where MaLoaiPhong = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, maLoaiPhong);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Phong phong = new Phong(rs);
				dsp.add(phong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsp;
	}

	public ArrayList<Phong> getListPhongByViTri(String viTri) {
		ArrayList<Phong> listP = new ArrayList<Phong>();
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "Select * from dbo.Phong where ViTri like ?";
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, viTri);

			rs = stmt.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("MaPhong");
				String pos = rs.getString("ViTri");
				int tinhTrang = rs.getInt("TinhTrang");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getInt("MaLoaiPhong"));
				Phong p = new Phong(maPhong, pos, tinhTrang, loaiPhong);
				listP.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listP;
	}

	public boolean insert(Phong phong) {
		int n = 0;
		ConnectDB.getInstance();
		PreparedStatement stmt = null;
		Connection con = ConnectDB.getConnection();
		String query = "insert into dbo.Phong (MaPhong, ViTri, TinhTrang, MaLoaiPhong) " + " values (?, ?, ?, ?)";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, phong.getMaPhong());
			stmt.setString(2, phong.getViTri());
			stmt.setInt(3, phong.getTinhTrang());
			stmt.setInt(4, phong.getLoaiPhong().getMaLoaiPhong());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean delete(String id) {
		int n = 0;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "delete from dbo.Phong where MaPhong = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, id);

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

	public boolean update(Phong phong) {
		int n = 0;
		PreparedStatement stmt = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String query = "update dbo.Phong set ViTri = ?, TinhTrang = ?, MaLoaiPhong = ?" + " Where MaPhong = ?";
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, phong.getViTri());
			stmt.setInt(2, phong.getTinhTrang());
			stmt.setInt(3, phong.getLoaiPhong().getMaLoaiPhong());
			stmt.setString(4, phong.getMaPhong());

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

}
