package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FetchProductDao;
import dao.SearchDao;
import dao.SearchException;
import model.UpdateProduct;

/**
 * Servlet implementation class FetchProductServlet
 */
@WebServlet("/FetchProductServlet")
public class FetchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String query = request.getParameter("query");
	        String category = request.getParameter("category");
	        
	        if(category != null && query != null) {
	        	if(query.equalsIgnoreCase("nike") || query.equalsIgnoreCase("vans") || query.equalsIgnoreCase("adidas"))
	        	{
	        		try {
	        		
	        		//object creating
		            SearchDao searchDao = new SearchDao();
		            
		            //searching the products
		            List<UpdateProduct> productList = searchDao.searchProducts(query, category);
		        
		            request.setAttribute("productList", productList);
		            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/product.jsp");
			        dispatcher.forward(request, response);
	        		}
	        		
	        		catch (SearchException e) {
	        		    String errorMessage = e.getMessage();
	        		    request.setAttribute("errorMessage", errorMessage);
	        		    RequestDispatcher dispatcher = request.getRequestDispatcher("pages/error.html");
	        		    dispatcher.forward(request, response);
	        		}
	        	}
	        	
	        	else
	        	{
	        		FetchProductDao dao = new FetchProductDao();
	    	        List<UpdateProduct> productList = dao.getAllProducts();
	    	        request.setAttribute("productList", productList);
	    	        request.setAttribute("ErrorSearch", "Please Enter a Valid Category");
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/product.jsp");
	    	        dispatcher.forward(request, response);
	        	}
	        	
	        }
	        
	        else {
	        	
	        	FetchProductDao dao = new FetchProductDao();
		        List<UpdateProduct> productList = dao.getAllProducts();
		        request.setAttribute("productList", productList);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/product.jsp");
		        dispatcher.forward(request, response);
	        	
	        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
