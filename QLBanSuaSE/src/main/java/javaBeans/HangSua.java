package javaBeans;

import java.io.Serializable;

public class HangSua implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String dienThoai;
	private String diaChi;
	private String tenHangSua;
	private String maHangSua;
	public HangSua() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTenHangSua() {
		return tenHangSua;
	}
	public void setTenHangSua(String tenHangSua) {
		this.tenHangSua = tenHangSua;
	}
	public String getMaHangSua() {
		return maHangSua;
	}
	public void setMaHangSua(String maHangSua) {
		this.maHangSua = maHangSua;
	}
	
}
