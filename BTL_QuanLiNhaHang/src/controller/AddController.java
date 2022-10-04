package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDAO;
import model.Staff;
import utils.Utf8Util;

public class AddController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AddController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Utf8Util.setUtf8AndContentType(request, response);
		StaffDAO xuLy = new StaffDAO();
		int id = 0;
		String hoTen = request.getParameter("hoTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String sdt = request.getParameter("sdt");
		String ngaySinh = request.getParameter("ngaySinh");
		String matKhau = null;
		String ma = request.getParameter("ma");
		
		Staff obj = new Staff(id, hoTen, gioiTinh, sdt, ngaySinh, ma, matKhau);
		Staff checkMa = xuLy.checkExistByMa(ma);
		Staff checkPhone = xuLy.checkExistByPhone(sdt);
		
		if (checkMa != null || checkPhone != null) {	
			response.sendRedirect(request.getContextPath()+"/quanli?mgs=4");
			return;
			
		} else {
			int result = xuLy.add(obj);
			if (result == 1) {
				response.sendRedirect(request.getContextPath() + "/quanli?mgs=1");
			}
			return;
		}

	}
}










