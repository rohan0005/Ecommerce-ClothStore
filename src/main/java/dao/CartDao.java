package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DbConnection;
import model.CartModel;
import model.CartModel.CartItem;
import model.UpdateProduct;
import resources.MyConstants;

public class CartDao  {
//implements CartModelImp   {
	    
	
	//database connection 
	DbConnection dbConnection = new DbConnection();
    Connection connection = null;
    
    
    public void addCartItem(CartItem cartItem) {
        try {
        	try {
				connection = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
            String query = MyConstants.ADD_TO_CART;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cartItem.getId());
            ps.setString(2, cartItem.getUsername());
            ps.setString(3, cartItem.getName());
            ps.setString(4, cartItem.getBrand());
            ps.setInt(5, cartItem.getPrice());
            ps.setInt(6, cartItem.getQuantity());
            ps.setInt(7, cartItem.getTotal());
            ps.setString(8, cartItem.getImageUrlFromPart());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       
    }
    
    
    
    //UPDATE THE CART ITEM
    public void updateCartItem(CartItem cartItem) {
        try {
        	
        	try {
				connection = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
            String query = MyConstants.UPDATE_CART;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cartItem.getQuantity());
            ps.setInt(2, cartItem.getTotal());
            ps.setInt(3, cartItem.getC_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    //DELETE THE ITEM FROM CART
    public void deleteCartItem(CartItem cartItem) {
        try {
        	
        	try {
				connection = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
            String query = MyConstants.DELETE_CART_ITEM;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, cartItem.getC_id());
            ps.setInt(2, cartItem.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    //GET ALL THE CART ITEMS
    public List<CartItem> getAllCartItems(String username) {
        List<CartItem> cartItems = new ArrayList<>();
        try {
        	
        	try {
				connection = DbConnection.getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
            String query = MyConstants.GET_ALL_ITEM_FROM_CART;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int c_id = rs.getInt("c_id");
                
                int id = rs.getInt("id");
                String uname = rs.getString("username");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int total = rs.getInt("total");
                String imageUrl = rs.getString("image");
                
                CartModel cartModel = new CartModel();
                
                // object creation
                CartItem cartItem = cartModel.new CartItem(c_id, id, uname, name, brand, price, quantity, total, imageUrl);
                cartItems.add(cartItem);
                
    
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }
    
    
    
    
    // GET TOTAL PRODUCT
    
    public int getTotalCartPrice(String username) {
        int total = 0;
        try {
            String sql = "SELECT SUM(total) as total FROM cart WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    
    
    
    
    // GETTING PRODUCT DETAILS BY USING PRODUCT ID
    
    public UpdateProduct getProductById(int id) {
    
    	try {
			connection = DbConnection.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	
    	UpdateProduct product = null;
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new UpdateProduct();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setBrand(rs.getString("brand"));
                product.setPrice(rs.getInt("price"));
                product.setImageUrl(rs.getString("image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    	
    	
}
    
 
