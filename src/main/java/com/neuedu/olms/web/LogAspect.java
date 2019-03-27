package com.neuedu.olms.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
public class LogAspect {
	private static Logger log = Logger.getLogger(LogAspect.class);
	
	public void before() {
		ServletRequestAttributes rs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			
		HttpServletRequest request = rs.getRequest();
		log.info(request.getRemoteAddr() + "�����ַ��" + request.getRequestURI());
		Enumeration<String> keys = request.getParameterNames();
		log.info("���������");
		
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			log.info(key + ":" + request.getParameter(key));
		}
	}
	
	/**
	 * ��¼����ֵ
	 * @param retVal
	 */
	public void afterReturning(Object retVal) {
		log.info("������Ϣ��" + retVal);
	}
}
