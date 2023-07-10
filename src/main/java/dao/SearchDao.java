package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DbConnection;
import model.UpdateProduct;
import resources.MyConstants;

public class SearchDao {

	
	DbConnection dbConnection = new DbConnection();
    Connection connection = null;
    
    //SEARCH
    public List<UpdateProduct> searchProducts(String query, String category) throws SearchException {
        List<UpdateProduct> productList = new ArrayList<>();
        
        try {
			connection = DbConnection.getConnection();
			
			PreparedStatement statement;

            if("price".equalsIgnoreCase(category)) {
            	
            	int price = 0;
            	
            	try {
            		price = Integer.parseInt(query);
                } catch (NumberFormatException e) {
                                    	
                	throw new SearchException("An error occurred while searching for products.", e);
                }
            	
            	if (productList.isEmpty()) {
                    throw new SearchException("No products were found for your search criteria.", null);
                }

            	
                // Searching products by price
                String sql = MyConstants.SEARCH_BY_PRICE;
                statement = connection.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(query));
                
            } else {
                // Searching products by brand
                String sql = MyConstants.SEARCH_BY_BRAND;
                
                statement = connection.prepareStatement(sql);
                statement.setString(1, "%" + query + "%");
            }
            
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // Create a new Product object for each result
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                String imageUrl = rs.getString("image");

                UpdateProduct product = new UpdateProduct(id, name, brand, price, imageUrl);
                productList.add(product);
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productList;
            
    }		

}
