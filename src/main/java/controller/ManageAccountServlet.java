package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;
import model.RegisterModel;

/**
 * Servlet implementation class ManageAccountServlet
 */
@WebServlet("/ManageAccountServlet")
public class ManageAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		
		String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String new_password = request.getParameter("new_password");
       
        
        
        RegisterModel user = new RegisterModel();
        
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setEmail(email);
        user.setPassword(new_password);
        user.setUsername(username);
        

       // RegisterModel registerDao = new  RegisterModel(first_name, last_name, email, password, username);
      
        //RegisterDao registerDao = new RegisterDao();
        RegisterDao.updateUser(user);
        
        
        String message = "Your account has been updated successfully.";
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/manageAccount.jsp");
        dispatcher.forward(request, response);
	}
}
