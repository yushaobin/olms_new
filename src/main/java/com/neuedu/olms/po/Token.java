package com.neuedu.olms.po;

import java.util.Date;

public class Token {
	private Long userId;
	private String token;
	private Date loginTime;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	@Override
	public String toString() {
		return "Token [userId=" + userId + ", token=" + token + ", loginTime=" + loginTime + "]";
	}
}
