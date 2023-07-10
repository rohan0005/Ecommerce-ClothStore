package resources;

import java.io.File;




public class MyConstants {
	//start region: database config
		public static final String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
		public static final String DB_URL = "jdbc:mysql://localhost:3306/luxlooks";
		public static final String DB_USER_NAME = "root";
		public static final String DB_USER_PASSWORD = "";
		
		//New user image upload    C:\\xampp\\xampp\\tomcat\\apache-tomcat-8.0.36\\webapps\\image
		public static final String IMAGE_DIR = "\\xampp\\xampp\\tomcat\\webapps\\images\\";
		public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR;
		//start region: database config
		
		//start Region: Query
		
		public static final String GET_FIRST_LAST_NAME_BY_USERNAME = "SELECT first_name, last_name FROM register WHERE username=?";
		
		
		public static final String GET_IMAGEURL_BY_USERNAME = "SELECT image FROM register WHERE username=?";
		
		
		public static final String CHECK_LOGIN_INFO = "SELECT username, password"
				+ "FROM register WHERE username=? AND password=?";
		public static final String NEW_USER_REGISTER ="INSERT INTO register"
				+ "(first_name, last_name, email, username, password, image) VALUES"
				+ "(?,?,?,?,?,?)";
		public static final String GET_USER_BY_USERNAME = "SELECT * FROM register where username = ?";
		
		public static final String ADD_NEW_PRODUCT = "INSERT INTO products (id, name, brand, price, image) VALUES (?, ?, ?, ?, ?);";
		
		public static final String GET_All_PRODUCTS = "SELECT * FROM products";
		
		public static final String ADD_TO_CART = 
		"INSERT INTO cart (id, username, name, brand, price, quantity, total, image) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		public static final String UPDATE_CART = "UPDATE cart SET quantity = ?, total = ? WHERE c_id = ?";
		
		public static final String DELETE_CART_ITEM ="DELETE FROM cart WHERE c_id = ? AND id = ?";
		
		
		public static final String GET_ALL_ITEM_FROM_CART = "SELECT * FROM cart WHERE username = ?";
		
		public static final String UPDATE_USER_DETAILS = "UPDATE register SET first_name=?, last_name=?, email=?, password=? WHERE username=?";
		
		
		public static final String SEARCH_BY_BRAND = "SELECT * FROM products WHERE brand LIKE ?";
		
		public static final String SEARCH_BY_PRICE = "SELECT * FROM products WHERE price <=?";

		public static final String GET_IMAGEURL_FROM_USERNAME = "SELECT image FROM register WHERE username = ?";
		
		
		public static final String DELECT_PRODUCT_BY_ID = "DELETE FROM products WHERE id = ?";
		
	
		//end Region: Query
}
		