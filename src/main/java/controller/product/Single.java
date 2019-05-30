package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import entity.Product;

@WebServlet("/single")
public class Single extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			Product product = new ProductDAO().get(id);
			req.setAttribute("product", product);
			req.getRequestDispatcher("WEB-INF/jsp/single.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);	
		}
	}
}
