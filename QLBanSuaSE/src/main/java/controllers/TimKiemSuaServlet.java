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

@WebServlet("/TimKiemSuaServlet")
public class TimKiemSuaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemSuaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String mh = request.getParameter("cboHangSua");
        String ml = request.getParameter("cboLoaiSua");
        String ts = request.getParameter("txtTenSuaTim");

        List<HangSua> dshs = HangSuaBL.docTatCa();
        List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
        List<Sua> dss = SuaBL.timSuaTheoLoaiHangTen(ml, mh, ts);
        
        
        request.setAttribute("dshs", dshs);
        request.setAttribute("dsls", dsls);
        request.setAttribute("dss", dss);
        request.setAttribute("soSP", dss.size());
        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String mh = request.getParameter("cboHangSua");
	        String ml = request.getParameter("cboLoaiSua");
	        String ts = request.getParameter("txtTenSuaTim");

	        List<HangSua> dshs = HangSuaBL.docTatCa();
	        List<LoaiSua> dsls = LoaiSuaBL.docTatCa();
	        List<Sua> dss = SuaBL.timSuaTheoLoaiHangTen(ml, mh, ts);
	        
	        
	        request.setAttribute("dshs", dshs);
	        request.setAttribute("dsls", dsls);
	        request.setAttribute("dss", dss);
	        request.setAttribute("soSP", dss.size());
	        request.getRequestDispatcher("views/tim-kiem-sua.jsp").include(request, response);
	}

}
