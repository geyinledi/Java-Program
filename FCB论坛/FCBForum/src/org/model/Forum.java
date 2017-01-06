package org.model;

/**
 * Forum entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Forum implements java.io.Serializable {

	// Fields

	private Integer id;
	private String forumname;
	private String manager;

	// Constructors

	/** default constructor */
	public Forum() {
	}

	/** minimal constructor */
	public Forum(Integer id, String forumname) {
		this.id = id;
		this.forumname = forumname;
	}

	/** full constructor */
	public Forum(Integer id, String forumname, String manager) {
		this.id = id;
		this.forumname = forumname;
		this.manager = manager;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForumname() {
		return this.forumname;
	}

	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}