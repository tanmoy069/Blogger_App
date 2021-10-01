package com.springboot.bloggerapp.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private int userId;
	private int blogId;
	private String commentBody;
	private Date createdDate;

	public Comment() {
		super();
	}

	public Comment(int userId, int blogId, String commentBody, Date createdDate) {
		super();
		this.userId = userId;
		this.blogId = blogId;
		this.commentBody = commentBody;
		this.createdDate = Calendar.getInstance().getTime();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getCommentBody() {
		return commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", blogId=" + blogId + ", commentBody="
				+ commentBody + ", createdDate=" + createdDate + "]";
	}

}
