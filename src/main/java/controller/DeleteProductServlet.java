package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    		
    
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }
    
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));

		try {
			productDAO.deleteProduct(productId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// set the success message attribute
		request.setAttribute("delMessage", "Product successfully deleted!");

		// forward the request to the updated product page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FetchProductServlet");
		dispatcher.forward(request, response);
		
		
		//request.setAttribute("message", "Product deleted successfully.");
		//response.sendRedirect(request.getContextPath() + "/FetchProductServlet");
	
    }

}
