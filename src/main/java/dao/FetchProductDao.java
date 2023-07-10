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

public class FetchProductDao {
    DbConnection dbConnection = new DbConnection();
    Connection connection = null;

    public List<UpdateProduct> getAllProducts(){
        List<UpdateProduct> productList = new ArrayList<>();

        try {
            connection = DbConnection.getConnection();
            	
            	String query = MyConstants.GET_All_PRODUCTS;
            
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String brand = rs.getString("brand");
                    int price = rs.getInt("price");
                    String imageUrl = rs.getString("image");
                    //String imageUrl = rs.getString("image");
                    
                
                    
                    UpdateProduct updateProduct = new UpdateProduct(id,name,brand,price,imageUrl);
                    productList.add(updateProduct);
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
