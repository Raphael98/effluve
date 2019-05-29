package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import entity.Product;

@WebServlet("/updateProduct")
public class Update extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id") == null) {
			req.getRequestDispatcher("WEB-INF/jsp/product/list-delete.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("WEB-INF/jsp/product/edit.jsp").forward(req, resp);					
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product(req.getParameter("name"),req.getParameter("price"),req.getParameter("brand"),req.getParameter("description"),req.getParameter("gender"));
		product.setId(Integer.parseInt(req.getParameter("id")));
		new ProductDAO().update(product);
		req.setAttribute("updated", true);
		req.getRequestDispatcher("WEB-INF/jsp/product/list-delete.jsp").forward(req, resp);
	}
}
