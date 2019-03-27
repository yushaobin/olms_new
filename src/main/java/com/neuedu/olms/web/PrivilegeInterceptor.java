package com.neuedu.olms.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.olms.ex.InvalidParamException;
import com.neuedu.olms.mapper.TeacherMapper;
import com.neuedu.olms.po.Teacher;
import com.neuedu.olms.util.C;

public class PrivilegeInterceptor implements HandlerInterceptor{
	private static Logger log = Logger.getLogger(PrivilegeInterceptor.class);
	private static List<String> whiteList = new ArrayList<String>();
	private static String PROJECT_NAME = "/olms/";
	static {
		whiteList.add("teacher/login");
	}
	
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private ObjectMapper objectMapper;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI().replace(PROJECT_NAME, "");
		
		//��������֤
		if(whiteList.contains(uri)) {
			log.info("ͨ����������֤.");
			return true;
		}
		
		//��ȡ��ʦ��Ϣ
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute(C.USER_FLAG);
		
		try {
			if(teacher == null) {
				//Ҫôû��¼��Ҫôsession�Ѿ�����
				//1����ȡ�û�token
				String token = request.getParameter("token");
				//��token�����ڣ����Դ�cookie�л�ȡ
				if(token == null) {
					Cookie[] cookies = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if(cookie.getName().equals("token")) {
								token = cookie.getValue();
								break;
							}
						}
					}
				}
				
				if(token == null) {
					throw new InvalidParamException(ExInfo.USER_NO_LOGIN_CODE, ExInfo.USER_NO_LOGIN_MSG);
				}
				
				//����session��û��teacher��Ϣ������token����
				//����token���ҽ�ʦ��Ϣ
				teacher = teacherMapper.getTeacherByToken(token);
				if(teacher == null) {
					throw new InvalidParamException(ExInfo.USER_NO_LOGIN_CODE, ExInfo.USER_NO_LOGIN_MSG);
				}
				
				session.setAttribute(C.USER_FLAG, teacher);
			}
		} catch(InvalidParamException e) {
			//
			ApiResult ars = ApiResult.build().setCode(e.getCode()).setMsg(e.getMsg());
			String rs = objectMapper.writeValueAsString(ars);
			response.getWriter().print(rs);
			log.info("�����û���" + rs);
			return false;
		}
		//Ȩ����֤
		log.info("Ȩ����֤...");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
