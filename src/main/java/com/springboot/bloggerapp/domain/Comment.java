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
	private String username;
	private int blogId;
	private String commentBody;
	private Date createdDate;

	public Comment() {
		super();
	}

	public Comment(String username, int blogId, String commentBody) {
		super();
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Comment [commentId=" + commentId + ", username=" + username + ", blogId=" + blogId + ", commentBody="
				+ commentBody + ", createdDate=" + createdDate + "]";
	}

}
