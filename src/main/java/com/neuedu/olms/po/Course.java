package com.neuedu.olms.po;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class Course {
	private Long id;
	@NotEmpty(message="课程名称不能为空")
	private String courseName;
	@NotEmpty(message="课程描述不能为空")
	private String courseDesc;
	private Teacher createUser;
	private String wrapperImg;
	//0 未发布  1发布  2删除
	private int status;
	private Date createTime;
	private Date updateTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public Teacher getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Teacher createUser) {
		this.createUser = createUser;
	}
	public String getWrapperImg() {
		return wrapperImg;
	}
	public void setWrapperImg(String wrapperImg) {
		this.wrapperImg = wrapperImg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDesc=" + courseDesc + ", createUser="
				+ createUser + ", wrapperImg=" + wrapperImg + ", status=" + status + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
}
