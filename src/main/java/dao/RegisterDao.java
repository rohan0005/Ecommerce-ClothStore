package dao;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConnection.DbConnection;
import model.RegisterModel;
import resources.MyConstants;
import resources.PasswordEncryptionWithAes;

public class RegisterDao {
	DbConnection dbConnection =new DbConnection();
	static Connection connection = null;


	public String insert(RegisterModel register)
	{
		try {
			connection = DbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result ="Data Entered Successfully";
		String query= MyConstants.NEW_USER_REGISTER;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			String encryptedPassword = PasswordEncryptionWithAes.encrypt(register.getUsername(), register.getPassword());
			
			ps.setString(1, register.getFirst_name());
            ps.setString(2, register.getLast_name()); 
            ps.setString(3, register.getEmail());
            ps.setString(4, register.getUsername());
            ps.setString(5, encryptedPassword);
            ps.setString(6, register.getImageUrlFromPart());
            ps.executeUpdate();
         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Data not entered";
		}
		return result;
		
		
	}
		
		
		public static String updateUser(RegisterModel user){
					
				try {
					connection = DbConnection.getConnection();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String result ="Updated!!!!";
				String query = MyConstants.UPDATE_USER_DETAILS;
		        try {
		        	
		        	PreparedStatement ps = connection.prepareStatement(query);
		        	
		        	String password = PasswordEncryptionWithAes.encrypt(user.getUsername(), user.getPassword());
		        	
		            ps.setString(1, user.getFirst_name());
		            ps.setString(2, user.getLast_name());
		            ps.setString(3, user.getEmail());
		            ps.setString(4, password);
		            ps.setString(5, user.getUsername());
		            ps.executeUpdate();
		        
		        	}
			
			
			
		        catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result ="Not Updated!!!!";
				}
				return result;
		
		}
}

	        
	        
	
	





