package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.HangSua;
import javaBeans.Sua;

public class SuaBL {
	public static List<Sua> docTatCa(String sql) {
		List<Sua> dss = new ArrayList<>();
		Connection kn = CSDL.getKetNoi();
		try {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Sua s = new Sua();
				s.setTrongLuong(rs.getInt("Trong_luong"));
				s.setTpDinhDuong(rs.getString("Tp_dinh_duong"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaSua(rs.getString("Ma_sua"));
				s.setMaHangSua("Ma_loai_sua");
				s.setMaHangSua(rs.getString("Ma_hang_sua"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("Hinh"));
				s.setDonGia(rs.getInt("Don_gia"));
				dss.add(s);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dss;
	}
	
	public static List<Sua> docDanhSachTheoHSLS(String sql) {
		List<Sua> dss = new ArrayList<>();
		Connection kn = CSDL.getKetNoi();
		try {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Sua s = new Sua();
				s.setTrongLuong(rs.getInt("Trong_luong"));
				s.setTpDinhDuong(rs.getString("Tp_dinh_duong"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaSua(rs.getString("Ma_sua"));
				s.setMaHangSua("Ma_loai_sua");
				s.setMaHangSua(rs.getString("Ma_hang_sua"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("Hinh"));
				s.setDonGia(rs.getInt("Don_gia"));
				s.setTenLoaiSua(rs.getString("Ten_loai"));
				s.setTenHangSua(rs.getString("Ten_hang_sua"));
				dss.add(s);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dss;
	}
	
	
//	String sql ="select s.Ten_sua, h.Ten_hang_sua, l.Ten_loai, s.Trong_luong, s.Don_gia from sua s \r\n"
//			+ "inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua\r\n"
//			+ "inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua";
	
	public static List<Sua> docSpTheoHangSua(String hs) {
		String sql = "select * from sua s inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua where h.Ma_hang_sua = '"+hs+"'";
		List<Sua> dss = docDanhSachTheoHSLS(sql);
		return dss;
	}
	
	public static List<Sua> docSpTheoLoaiSua(String ls) {
		String sql = "select * from sua s inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua where l.Ma_loai_sua = '"+ ls+"'";
				
		List<Sua> dss = docDanhSachTheoHSLS(sql);
		return dss;
				
	}
	
	public static List<Sua> phanChiaSanPhamTheoLoaiSua(String ls,int trang) {
		String sql = "select * from sua s inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua where l.Ma_loai_sua = '"+ ls+"'"+" limit "+trang+" ,"+5;
		List<Sua> dss = docDanhSachTheoHSLS(sql);
		return dss;
	}
	
	public static List<Sua> phanChiaSanPhamTheoHangSua(String hs, int trang) {
		String sql = "select * from sua s inner join hang_sua h on h.Ma_hang_sua = s.Ma_hang_sua inner join loai_sua l on l.Ma_loai_sua = s.Ma_loai_sua where h.Ma_hang_sua = '"+hs+"'"+"limit "+trang+" ,"+5;
		List<Sua> dss = docDanhSachTheoHSLS(sql);
		return dss;
	}
	
	public static List<Sua> timSuaTheoLoaiHangTen(String mls, String mhs, String tenSua) {
			String sql ="select * from sua where Ma_loai_sua = '"+mls+"' and Ma_hang_sua = '"+mhs+"' and Ten_sua like '%"+tenSua+"%'";
			List<Sua> dss = docTatCa(sql);
			return dss;
	}
	
	public static List<Sua> locSuaBanChayNhat(int sl) {
		String sql ="SELECT s.* , sum(ct.So_luong) as tsl FROM Sua s  "
				+ "inner join ct_hoadon ct on ct.Ma_sua = s.Ma_sua  "
				+ "group by 1  order by tsl desc limit 0,"+sl;
		
		List<Sua> dss = docTatCa(sql);
		return dss;
	}
	
	public static Sua thongTinSuaTheoMaSua(String ms) {
		String sql = "select * from sua s where Ma_sua = '"+ms+"'";
		Sua s = new Sua();
		Connection kn = CSDL.getKetNoi();
		try {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				s.setTrongLuong(rs.getInt("Trong_luong"));
				s.setTpDinhDuong(rs.getString("Tp_dinh_duong"));
				s.setTenSua(rs.getString("Ten_sua"));
				s.setMaSua(rs.getString("Ma_sua"));
				s.setMaHangSua("Ma_loai_sua");
				s.setMaHangSua(rs.getString("Ma_hang_sua"));
				s.setLoiIch(rs.getString("Loi_ich"));
				s.setHinh(rs.getString("Hinh"));
				s.setDonGia(rs.getInt("Don_gia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	public static int themSua(Sua s) {
		String sql = "insert into Sua(ma_sua,ten_sua,ma_loai_sua,ma_hang_sua,trong_luong,don_gia,tp_dinh_duong,loi_ich,hinh) values (?,?,?,?,?,?,?,?,?)";
		int smt =0;
		Connection kn = CSDL.getKetNoi();
		try {
			PreparedStatement pst = kn.prepareStatement(sql);
			pst.setString(1, s.getMaSua());
			pst.setString(2, s.getTenSua());
			pst.setString(3, s.getMaLoaiSua());
			pst.setString(4, s.getMaHangSua());
			pst.setInt(5, s.getTrongLuong());
			pst.setInt(6, s.getDonGia());
			pst.setString(7, s.getTpDinhDuong());
			pst.setString(8, s.getLoiIch());
			pst.setString(9, s.getHinh());
			smt = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smt;
	}
	
	public static void main(String[] args) {
//		List<Sua> dss = locSuaBanChayNhat(5);
//		for(Sua s:dss) {
//			System.out.println(s.getTenSua());
//		}
//		Sua s = thongTinSuaTheoMaSua("AB0001");
//		System.out.println(s.getTenSua());
		Sua s = new Sua();
		s.setDonGia(100);
		s.setTrongLuong(100);
		s.setTpDinhDuong("b");
		s.setTenSua("b");
		s.setMaHangSua("AB");
		s.setMaSua("ab0060");
		s.setMaLoaiSua("SB");
		s.setLoiIch("ab");
		s.setHinh("ab");
		int test = themSua(s);
		if(test<=0) {
			System.out.println("Khong thanh cong");
		}
		else
			System.out.println("Thanfh cong");
	}
	
}
