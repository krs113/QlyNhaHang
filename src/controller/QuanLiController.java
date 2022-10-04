package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Staff;
import dao.StaffDAO;

public class QuanLiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLiController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffDAO daoStaff = new StaffDAO();
		List<Staff> list = daoStaff.getItems();
		request.setAttribute("listNV", list);
		RequestDispatcher fd = request.getRequestDispatcher("/quanLy.jsp");
		fd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
