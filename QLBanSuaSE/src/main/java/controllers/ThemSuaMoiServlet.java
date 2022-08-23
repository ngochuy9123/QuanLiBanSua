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

@WebServlet("/ThemSuaMoiServlet")
public class ThemSuaMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemSuaMoiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		List<HangSua> dshs = HangSuaBL.docTatCa();
		List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
		
		request.setAttribute("dshs", dshs);
		request.setAttribute("dsls", dsls);
        request.getRequestDispatcher("views/them-sua-moi.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
		String ms,ts,mls,mhs,loiIch,tpDinhDuong,hinh;
        int donGia,trongLuong;
        ms=request.getParameter("txtMaSua");
        ts=request.getParameter("txtTenSua");
        mhs=request.getParameter("cboHangSua");
        mls=request.getParameter("cboLoaiSua");
        loiIch=request.getParameter("txtLoiIch");
        tpDinhDuong=request.getParameter("txtTPDinhDuong");
        hinh=request.getParameter("txtHinh");
        donGia=Integer.parseInt(request.getParameter("txtDonGia"));
        trongLuong=Integer.parseInt(request.getParameter("txtTrongLuong"));
        
        Sua s = new Sua();
        s.setTrongLuong(trongLuong);
        s.setTpDinhDuong(tpDinhDuong);
        s.setTenSua(ts);
        s.setMaSua(ms);
        s.setMaLoaiSua(mls);
        s.setMaHangSua(mhs);
        s.setLoiIch(loiIch);
        s.setHinh(hinh);
        s.setDonGia(donGia);
        
        int i = SuaBL.themSua(s);
        
        request.setAttribute("i", i);
		doGet(request, response);
	}

}
