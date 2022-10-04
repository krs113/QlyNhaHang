package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.ConnectDb;
import model.Staff;

public class StaffDAO {
	private ConnectDb connDB;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public StaffDAO() {
		connDB = new ConnectDb();
	}
	
	public List<Staff> getItems() {
		List<Staff> listStaff = new ArrayList();
		
		try {
			conn = connDB.getConnectMySql();
			String sql = "SELECT * FROM staff";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Staff obj = new Staff(rs.getInt("id"), rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("sdt"),
						rs.getString("ngaySinh"), rs.getString("ma"), rs.getString("matKhau"));
				listStaff.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return listStaff;
	}
	
	public Staff checkLogin(String taiKhoan, String matKhau ) {
		Staff obj = null;
		try {
			conn = connDB.getConnectMySql();
			String sql = "SELECT * FROM staff WHERE ma = ? AND matKhau = ?;";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, taiKhoan);
			pst.setString(2, matKhau);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = new Staff(rs.getInt("id"),rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("sdt"),
						rs.getString("ngaySinh"), rs.getString("ma"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return obj;
	}
	
	public Staff checkExist(String maDN) {
		Staff obj = null;
		try {
			conn = connDB.getConnectMySql();
			String sql = "SELECT * FROM staff WHERE ma = ? ;";

			pst = conn.prepareStatement(sql);
			pst.setString(1, maDN);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = new Staff(rs.getInt("id"),rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("sdt"),
						rs.getString("ngaySinh"), rs.getString("ma"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return obj;

	}
	
	public Staff checkExistByPhone(String sdt) {
		Staff obj = null;
		try {
			conn = connDB.getConnectMySql();
			String sql = "SELECT * FROM staff WHERE sdt = ? ;";
			pst = conn.prepareStatement(sql);
			pst.setString(1, sdt);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = new Staff(rs.getInt("id"),rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("sdt"),
						rs.getString("ngaySinh"), rs.getString("ma"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return obj;

	}

	public Staff checkExistByMa(String ma) {
		Staff obj = null;
		try {
			conn = connDB.getConnectMySql();
			String sql = "SELECT * FROM staff WHERE ma = ? ;";
			pst = conn.prepareStatement(sql);
			pst.setString(1, ma);
			rs = pst.executeQuery();
			if (rs.next()) {
				obj = new Staff(rs.getInt("id"),rs.getString("hoTen"), rs.getString("gioiTinh"), rs.getString("sdt"),
						rs.getString("ngaySinh"), rs.getString("ma"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return obj;
	}
	
	public int updateInf(Staff obj) {
		int result = 0;
		try {
			conn = connDB.getConnectMySql();
			String sql = "UPDATE staff SET hoTen = ?, gioiTinh = ?, sdt = ?, ngaySinh = ?, matKhau = ?"
					+ " WHERE  ma = ?;";

			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getHoTen());
			pst.setString(2, obj.getGioiTinh());
			pst.setString(3, obj.getSdt());
			pst.setString(4, obj.getNgaySinh());
			pst.setString(5, obj.getMatKhau());
			pst.setString(6, obj.getMa());
			result = pst.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public int updateNV(Staff obj) {
		int result = 0;
		try {
			conn = connDB.getConnectMySql();
			String sql = "UPDATE staff SET hoTen = ?, gioiTinh = ?, sdt = ?, ngaySinh = ?, ma =?, matKhau = ?"
					+ " WHERE  id = ?;";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getHoTen());
			pst.setString(2, obj.getGioiTinh());
			pst.setString(3, obj.getSdt());
			pst.setString(4, obj.getNgaySinh());
			pst.setString(5, obj.getMa());
			pst.setString(6, obj.getMatKhau());
			pst.setInt(7, obj.getId());
			result = pst.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int deleteNV(int id) {
		int result = 0;
		try {
			conn = connDB.getConnectMySql();
			String sql = "DELETE FROM `staff` WHERE id = ?;";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			result =pst.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;	
	}
	
	public int add(Staff obj) {
		int result = 0;
		try {
			conn = connDB.getConnectMySql();
			String sql = "INSERT INTO  staff ( `hoTen`, `gioiTinh`, `sdt`, `ngaySinh`, `ma`, `matKhau`)VALUES(?,?,?,?,?,?);";

			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getHoTen());
			pst.setString(2, obj.getGioiTinh());
			pst.setString(3, obj.getSdt());
			pst.setString(4, obj.getNgaySinh());
			pst.setString(5, obj.getMa());
			pst.setString(6, obj.getMatKhau());
			result = pst.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public int updatePass(String sdt, String newPass) {
		int result = 0;
		try {
			conn = connDB.getConnectMySql();
			String sql = "UPDATE staff SET matKhau = ? WHERE  sdt = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, newPass);
			pst.setString(2, sdt);
			result = pst.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
}






























