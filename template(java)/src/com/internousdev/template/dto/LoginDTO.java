package com.internousdev.template.dto;

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;

	public String getLoginId() {
		return loginId;
	}
	//loginDAOから情報がセットされる
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	//loginDAOから情報がセットされる
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}
	//loginDAOから情報がセットされる
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}
	//loginDAOからnullの場合、情報がセットされる
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
}