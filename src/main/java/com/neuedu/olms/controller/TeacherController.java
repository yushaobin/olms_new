package com.neuedu.olms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.olms.po.Teacher;
import com.neuedu.olms.service.TeacherService;
import com.neuedu.olms.util.C;
import com.neuedu.olms.web.ApiResult;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/test")
	public String test() {
		return "Hello World!";
	}
	/**
	 * 验证号码是否存在
	 * @param tel
	 * @return 如果存在，返回true，否则返回false
	 */
	@GetMapping("/validTel/{tel}")
	public ApiResult hasExistTel(@PathVariable("tel") String tel) {
		boolean rs = teacherService.hasTelExists(tel);
		
		return ApiResult.build().setData(rs);
	}
	
	@PostMapping("/add")
	public ApiResult addTeacher(@Valid Teacher teacher) {

		teacherService.addTeacher(teacher);
		return ApiResult.build();
	}
	
	@PostMapping("/login")
	public ApiResult login(HttpSession session,@RequestParam("tel") String tel,@RequestParam("pwd") String pwd) {
		Teacher teacher = teacherService.login(tel, pwd);
		session.setAttribute(C.USER_FLAG, teacher);
		Map<String,String> rs = new HashMap<String,String>();
		rs.put("token", teacher.getTokenEntity().getToken());
		return ApiResult.build().setData(rs);
	}
	
}
