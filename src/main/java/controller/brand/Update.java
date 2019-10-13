package controller.brand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandDAO;
import entity.Brand;

@WebServlet(urlPatterns = {"/updateBrand"}, name = "updateBrand")
public class Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id") == null) {
			req.getRequestDispatcher("WEB-INF/jsp/brand/list-delete.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("WEB-INF/jsp/brand/edit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Brand brand = new Brand(req.getParameter("name"));
		brand.setId(Integer.parseInt(req.getParameter("id")));
		new BrandDAO().update(brand);
		req.getRequestDispatcher("WEB-INF/jsp/brand/list-delete.jsp").forward(req, resp);
	}
}
