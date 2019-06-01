package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import entity.Product;

@WebServlet(urlPatterns = {"/search"}, name = "search")
public class Search extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text = req.getParameter("text");
		String brand = req.getParameter("brand");
		String[] genders = req.getParameterValues("gender[]");
		String[] brands = req.getParameterValues("brand[]");
		if(brand != null) {
			brands = new String[1];
			brands[0] = brand;
		}
		List<Product> products;
		if(text != null) {
			products = new ProductDAO().search(text);
		}else {
			products = new ProductDAO().search(genders,brands);			
		}
		req.setAttribute("products", products);
		req.getRequestDispatcher("WEB-INF/jsp/search.jsp").forward(req, resp);
	}
}
