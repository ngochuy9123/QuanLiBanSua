package businessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.LoaiSua;

public class LoaiSuaBL {
	public static List<LoaiSua> taoDanhSach(String sql) {
		List<LoaiSua> dsls = new ArrayList<>();
		Connection kn = CSDL.getKetNoi();
		try {
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				LoaiSua ls = new LoaiSua();
				ls.setMaLoaiSua(rs.getString("Ma_loai_sua"));
				ls.setTenLoai(rs.getString("Ten_loai"));
				dsls.add(ls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsls;
	}
	
	public static List<LoaiSua> docTatCa() {
		String sql ="select * from loai_sua ";
		List<LoaiSua> dsls = taoDanhSach(sql);
		return dsls;
	}
	
	public static void main(String[] args) {
		List<LoaiSua> dsls = docTatCa();
		for(LoaiSua ls:dsls) {
			System.out.println(ls.getTenLoai());
		}
	}
}
