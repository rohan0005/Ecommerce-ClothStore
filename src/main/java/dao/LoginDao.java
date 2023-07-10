package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConnection.DbConnection;
import resources.MyConstants;
import resources.PasswordEncryptionWithAes;

public class LoginDao {
	
	// calling PasswordEncryption 
	public static boolean authenticateUser(String username, String password)
	
	{
		try {
			Connection con = DbConnection.getConnection();
			
			PreparedStatement pr = con.prepareStatement(MyConstants.GET_USER_BY_USERNAME);
			
			pr.setString(1, username);
			
			ResultSet rs = pr.executeQuery();
			
			
			//checking is the user is valid or not
			if (rs.next())
			{
				
				 //retrieving encrypted password from PasswordEncryption class
				String encryptedPassword = rs.getString("password");
				
				//decrypting password
				String decPass = PasswordEncryptionWithAes.decrypt(encryptedPassword, username);
				
		
				 // Comparing the both decrypted password
				
				if (username.equals(username) && decPass.equals(password))
				{
					

					return true;
					
					
				}
				
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Authentication failed
		return false;
	}
	
	
	
	
	
	public String getImageUrlByUsername(String username) {
	    String image = null;

	    try {
	        
	    	Connection con = null;
			try {
				con = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	PreparedStatement pr = con.prepareStatement(MyConstants.GET_IMAGEURL_FROM_USERNAME);
	    	
	        
	        pr.setString(1, username);
	        ResultSet rs = pr.executeQuery();

	        // If a record was found, retrieve the image URL from the result set
	        if (rs.next()) {
	            image = rs.getString("image");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return image;
	}
	
}
