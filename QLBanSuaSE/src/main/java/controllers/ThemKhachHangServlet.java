package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLogics.KhachHangBL;
import javaBeans.KhachHang;

@WebServlet("/ThemKhachHangServlet")
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemKhachHangServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        //Thi sinh viet them cac lenh vao day de thuc hien

        request.getRequestDispatcher("views/them-khach-hang.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email,dt,diaChi,ten,maKH;
		int phai=0;
		email = request.getParameter("txtEmail");
		dt=request.getParameter("txtDienThoai");
		diaChi = request.getParameter("txtDiaChi");
		if(request.getParameter("rdbPhai")!=null)
			phai= Integer.parseInt(request.getParameter("rdbPhai"));
		ten=request.getParameter("txtTenKH");
		maKH=request.getParameter("txtMaKH");
		
		KhachHang kh = new KhachHang();
		kh.setDiaChi(diaChi);
		kh.setPhai(phai);
		kh.setMaKhachHang(maKH);
		kh.setEmail(email);
		kh.setDienThoai(dt);
		kh.setTenKhachHang(ten);
		
		KhachHangBL.themKhachHang(kh);
		
		doGet(request, response);
	}

}
