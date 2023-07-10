package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProductDAO;
import model.UpdateProduct;
import resources.MyConstants;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UpdateProductServlet() {
//    	ProductDAO productDao = new ProductDAO();
//        
//       
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get the parameters from the form
		
//		HttpSession session = request.getSession();
//		
//		int id = (int) session.getAttribute("id");
		System.out.println(request.getParameter("id"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		
//        String name = request.getParameter("name");
//        String brand = request.getParameter("brand");
//        int price = Integer.parseInt(request.getParameter("price"));
//        Part imagePart = request.getPart("image");
//        
        
//		, name, brand, price, imagePart
        // Update the product in the database
        UpdateProduct product = new UpdateProduct(id);
        
	   
	    
	    
	    
	    //ProductDAO reg = new ProductDAO();
	    
	    
	    String result= ProductDAO.updateProduct(product);
		
		// Set the result message as a request attribute
	    request.setAttribute("resultMessage", result);
		

		// Forward the request to the addProduct.jsp page
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/admin/updateProduct.jsp");
	    dispatcher.forward(request, response);
	    
	    
	    
        
//        
//        update.setName(name);
//        update.setBrand(brand);
//        update.setPrice(price);
//        update.setImageUrl(imageUrl);
//        update.setId(id);
//        
//        ProductDAO.updateProduct(update);
//        
//        
        
      

        // Redirect to the product list page
        response.sendRedirect("productList.jsp");
	}

}
