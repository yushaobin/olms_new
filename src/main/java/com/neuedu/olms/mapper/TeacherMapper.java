package com.neuedu.olms.mapper;

import com.neuedu.olms.po.Teacher;

public interface TeacherMapper {
	/**
	 * ��ӽ�ʦ
	 * @param teacher
	 */
	public void add(Teacher teacher);
	
	/**
	 * ���ݵ绰�ź����ѯ��ʦ
	 * @param tel
	 * @return
	 */
	public Teacher getTeacherByTel(String tel);
	
	/**
	 * ����token���ҽ�ʦ��Ϣ
	 * @param token
	 * @return
	 */
	public Teacher getTeacherByToken(String token);
}