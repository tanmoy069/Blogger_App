package com.springboot.bloggerapp.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private int userId;
	private int blogId;
	private String commentBody;
	private Date createdDate;

}
