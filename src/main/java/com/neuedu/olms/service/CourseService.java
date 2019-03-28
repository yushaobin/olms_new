package com.neuedu.olms.service;

import com.neuedu.olms.po.Course;
import com.neuedu.olms.web.PageData;

public interface CourseService {
	/**
	 * 添加课程
	 * @param course
	 */
	public void addCourse(Course course);
	
	/**
	 * 分页显示课程信息
	 * @param keyword
	 * @param pageSize
	 * @param curPage
	 * @return
	 */
	public PageData<Course> list(String keyword,int pageSize,int curPage);
	
	/**
	 * 更新课程
	 * @param course
	 */
	public void update(Course course);
}
