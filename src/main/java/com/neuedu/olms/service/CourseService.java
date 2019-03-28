package com.neuedu.olms.service;

import com.neuedu.olms.po.Course;
import com.neuedu.olms.web.PageData;

public interface CourseService {
	/**
	 * ��ӿγ�
	 * @param course
	 */
	public void addCourse(Course course);
	
	/**
	 * ��ҳ��ʾ�γ���Ϣ
	 * @param keyword
	 * @param pageSize
	 * @param curPage
	 * @return
	 */
	public PageData<Course> list(String keyword,int pageSize,int curPage);
	
	/**
	 * ���¿γ�
	 * @param course
	 */
	public void update(Course course);
}
