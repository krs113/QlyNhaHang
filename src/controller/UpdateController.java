package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;
import dao.StaffDAO;
import utils.Utf8Util;

public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utf8Util.setUtf8AndContentType(request, response);
		StaffDAO xuLy = new StaffDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String hoTen = request.getParameter("hoTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String sdt = request.getParameter("sdt");
		String ngaySinh = request.getParameter("ngaySinh");
		String matKhau = request.getParameter("matKhau");
		String ma = request.getParameter("ma");
		Staff obj = new Staff(id, hoTen, gioiTinh, sdt, ngaySinh, ma, matKhau);
//		Staff checkMa = xuLy.checkExistByMa(ma);
	
//		if (checkMa != null) {
//			String message = "Error!!!! ";
//			response.sendRedirect(request.getContextPath()+"/quanli?mgs=0");
//			return;
//		} else {
			int result = xuLy.updateNV(obj);
			if (result == 1) {
				response.sendRedirect(request.getContextPath()+"/quanli?mgs=2");
				return;
			}
//		}
	}

}
