package controller.brand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import bean.Brand;
import dao.BrandDAO;

@WebServlet("/deleteBrand")
public class Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			BrandDAO dao = new BrandDAO();
			Brand brand = dao.get(id);
			dao.delete(brand);
		} catch (NotFound e) {
			e.printStackTrace();
		}
		req.setAttribute("deleted", true);
		req.getRequestDispatcher("WEB-INF/jsp/brand/list-delete.jsp").forward(req, resp);
	}
}
