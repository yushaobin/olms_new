package com.neuedu.olms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.olms.po.Course;

public interface CourseMapper {
	/**
	 * ��ӿγ�
	 * 
	 * @param course
	 */
	public void add(Course course);
	
	public int getCourseByKeywordCount(@Param("keyword") String keyword);
	
	/**
	 * ��ҳ��ѯ
	 * @param keyword
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Course> getCourseByKeyword(@Param("keyword") String keyword, @Param("begin") int begin,
			@Param("pageSize") int pageSize);
	
	/**
	 * ���Ŀγ�
	 * @param course
	 */
	public void update(Course course);
	
	/**
	 * ͨ��ID��ѯ�γ�
	 * @param id
	 * @return
	 */
	public Course getCourseById(Long id);
}