package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.HangSua;

public class HangSuaBL {
	
	public static List<HangSua> taoDanhSach(String sql) {
		Connection kn = CSDL.getKetNoi();
		List<HangSua> dshs = new ArrayList<>();
		try {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				HangSua hs = new HangSua();
				hs.setDiaChi(rs.getString("Dia_chi"));
				hs.setTenHangSua(rs.getString("Ten_hang_sua"));
				hs.setMaHangSua(rs.getString("Ma_hang_sua"));
				hs.setEmail(rs.getString("Email"));
				hs.setDienThoai(rs.getString("Dien_thoai"));
				dshs.add(hs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return dshs;
	}
	
	public static List<HangSua> docTatCa() {
		String sql ="select * from hang_sua ";
		List<HangSua> dshs = taoDanhSach(sql);
		return dshs;
	}
	
	public static void main(String[] args) {
		List<HangSua> dshs = docTatCa();
		for(HangSua hs:dshs){
			System.out.println(hs.getTenHangSua());
		}
	}
}
