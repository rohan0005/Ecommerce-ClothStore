package model;

import java.io.File;


import javax.servlet.http.Part;

import resources.MyConstants;

public class CartModel {
	
	public class CartItem {
	     int c_id;
	     int id;
	     String username;
	     String name;
	     String brand;
	     int price;
	     int quantity;
	     int total;
	     String imageUrlFromPart;
	     String imageUrl;
	     
	     
	     
	     
	     
	     
	  // Constructor that takes 3 arguments for updating cart
	     public CartItem(int c_id, int quantity, int total) {
	         this.c_id = c_id;
	         this.quantity = quantity;
	         this.total = total; 
	     }

	     	
	     //c_id primary key of cart
	     //id foreign key of products
	     //public CartItem (int id2, String name2, int price2, String brand2, int price3, int total2, String imageUrl2, int quantity2) {}
	     
	 
	     public CartItem(int id, String username, String name, int price, String brand, int quantity, int total, String imageUrl, int c_id) {
	         this.id = id;
	         this.username = username;
	         this.name = name;
	         this.price = price;
	         this.brand = brand;
	         this.quantity = quantity;
	         this.total = total;
	         this.imageUrlFromPart = imageUrl;
	         this.c_id = c_id;
	     }

	     
	     
	     
	     
	     
	     
	     
	 	public CartItem(int id, String username, String name,String brand, int price, int quantity, int total, Part part,  int c_id) {
	
	        this.id = id;
	        this.username = username;
	        this.name = name;
	        this.brand = brand;
	        this.price = price;
	        this.quantity = quantity;
	        this.total = total;
	        this.imageUrlFromPart = getImageUrl(part);  
	        this.c_id = c_id;
	    }



	 	// FOR DISPLAYING CART TO THAT PARTICULAE USER
		public CartItem(int c_id, int id, String uname, String name, String brand, int price, int quantity,
				int total, String imageUrl) {
			
			this.id = id;
	         this.username = uname;
	         this.name = name;
	         this.price = price;
	         this.brand = brand;
	         this.quantity = quantity;
	         this.total = total;
	         this.imageUrl = imageUrl;
	         this.c_id = c_id;
			
		}

		//FOR DELETING ITEM IN CART	


		public CartItem(int c_id,int id) {
			this.c_id = c_id;
			this.id = id;
			// TODO Auto-generated constructor stub
		}


		public int getC_id() {
			return c_id;
		}

		public void setC_id(int c_id) {
			this.c_id = c_id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}
		


		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		

		public String getImageUrlFromPart() {
			return imageUrlFromPart;
		}


		public void setImageUrlFromPart(Part part) {
			this.imageUrlFromPart = getImageUrl(part);
		}


			
		private String getImageUrl(Part part) {
			// TODO Auto-generated method stub
			String savePath = MyConstants.IMAGE_DIR_SAVE_PATH;
			File fileSaveDir = new File(savePath);
			String imageUrlFromPart = null;
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			String contentDisp = part.getHeader("content-disposition");
			String[] items = contentDisp.split(";");
			for (String s : items) {
				if (s.trim().startsWith("filename")) {
					imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
				}
			}
			if(imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
				imageUrlFromPart= "download.png";
			}
			return imageUrlFromPart;
			}
		}
	}

