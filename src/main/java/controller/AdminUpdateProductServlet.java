package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDAO;
import model.UpdateProduct;
import resources.MyConstants;

/**
 * Servlet implementation class AdminUpdateProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns={"/AdminUpdateProductServlet"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 20)
public class AdminUpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String brand = request.getParameter("brand");
		int price = Integer.parseInt(request.getParameter("price"));
		int id = Integer.parseInt(request.getParameter("id"));
		Part imagePart = request.getPart("image");
		
		 UpdateProduct product = new UpdateProduct(id, name, brand, price, imagePart);
		
		//image
		String savePath = MyConstants.IMAGE_DIR_SAVE_PATH;
		
	    String fileName = product.getImageUrlFromPart();
	    
	    
	    if(!fileName.isEmpty() && fileName != null)
    		imagePart.write(savePath + fileName);
	    
	  
	
	   
	    
		
		ProductDAO reg = new ProductDAO();
		
		String result= ProductDAO.updateProduct(product);
		
		// Set the result message as a request attribute
	    request.setAttribute("resultMessage", result);
		

		// Forward the request to the addProduct.jsp page
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/admin/addProduct.jsp");
	    dispatcher.forward(request, response);
	    
	    
		
	}

}
