package model;

import java.io.File;


import javax.servlet.http.Part;

import resources.MyConstants;

public class RegisterModel{
	
	
	
	 String first_name;
	 String last_name;
	 String email;
	 String password;
	 String username;
	 String imageUrlFromPart;
	 
	 public RegisterModel () {}
	 
	 
	 public RegisterModel(String first_name, String last_name, String email, String password, String username) {
		    this.first_name = first_name;
		    this.last_name = last_name;
		    this.email = email;
		    this.password = password;
		    this.username = username;
		}

	 
	 

	public RegisterModel(String first_name, String last_name, String email, String username, String password, Part part) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.imageUrlFromPart = getImageUrl(part);
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
