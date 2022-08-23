package javaBeans;

import java.io.Serializable;

public class LoaiSua implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tenLoai;
	private String maLoaiSua;
	public LoaiSua() {
		super();
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getMaLoaiSua() {
		return maLoaiSua;
	}
	public void setMaLoaiSua(String maLoaiSua) {
		this.maLoaiSua = maLoaiSua;
	}
	
}
