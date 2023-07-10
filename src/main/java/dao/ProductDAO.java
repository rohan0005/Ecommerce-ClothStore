package dao;

import java.sql.Connection;


import java.sql.PreparedStatement;

import java.sql.SQLException;

import dbConnection.DbConnection;
import model.UpdateProduct;

public class ProductDAO {
	DbConnection dbConnection =new DbConnection();
	static Connection connection = null;
	

	//Deleting product
	 public void deleteProduct(int id) throws SQLException {
		 
		 try {
			connection = DbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	        String query = "DELETE FROM products WHERE id = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        }
	    }
	
	
	//Add new product to database
	public String addProduct(UpdateProduct product) {
		
		try {
			connection = DbConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		String result ="Product Added Successfully!!!";
		
		String query= "INSERT INTO products(id, name, brand, price, image) VALUES (?, ?, ?, ?, ?)";
				//ADD_NEW_PRODUCT;
		
		try {
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setInt(1, product.getId());
	        ps.setString(2, product.getName());
	        ps.setString(3, product.getBrand());
	        ps.setInt(4, product.getPrice());
	        ps.setString(5, product.getImageUrlFromPart());
	        ps.executeUpdate();
	       
	        
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="Product Not Added!!!";
		}
		return result;
	}
	
	
	
	 public static String updateProduct(UpdateProduct product) {
		 
		 
		 
		 	String result ="Product Added Successfully!!!";
		 	
		 	try {
				connection = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 	
			
	        try {
	            // Create the SQL statement to update the product in the database
	            String sql = "UPDATE products SET name = ?, brand = ?, price = ?, image = ? WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, product.getName());
	            statement.setString(2, product.getBrand());
	            statement.setDouble(3, product.getPrice());
	            statement.setString(4, product.getImageUrl());
	            statement.setInt(5, product.getId());

	            // Execute the statement and update the product in the database
	            statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            result="Product Not Updated!!!";
	            
	        }
			return result;
	        
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UpdateProduct findProductUsingId(String query,int id)
	{
		return null;
	}
}