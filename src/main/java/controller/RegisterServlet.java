package controller;

import java.io.IOException;


import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dao.RegisterDao;
import model.RegisterModel;
import resources.MyConstants;
import resources.PasswordEncryptionWithAes;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns={"/RegisterServlet"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 20)

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name= request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		Part imagePart = request.getPart("image");  
		System.out.println(imagePart);
		
		RegisterModel register = new RegisterModel(first_name, last_name, email, username, password, imagePart);
		
		//image
		String savePath = MyConstants.IMAGE_DIR_SAVE_PATH;
		
	    String fileName = register.getImageUrlFromPart();
	      
	    if(!fileName.isEmpty() && fileName != null)
    		imagePart.write(savePath + fileName);
		
		
		PrintWriter out = response.getWriter();
		
		RegisterDao reg = new RegisterDao();
		
		String result= reg.insert(register);
		
		
		response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
		
		
	}

}
