package com.neuedu.olms.service;

import com.neuedu.olms.po.Teacher;

public interface TeacherService {
	/**
	 * ��ӽ�ʦ
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	
	/**
	 * �ж��ֻ����Ƿ��Ѿ�ע��
	 * @param tel
	 * @return
	 */
	public boolean hasTelExists(String tel);
	
	/**
	 * �û���¼
	 * @param tel
	 * @param pwd
	 * @return
	 */
	public Teacher login(String tel,String pwd);
}
