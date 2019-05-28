package controller.brand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BrandDAO;
import entity.Brand;

@WebServlet("/createBrand")
public class Create extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/brand/new.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Brand brand = new Brand(req.getParameter("name"), req.getParameter("description"));
		new BrandDAO().add(brand);
		req.setAttribute("success", true);
		req.getRequestDispatcher("/WEB-INF/jsp/brand/new.jsp").forward(req, resp);
	}
}
