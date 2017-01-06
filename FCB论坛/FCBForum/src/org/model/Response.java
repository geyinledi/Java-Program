package org.model;

import java.util.Date;

/**
 * Response entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Response implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private String author;
	private Date submittime;
	private Integer topicid;

	// Constructors

	/** default constructor */
	public Response() {
	}

	/** minimal constructor */
	public Response(Integer id, String title, String author, Date submittime,
			Integer topicid) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.submittime = submittime;
		this.topicid = topicid;
	}

	/** full constructor */
	public Response(Integer id, String title, String content, String author,
			Date submittime, Integer topicid) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.submittime = submittime;
		this.topicid = topicid;
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

	public Integer getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

}