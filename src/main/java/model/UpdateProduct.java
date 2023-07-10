package model;

import resources.MyConstants;

import java.io.File;

import javax.servlet.http.Part;

public class UpdateProduct {
	
	int id;
	String name;
	String brand;
	int price;
	String imageUrlFromPart;
	String imageUrl;


	public UpdateProduct(int id) {
		this.id= id;
		
	}
	
	//code for just fetch data without image
	
	//for retriving Image Url 
	public String getImageUrl() {
		return imageUrl;
	}
	
	
	
	
	public UpdateProduct( int id, String name, String brand, int price, String imageUrl) {
        this.id = id;
        this.name = name; 
        this.brand = brand;
        this.price = price;
        this.imageUrl = imageUrl;
        
    }
	
	
	
	public UpdateProduct( int id, String name, String brand, int price, Part part) {
        this.id = id;
        this.name = name; 
        this.brand = brand;
        this.price = price;
        this.imageUrlFromPart= getImageUrl(part);
    }



///////////////////////////////
public UpdateProduct() {
		// TODO Auto-generated constructor stub
	}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}




	public int getId() {
		return id;
	}
	
	
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}


	public void setImageUrlFromPart(Part part) {
		this.imageUrlFromPart = getImageUrl(part);
	}





		
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	

	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
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
