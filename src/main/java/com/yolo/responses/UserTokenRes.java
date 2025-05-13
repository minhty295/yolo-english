package com.yolo.responses;



public class UserTokenRes {
	private String email;
	
	private String role;
	
	private String assetToken;
	
	private String refeshToken;
	
	
	public UserTokenRes() {
		super();
	}
	
	
	public UserTokenRes(String email, String role, String assetToken, String refeshToken) {
		super();
		this.email = email;
		this.role = role;
		this.assetToken = assetToken;
		this.refeshToken = refeshToken;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAssetToken() {
		return assetToken;
	}
	public void setAssetToken(String assetToken) {
		this.assetToken = assetToken;
	}
	public String getRefeshToken() {
		return refeshToken;
	}
	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}

	
}
