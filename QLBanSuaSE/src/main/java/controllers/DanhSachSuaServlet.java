package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.HangSuaBL;
import businessLogics.LoaiSuaBL;
import businessLogics.SuaBL;
import javaBeans.HangSua;
import javaBeans.LoaiSua;
import javaBeans.Sua;

@WebServlet("/DanhSachSuaServlet")
public class DanhSachSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhSachSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String maHang = request.getParameter("maHang");
        String maLoai = request.getParameter("maLoai");
        int soSanPham=5;
        double tongSoTrang=0;
        int trang =1;

        List<HangSua> dshs = HangSuaBL.docTatCa();
        List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
        List<Sua> dss=null;
        
        if(maHang!=null) {
        	dss = SuaBL.docSpTheoHangSua(maHang);
        	soSanPham = dss.size();
        	tongSoTrang= (soSanPham/5) + (soSanPham%5==0?0:1);
        	dss=SuaBL.phanChiaSanPhamTheoHangSua(maHang, 0);
        }
        if(maLoai!=null) {
        	dss = SuaBL.docSpTheoLoaiSua(maLoai);
        	soSanPham = dss.size();
        	tongSoTrang= (soSanPham/5) + (soSanPham%5==0?0:1);
        	dss = SuaBL.phanChiaSanPhamTheoLoaiSua(maLoai, 0);
        }
        
        if((request.getParameter("trang"))!=null){
        	trang = Integer.parseInt(request.getParameter("trang"));
        	int vt = (trang-1)*5;
        	if(maHang!=null) {
	        	dss = SuaBL.phanChiaSanPhamTheoHangSua(maHang,vt);
	        	
	        }
	        if(maLoai!=null) {
	        	dss = SuaBL.phanChiaSanPhamTheoLoaiSua(maLoai,vt);
	        	
	        }
        }
        

        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        request.setAttribute("dss", dss);
        request.setAttribute("tongSoTrang", tongSoTrang);
        request.setAttribute("soSP", soSanPham);
        request.getRequestDispatcher("views/danh-sach-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
