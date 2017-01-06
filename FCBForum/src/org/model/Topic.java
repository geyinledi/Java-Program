package org.model;

import java.util.Date;

/**
 * Topic entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private String author;
	private Date submittime;
	private Integer forumid;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(Integer id, String title, String author, Date submittime,
			Integer forumid) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.submittime = submittime;
		this.forumid = forumid;
	}

	/** full constructor */
	public Topic(Integer id, String title, String content, String author,
			Date submittime, Integer forumid) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.submittime = submittime;
		this.forumid = forumid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getSubmittime() {
		return this.submittime;
	}

	public void setSubmittime(Date submittime) {
		this.submittime = submittime;
	}

	public Integer getForumid() {
		return this.forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

}