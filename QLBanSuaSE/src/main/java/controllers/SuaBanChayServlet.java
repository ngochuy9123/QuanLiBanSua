package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.SuaBL;
import javaBeans.Sua;

@WebServlet("/SuaBanChayServlet")
public class SuaBanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaBanChayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        int sl = 5;
        
        List<Sua> dss = SuaBL.locSuaBanChayNhat(sl);
        if(request.getParameter("maSua")!=null) {
	        String ms= request.getParameter("maSua");
	        Sua s = SuaBL.thongTinSuaTheoMaSua(ms);
			request.setAttribute("sua", s);
        }
        else {
        	String ms= dss.get(0).getMaSua();
	        Sua s = SuaBL.thongTinSuaTheoMaSua(ms);
			request.setAttribute("sua", s);
        }
        
		
        request.setAttribute("dss", dss);
        request.getRequestDispatcher("views/sua-ban-chay.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
