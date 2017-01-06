package org.model;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String username; //�û���
	private String password; //����
	private String sex; //�Ա�
	private String email; //��������
	private String icq; //icq
	private String signature; //ǩ����
	private String grade; //�ȼ�Ȩ��: 0��ͨ�û�,1 ����, 2����Ա

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String sex, String email) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
	}

	/** full constructor */
	public User(String username, String password, String sex, String email,
			String icq, String signature, String grade) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.icq = icq;
		this.signature = signature;
		this.grade = grade;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcq() {
		return this.icq;
	}

	public void setIcq(String icq) {
		this.icq = icq;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}