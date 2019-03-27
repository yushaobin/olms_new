package com.neuedu.olms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neuedu.olms.ex.InvalidParamException;
import com.neuedu.olms.po.Course;
import com.neuedu.olms.po.Teacher;
import com.neuedu.olms.service.CourseService;
import com.neuedu.olms.util.C;
import com.neuedu.olms.util.FileUtil;
import com.neuedu.olms.web.ApiResult;
import com.neuedu.olms.web.ExInfo;
import com.neuedu.olms.web.PageData;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/add")
	public ApiResult add(HttpServletRequest req,@Valid Course course,@RequestPart("wrapper") MultipartFile wrapper) {
		if(wrapper.isEmpty()) {
			throw new InvalidParamException(ExInfo.IMG_WRAPPER_ERROR_CODE,ExInfo.IMG_WRAPPER_ERROR_MSG);
		}
		
		String wrapperImg = FileUtil.fileUpload(req, wrapper);
		course.setWrapperImg(wrapperImg);
		course.setStatus(C.STATUS_NO_PUBLISH);
		
		Teacher user = (Teacher)req.getSession().getAttribute(C.USER_FLAG);
		course.setCreateUser(user);
		
		courseService.addCourse(course);
		
		return ApiResult.build();
	}
	
	@GetMapping("/list")
	public ApiResult list(String keyword,Integer curPage,Integer pageSize) {
		curPage = (curPage == null) ? 1 : curPage;
		pageSize = (pageSize == null) ? 10 : pageSize;
		keyword = (keyword == null) ? "" : keyword;
		PageData<Course> courses = courseService.list(keyword, pageSize, curPage);
		return ApiResult.build().setData(courses);
	}
}
