package com.neuedu.olms.service;

import com.neuedu.olms.po.Teacher;

public interface TeacherService {
	/**
	 * 添加教师
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	
	/**
	 * 判断手机号是否已经注册
	 * @param tel
	 * @return
	 */
	public boolean hasTelExists(String tel);
	
	/**
	 * 用户登录
	 * @param tel
	 * @param pwd
	 * @return
	 */
	public Teacher login(String tel,String pwd);
}
