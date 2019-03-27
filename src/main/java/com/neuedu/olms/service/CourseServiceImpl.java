package com.neuedu.olms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.olms.mapper.CourseMapper;
import com.neuedu.olms.po.Course;
import com.neuedu.olms.web.PageData;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	
	public void addCourse(Course course) {
		
		courseMapper.add(course);
	}
	
	
	public PageData<Course> list(String keyword, int pageSize, int curPage) {
		int begin = (curPage - 1) * pageSize;
		int total = courseMapper.getCourseByKeywordCount(keyword);
		List<Course> data = courseMapper.getCourseByKeyword(keyword,begin,pageSize);
		PageData<Course> pages = new PageData<Course>(pageSize, curPage);
		pages.setTotalRecourd(total);
		pages.setData(data);
		return pages;
	}
	
	
}
