package com.neuedu.olms.web;

public class ExInfo {
	//请求成功
	public static int SUCCESS_CODE = 200;
	public static String SUCCESS_MSG = "success";
	
	//请求参数错误
	public static int PARAM_ERROR_CODE = 1000;
	public static String PARAM_ERROR_MSG = "请求参数错误";
	
	//服务器端错误
	public static int SERVER_ERROR_CODE = 500;
	public static String SERVER_ERROR_MSG = "服务器端错误";
	
	//用户名或密码错误
	public static int USER_ACCOUNT_ERROR_CODE = 1001;
	public static String USER_ACCOUNT_ERROR_MSG = "用户名或密码错误";
	
	//用户未登录
	public static int USER_NO_LOGIN_CODE = 1002;
	public static String USER_NO_LOGIN_MSG = "未登录";
}
