package controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	
		// Getting the username and password from the request
        String username = request.getParameter("username");
        
        String pwd = request.getParameter("pwd");

     // Checking if the credentials are valid 
        if (username.equals("admin") && pwd.equals("admin")) 
        {
        	// If the admin is valid creating a session and redirect to the admin dashboard page
            HttpSession session = request.getSession();
            
            session.setAttribute("userAdmin",username);
            
            Cookie UserCookie = new Cookie("userAdmin", "admin"); 
            UserCookie.setMaxAge(60*60 * 2);
            response.addCookie(UserCookie);
            
            
            response.sendRedirect(request.getContextPath() + "/pages/admin/admin.jsp");
        }
        
        else 
        {
        	// Authenticating the user
    		if(LoginDao.authenticateUser(username, pwd))
    		{
    			
    			
    			
    			 HttpSession session = request.getSession();
	             session.setAttribute("username", username);

	                

                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 2);
                response.addCookie(usernameCookie);
                
                
                LoginDao loginDao = new LoginDao();

                String image = loginDao.getImageUrlByUsername(username);
                
                Cookie imageUrlCookie = new Cookie("image", image);
                imageUrlCookie.setMaxAge(60 * 60 * 2);
                response.addCookie(imageUrlCookie);
                
                
    			
    			// User verified
    			// Redirecting to the home page or user dashboard page
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
    	        dispatcher.forward(request, response);
    			
    			
    		} else {

    			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
    			
    		}
        }
    }
}
       
		

