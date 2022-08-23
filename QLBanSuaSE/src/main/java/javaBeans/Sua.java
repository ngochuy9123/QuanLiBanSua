package javaBeans;

import java.io.Serializable;

public class Sua implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tenSua;
	private String hinh;
	private String loiIch;
	private String tpDinhDuong;
	private int donGia;
	private int trongLuong;
	private String maLoaiSua;
	private String maHangSua;
	private String maSua;
	private String tenLoaiSua;
	private String tenHangSua;
	public String getTenLoaiSua() {
		return tenLoaiSua;
	}
	public void setTenLoaiSua(String tenLoaiSua) {
		this.tenLoaiSua = tenLoaiSua;
	}
	public String getTenHangSua() {
		return tenHangSua;
	}
	public void setTenHangSua(String tenHangSua) {
		this.tenHangSua = tenHangSua;
	}
	public Sua() {
		super();
	}
	public String getTenSua() {
		return tenSua;
	}
	public void setTenSua(String tenSua) {
		this.tenSua = tenSua;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public String getLoiIch() {
		return loiIch;
	}
	public void setLoiIch(String loiIch) {
		this.loiIch = loiIch;
	}
	public String getTpDinhDuong() {
		return tpDinhDuong;
	}
	public void setTpDinhDuong(String tpDinhDuong) {
		this.tpDinhDuong = tpDinhDuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getTrongLuong() {
		return trongLuong;
	}
	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}
	public String getMaLoaiSua() {
		return maLoaiSua;
	}
	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}
	public String getMaHangSua() {
		return maHangSua;
	}
	public void setMaHangSua(String maHangSua) {
		this.maHangSua = maHangSua;
	}
	public String getMaSua() {
		return maSua;
	}
	public void setMaSua(String maSua) {
		this.maSua = maSua;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
