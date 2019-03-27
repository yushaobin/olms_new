package com.neuedu.olms.web;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult{
	private int code;
	private String msg;
	private Object data;
	
	
	public int getCode() {
		return code;
	}
	public ApiResult setCode(int code) {
		this.code = code;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public ApiResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getData() {
		return data;
	}
	public ApiResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	public static ApiResult build() {
		ApiResult rs = new ApiResult();
		rs.setCode(ExInfo.SUCCESS_CODE).setMsg(ExInfo.SUCCESS_MSG);
		return rs;
	}
	
	@Override
	public String toString() {
		return "ApiResult [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
