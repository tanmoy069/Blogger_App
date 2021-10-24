package com.springboot.bloggerapp.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;
	private String username;
	private boolean isCompleteApproval;
	private boolean isApprove;
	private int categoryId;
	private String blogBody;
	private Date createdDate;

	public Blog() {
		super();
	}

	public Blog(String username, boolean isApprove, int categoryId, String blogBody, Date createdDate) {
		super();
		this.username = username;
		this.isCompleteApproval = false;
		this.isApprove = isApprove;
		this.categoryId = categoryId;
		this.blogBody = blogBody;
		this.createdDate = Calendar.getInstance().getTime();
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isCompleteApproval() {
		return isCompleteApproval;
	}

	public void setCompleteApproval(boolean isCompleteApproval) {
		this.isCompleteApproval = isCompleteApproval;
	}

	public boolean isApprove() {
		return isApprove;
	}

	public void setIsApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryIid(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getBlogBody() {
		return blogBody;
	}

	public void setBlogBody(String blogBody) {
		this.blogBody = blogBody;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", username=" + username + ", isCompleteApproval=" + isCompleteApproval
				+ ", isApprove=" + isApprove + ", categoryId=" + categoryId + ", blogBody=" + blogBody
				+ ", createdDate=" + createdDate + "]";
	}

}
