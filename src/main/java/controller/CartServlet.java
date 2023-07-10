package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.CartDao;
import model.CartModel;
import model.CartModel.CartItem;
import model.UpdateProduct;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(asyncSupported = true, urlPatterns="/CartServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 20)
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check if user is logged in
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username == null) {
		   // User is not logged in, redirect to login page
		   response.sendRedirect(request.getContextPath() + "/FetchProductServlet");
		   return;
		}
		else {
				
		CartDao cartDao = new CartDao();
        List<CartItem> cartItems = cartDao.getAllCartItems(username);
        
        
        if (cartItems == null || cartItems.isEmpty()) {
            request.setAttribute("emptyCart", true);
        } else {
            request.setAttribute("cartItems", cartItems);
        }
        request.setAttribute("cartItems", cartItems);
        request.getRequestDispatcher("pages/cart.jsp").forward(request, response);
		}
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check if user is logged in
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username == null) {
		   // User is not logged in, displaying message
			
			String errMsg = "Please Login First to add to cart!!";
			
			
			// set the error message attribute
			session.setAttribute("errMsg", errMsg);
			
			response.sendRedirect(request.getContextPath() + "/FetchProductServlet");

		}
		
		else {
		
			
			String action = request.getParameter("action");
			

			int id = Integer.parseInt(request.getParameter("id"));
	       
	        
	        if (action.equals("add")) {
	        	
	        	// get the product details from the database
	        	CartDao cartDao = new CartDao();
	            UpdateProduct product = cartDao.getProductById(id); 	        	
	            //CartModel cartModel = new CartModel();
	            
	            //String imgg = "abc.jpg";
	        	
	        	int quantity = 1;
	        	int total = quantity * product.getPrice();
	        	//System.out.println(imagePart);
	        		        	
	            
	        	CartModel cartModel = new CartModel();
	        	
				CartItem cartItem = cartModel.new CartItem(product.getId(), username, product.getName(), product.getPrice(), product.getBrand(),
						quantity, total, product.getImageUrl(), 1);
	            cartDao.addCartItem(cartItem);

	    
	            String successMessage = "Cart item successfully added";
	            session.setAttribute("successMessage", successMessage);
	            response.sendRedirect(request.getContextPath() + "/FetchProductServlet");

	        	return;
	        }
	        
	        
	        	
	       
	         else if (action.equals("update")) {
	            int c_id = Integer.parseInt(request.getParameter("c_id"));
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            int price = Integer.parseInt(request.getParameter("price"));
	            int total = quantity * price;
	            
	         // Create an instance of the outer class CartModel
	            CartModel cartModel = new CartModel();
	            
	            CartItem cartItem = cartModel.new CartItem(c_id, quantity, total);
	            CartDao cartDao = new CartDao();
	            cartDao.updateCartItem(cartItem);

	            session.setAttribute("successMessage", "Cart item successfully updated");
	            
	            
	
	            
	        } else if (action.equals("delete")) {
	        	
	        	
	        	CartDao cartDao = new CartDao();
	            int c_id = Integer.parseInt(request.getParameter("c_id"));
	            
	            
	            CartModel cartModel = new CartModel();
	            
	            
	            CartItem cartItem = cartModel.new CartItem(c_id, id);
	            cartDao.deleteCartItem(cartItem);
	            
	            session.setAttribute("successMessage", "Cart item successfully deleted.");
	        }
	        response.sendRedirect(request.getContextPath() + "/CartServlet");
	    }
	}
		
		
		
		
		
}
